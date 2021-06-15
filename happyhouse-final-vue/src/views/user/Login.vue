<template>
  <div class="container">
    <!-- 제목-->
    <h1 id="menu_title">로그인</h1>
    <hr />
    <!-- 아이디-->
    <div class="form-group">
      <label for="ID">아이디</label>
      <input
        type="text"
        class="form-control"
        id="ID"
        v-model="id"
        ref="id"
        placeholder="아이디를 입력하세요."
        style="margin:0 0 0 22px"
      />
    </div>

    <!-- 비밀번호-->
    <div class="form-group">
      <label for="PassWord">비밀번호</label>
      <input
        type="password"
        class="form-control"
        id="PassWord"
        v-model="password"
        ref="password"
        @keypress.enter="check"
        placeholder="비밀번호를 입력하세요."
      />
    </div>
    <b-button type="submit" @click="check" variant="primary" style="margin:0 10px 0 0">로그인</b-button>
    <router-link to="/user/find">
      <b-button type="submit" @click="findPass" variant="warning">비밀번호찾기</b-button>
    </router-link>
  </div>
</template>

<script>
import http from '@/utils/http-common';

export default {
  data() {
    return {
      id: '',
      password: '',
      name: '',
    };
  },
  methods: {
    // 입력 체크
    check() {
      let err = true;
      let msg = '';
      !this.id && ((msg = '아이디를 입력해주세요'), (err = false), this.$refs.id.focus());
      err &&
        !this.password &&
        ((msg = '비밀번호를 입력해주세요'), (err = false), this.$refs.password.focus());

      if (!err) alert(msg);
      else this.login();
    },
    // 로그인
    login() {
      http
        .post('/happyhouse/login', {
          id: this.id,
          password: this.password,
        })
        .then((response) => {
          // ==은 타입 상관없이 비교, ===은 정확히 비교
          if (response.data.message == 'fail') {
            alert('로그인 실패!');
          } else {
            this.id = response.data.id;
            this.name = response.data.name;
            alert(this.name + '님 안녕하세요!');
            const { id, name } = this;
            this.moveMain({ id, name });
          }
        })
        .catch(() => {
          alert('로그인 실패!');
        });
    },
    // 로그인 성공
    moveMain(userName) {
      this.$store.dispatch('loginComplete', userName).then(() => {
        this.$router.push('/');
      });
    },
    // 비밀번호 찾기
    findPass() {},
  },
};
</script>

<template>
  <div class="container">
    <!-- 제목-->
    <h1 id="menu_title">비밀번호찾기</h1>
    <hr />
    <br />
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
    <!-- 비밀번호 힌트-->
    <div class="form-group">
      <label for="PassHint">비밀번호힌트</label>
      <input
        type="text"
        class="form-control"
        id="PassHint"
        v-model="passhint"
        ref="passhint"
        placeholder="비밀번호 힌트를 입력하세요."
        style="margin:0 25px 0 10px"
      />
    </div>
    <b-button type="submit" @click="check" variant="primary" style="margin:0 8px 0 0">찾기</b-button>
    <router-link to="/user"><b-button type="button" variant="secondary">취소</b-button></router-link>
  </div>
</template>

<script>
import http from '@/utils/http-common';

export default {
  data() {
    return {
      id: '',
      passhint: '',
    };
  },
  methods: {
    // 입력 체크
    check() {
      let err = true;
      let msg = '';
      !this.id && ((msg = '아이디를 입력해주세요'), (err = false), this.$refs.id.focus());
      err &&
        !this.passhint &&
        ((msg = '비밀번호 힌트를 입력해주세요'), (err = false), this.$refs.passhint.focus());

      if (!err) alert(msg);
      else this.find();
    },
    // 비밀번호 찾기
    find() {
      http
        .post('/happyhouse/findPassword', {
          id: this.id,
          passhint: this.passhint,
        })
        .then((response) => {
          alert(`${this.id}님의 비밀번호는 ${response.data} 입니다.`);
          this.$router.push('/user');
        })
        .catch(() => {});
    },
  },
};
</script>

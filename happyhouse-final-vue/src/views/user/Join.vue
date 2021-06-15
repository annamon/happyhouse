<template>
  <div class="container">
    <!-- 제목-->
    <h1 id="menu_title">회원 가입</h1>
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

    <!-- 비밀번호-->
    <div class="form-group">
      <label for="PassWord">비밀번호</label>
      <input
        type="password"
        class="form-control"
        id="PassWord"
        v-model="password"
        ref="password"
        placeholder="비밀번호를 입력하세요."
      />
    </div>

    <!-- 이름-->
    <div class="form-group">
      <label for="Name">이름</label>
      <input
        type="text"
        class="form-control"
        id="Name"
        v-model="name"
        ref="name"
        required
        placeholder="이름을 입력하세요."
        style="margin:0 0 0 36px"
      />
    </div>

    <!-- 이메일-->
    <div class="form-group">
      <label for="Email">이메일</label>
      <input
        type="text"
        class="form-control"
        id="Email"
        v-model="email"
        ref="email"
        placeholder="이메일을 입력하세요."
        style="margin:0 0 0 22px"
      />
    </div>

    <!-- 전화번호-->
    <div class="form-group">
      <label for="Number">전화번호</label>
      <input
        type="text"
        class="form-control"
        id="Number"
        v-model="number"
        ref="number"
        placeholder="전화번호를 입력하세요."
      />
    </div>

    <!-- 직업-->
    <!-- radio로 바꾸기-->
    <div class="form-group" id="JobList">
      <label for="Job" style="margin:0 40px 0 0">직업</label>
      <input type="radio" id="student" value="학생" v-model="job" />
      <label for="student">학생</label>
      <input type="radio" id="housewife" value="주부" v-model="job" />
      <label for="housewife">주부</label>
      <input type="radio" id="employee" value="직장인" v-model="job" />
      <label for="employee">직장인</label>
      <input type="radio" id="etc" value="기타" v-model="job" />
      <label for="etc" style="margin:0 26% 0 0">기타</label>
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
    <div>
      <b-button type="submit" @click="check" variant="primary" style="margin:0 8px 0 0">가입</b-button>
      <router-link to="/user"><b-button type="button" variant="secondary">취소</b-button></router-link>
      <br><br>
    </div>
  </div>
      
</template>

<script>
import http from '@/utils/http-common';

export default {
  data() {
    return {
      id: '',
      name: '',
      password: '',
      email: '',
      number: '',
      job: '',
      passhint: '',
    };
  },
  methods: {
    // 입력 체크
    check() {
      let err = true;
      let msg = '';
      !this.id && ((msg = '아이디를 입력해주세요'), (err = false), this.$refs.id.focus());
      err && !this.name && ((msg = '이름을 입력해주세요'), (err = false), this.$refs.name.focus());
      err &&
        !this.password &&
        ((msg = '비밀번호를 입력해주세요'), (err = false), this.$refs.password.focus());
      err &&
        !this.email &&
        ((msg = '이메일을 입력해주세요'), (err = false), this.$refs.email.focus());
      err &&
        !this.number &&
        ((msg = '전화번호를 입력해주세요'), (err = false), this.$refs.number.focus());
      err && !this.job && ((msg = '직업을 선택해주세요'), (err = false));
      err &&
        !this.passhint &&
        ((msg = '비밀번호의 힌트를 입력해주세요'), (err = false), this.$refs.passhint.focus());

      if (!err) alert(msg);
      else this.join();
    },
    // 회원 가입
    join() {
      http
        .post('/happyhouse/joinUser', {
          id: this.id,
          name: this.name,
          password: this.password,
          email: this.email,
          number: this.number,
          job: this.job,
          passhint: this.passhint,
        })
        .then(() => {
          alert('회원 가입이 완료 되었습니다.');
          this.moveLogin();
        })
        .catch(() => {
          alert('아이디가 중복됩니다.');
        });
    },
    // 로그인 창으로 이동.
    moveLogin() {
      this.$router.push('/user');
    },
  },
};
</script>

<style>
#ID,
#Name,
#PassWord,
#Email,
#Number,
#Job,
#PassHint {
  width: 50%;
  display: inline-block;
  margin: 0 0 5px 10px;
}

#JobList > input {
  margin: 0 3px 0 20px;
}
</style>

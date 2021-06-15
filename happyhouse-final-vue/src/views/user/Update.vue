<template>
  <div>
    <h1 id="menu_title">회원 정보 수정</h1>
    <hr />
    <!-- 아이디-->
    <div class="form-group">
      <label for="id">아이디</label>
      <input type="text" class="form-control" id="id" ref="info.id" v-model="info.id" 
      style="margin:0 0 0 22px" readonly />
    </div>
    <!-- 비밀번호-->
    <div class="form-group">
      <label for="password">비밀번호</label>
      <input
        type="password"
        class="form-control"
        id="password"
        ref="info.password"
        v-model="info.password"
      />
    </div>
    <!-- 이름-->
    <div class="form-group">
      <label for="name">이름</label>
      <input
        type="text"
        class="form-control"
        id="name"
        ref="info.name"
        v-model="info.name"
        readonly
        style="margin:0 0 0 36px"
      />
    </div>
    <!-- 이메일-->
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="text" class="form-control" id="email" ref="info.email" v-model="info.email" 
      style="margin:0 0 0 22px"/>
    </div>
    <!-- 전화번호-->
    <div class="form-group">
      <label for="number">전화번호</label>
      <input type="text" class="form-control" id="number" ref="info.number" v-model="info.number" />
    </div>
    <!-- 직업-->
    <div class="form-group" id="JobList">
      <label for="job" style="margin:0 40px 0 0">직업</label>
      <input type="radio" id="student" value="학생" v-model="info.job" />
      <label for="student">학생</label>
      <input type="radio" id="housewife" value="주부" v-model="info.job" />
      <label for="housewife">주부</label>
      <input type="radio" id="employee" value="직장인" v-model="info.job" />
      <label for="employee">직장인</label>
      <input type="radio" id="etc" value="기타" v-model="info.job" />
      <label for="etc" style="margin:0 26% 0 0">기타</label>
    </div>
    <!-- 비밀번호힌트-->
    <div class="form-group">
      <label for="passhint">비밀번호힌트</label>
      <input
        type="text"
        class="form-control"
        id="passhint"
        ref="info.passhint"
        v-model="info.passhint"
        style="margin:0 25px 0 10px"
      />
    </div>
    <div>
      <button class="btn btn-success" @click="updateUser" style="margin:0 8px 0 0">수정</button>
      <button class="btn btn-secondary" @click="moveRead">취소</button>
    </div>
    <br>
  </div>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';

export default {
  name: 'user-update',
  data() {
    return {
      info: {
        id: '',
        name: '',
        password: '',
        email: '',
        job: '',
        number: '',
        passhint: '',
      },
    };
  },
  methods: {
    updateUser() {
      http
        .put(`/happyhouse/updateUser/${this.info.id}`, {
          id: this.info.id,
          name: this.info.name,
          password: this.info.password,
          email: this.info.email,
          number: this.info.number,
          job: this.info.job,
          passhint: this.info.passhint,
        })
        .then(() => {
          alert('수정이 완료되었습니다.');
          this.moveRead();
        })
        .catch(() => {
          alert('아이디가 중복됩니다.');
        });
    },
    moveRead() {
      this.$router.push('/user/read');
    },
  },
  // 회원 정보
  created() {
    http
      .post('/happyhouse/detailUser', {
        id: this.user.userId,
      })
      .then((response) => {
        this.info = response.data;
      })
      .catch(() => {
        alert('회원 정보를 불러올 수 없습니다!');
      });
  },
  computed: {
    ...mapGetters(['user']),
  },
};
</script>

<style>
#id,
#name,
#password,
#email,
#number,
#job,
#passhint {
  width: 50%;
  display: inline-block;
  margin: 0 0 5px 10px;
}

#JobList > input {
  margin: 0 3px 0 20px;
}

</style>

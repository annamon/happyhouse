<template>
  <div>
    <!-- 회원 정보 수정, 탈퇴, 비밀번호 찾기-->
    <!-- 제목-->
    <h1 id="menu_title">회원 정보</h1>
    <hr />
    <table class="table table-bordered">
      <tr>
        <th id="ths">아이디</th>
        <td>{{ info.id }}</td>
      </tr>
      <tr>
        <th id="ths">이름</th>
        <td>{{ info.name }}</td>
      </tr>
      <tr>
        <th id="ths">이메일</th>
        <td>{{ info.email }}</td>
      </tr>
      <tr>
        <th id="ths">직업</th>
        <td>{{ info.job }}</td>
      </tr>
      <tr>
        <th id="ths">전화번호</th>
        <td>{{ info.number }}</td>
      </tr>
      <tr>
        <th id="ths">비밀번호 힌트</th>
        <td>{{ info.passhint }}</td>
      </tr>
      <tr>
        <th id="ths">가입 날짜</th>
        <td>{{ info.joindate }}</td>
      </tr>
    </table>

    <div class="text-center" style="float: rigth">
      <router-link to="/user/update">
        <button class="btn btn-success" style="margin: 0 10px 0 0">수정</button>
      </router-link>
      <!-- 관리자인 경우 회원목록 조회 가능-->
      <router-link to="/user/list">
        <button class="btn btn-danger" @click="moveList" v-if="user.userId == 'ssafy'">
          회원 목록
        </button>
      </router-link>
      <!-- 관리자인 경우는 아이디 삭제 불가능-->
      <router-link to="/user">
        <button class="btn btn-danger" @click="deleteUser" v-if="user.userId != 'ssafy'">
          탈퇴
        </button>
      </router-link>
    </div>
    <br />
  </div>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';

export default {
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
        joindate: '',
      },
    };
  },
  methods: {
    deleteUser() {
      http
        .delete(`/happyhouse/deleteUser/${this.info.id}`, {
          id: this.info.id,
        })
        .then(() => {
          this.$store.dispatch('logout');
          alert('삭제 성공');
        })
        .catch(() => {
          alert('회원 정보를 불러올 수 없습니다!');
        });
    },
    moveList() {
      this.$router.push('/user/list');
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

<style></style>

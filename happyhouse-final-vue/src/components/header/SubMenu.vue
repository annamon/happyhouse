<template>
  <div>
    <b-navbar style="padding: 0px">
      <b-navbar-nav>
        <b-nav-item><router-link to="/notice" id="menus">공지사항</router-link></b-nav-item>
        <b-nav-item><router-link to="/search" id="menus">검색</router-link></b-nav-item>
        <b-nav-item><router-link to="/board" id="menus">자유게시판</router-link></b-nav-item>
        <b-nav-item><router-link to="/estate" id="menus">소식</router-link></b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-form v-if="!user.checkLogin">
          <b-nav-item><router-link to="/user/login" id="menus">로그인</router-link></b-nav-item>
          <b-nav-item><router-link to="/user/join" id="menus">회원가입</router-link></b-nav-item>
        </b-nav-form>
        <!-- 로그아웃 로직 추가-->
        <b-nav-form v-else>
          {{ user.userName }}님 안녕하세요!
          <b-nav-item @click="logout">
            <router-link to="/user/login" id="menus">로그아웃</router-link>
          </b-nav-item>
          <b-nav-item align="end">
            <router-link to="/user/read" id="menus">회원정보</router-link>
          </b-nav-item>
          <b-nav-item align="end">
            <router-link to="/user/record" id="menus">최근본매물</router-link>
          </b-nav-item>
          <b-nav-item align="end">
            <router-link to="/user/basket" id="menus">찜목록</router-link>
          </b-nav-item>
        </b-nav-form>
      </b-navbar-nav>
      <!-- 로그아웃으로 전환-->
    </b-navbar>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  methods: {
    logout() {
      this.$store.dispatch('logout');
    },
  },
  computed: {
    ...mapGetters(['user']),
  },
};
</script>

<style>
#menus {
  text-decoration: none;
}
</style>

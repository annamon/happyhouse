<template>
  <div id="app">
    <!-- Header-->
    <div>
      <Header />
    </div>
    <!-- Content-->
    <div id="view">
      <router-view />
    </div>
    <!-- Footer-->
    <div>
      <Footer />
    </div>
  </div>
</template>
<script>
import Header from '@/layout/Header.vue';
import Footer from '@/layout/Footer.vue';
export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },
};
</script>
<style>
#app {
  font-family: BMJUA;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: white;
  background: url('~@/assets/back1.jpg') no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  /* height: 100vmax; */
  min-height: 50vmax;
}

#nav {
  padding: 30px;
}

@font-face {
  font-family: 'BMJUA';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/BMJUA.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {
  font-family: 'SDSamliphopangche_Basic';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/SDSamliphopangche_Basic.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

@import url('https://fonts.googleapis.com/css2?family=Caveat:wght@700&display=swap');

/*
BMJUA : #app 메뉴용
SDSamliphopangche_Basic : #menu_title 컴포넌트별 타이틀용
BBTreeGB : #ths 테이블 라벨
Caveat : 로고 글꼴
TmoneyRoundWindRegular : td
*/
@font-face {
  font-family: 'BBTreeGB';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_nine_@1.1/BBTreeGB.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {
  font-family: 'TmoneyRoundWindRegular';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/TmoneyRoundWindRegular.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

#menu_title {
  font-family: SDSamliphopangche_Basic;
  text-shadow: -2.5px 0 #000, 0 2.5px #000, 2.5px 0 #000, 0 -2.5px #000;
  font-size: 35px;
  color: white;
}

/* scroll bar*/
/* 스크롤바 뒷 배경 설정*/
::-webkit-scrollbar-track {
  background-color: rgba(0, 0, 0, 0);
}

/* 스크롤바 설정*/
::-webkit-scrollbar {
  width: 9px;
}

/* 스크롤바 막대 설정*/
::-webkit-scrollbar-thumb {
  height: 17%;
  background-color: rgb(151, 178, 252);
  /* 스크롤바 둥글게 설정    */
  border-radius: 10px;
}

/* 스크롤바 뒷 배경 설정*/
::-webkit-scrollbar-track {
  background-color: rgba(255, 255, 255, 0.33);
}
</style>

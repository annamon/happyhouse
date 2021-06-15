<template>
  <div>
    <h1 id="homeTitleB">어떤 집을 찾고 계시나요? </h1>
    <h3 id="homeTitle">당신이 찾던 집,</h3>
    <h3 id="homeTitle">바로 이 곳에 있습니다.</h3>
    <br>
    <div>
    <b-container>
      <b-row style="padding:0 10% 0 10%">
        <b-col>
          <div class="homeBox">
            <p style="text-decoration: none;" id="homeBoxContent">해피하우스 검색</p>
            <p id="homeBoxContent">쉽고 빠르게 원하는 집을 찾아볼 수 있습니다</p>
          <router-link to="/search">
            <img src="~@/assets/002-house.png">
          </router-link>
          </div>
        </b-col>
        <b-col>
          <div class="homeBox">
            <p id="homeBoxContent">해피하우스 커뮤니티</p>
            <p id="homeBoxContent">특별한 회원들이 모여 만들어진 특별한 커뮤니티</p>
          <router-link to="/board">
            <img src="~@/assets/001-diversity.png">
          </router-link>
          </div>
        </b-col>
        <b-col>
          <div class="homeBox">
            <p id="homeBoxContent">해피하우스 소식</p>
            <p id="homeBoxContent">한 발 앞서 부동산 소식을 접할 수 있습니다</p>
          <router-link to="/estate">
            <img src="~@/assets/003-newspaper.png">
          </router-link>
          </div>
        </b-col>
      </b-row>
    </b-container>
    <br>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
};
</script>

<style>
@font-face {
font-family: 'UhBeeSeulvely';
src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_five@.2.0/UhBeeSeulvely.woff') format('woff');
font-weight: normal;
font-style: normal;
}
#info{
  font-family: UhBeeSeulvely;
  font-size: 50px;
}

.homeBox{
  width: 100%;
  height: 100%;
  position: relative;
  padding: 32px;
  border-radius: 16px;
  cursor: pointer;
  color:white important;
  /* border: 1px solid; */
  background-color: rgb(0, 0, 0, 0.05);
  text-decoration: none;
}
a{
  color: white;
}
#homeBoxContent{
  text-align: left;
  font-size: 18px;
  text-decoration: none;
  /* text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000; */
  
}

#homeTitleB{
  color: rgb(48, 53, 65);
  text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;
}
#homeTitle{
  color: white;
  text-shadow: -1px 0 rgb(48, 53, 65), 0 1px rgb(48, 53, 65), 1px 0 rgb(48, 53, 65), 0 -1px rgb(48, 53, 65);
  /* text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000; */
}
</style>

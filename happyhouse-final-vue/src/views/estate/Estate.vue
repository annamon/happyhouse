<template>
  <b-container>
    <h1 id="menu_title">소식</h1>
    <hr />
    <div v-if="user.userId == ''">
      <h1>로그인 후 이용할 수 있는 페이지 입니다</h1>
      <router-link :to="`/`">홈으로 이동</router-link> |
      <router-link :to="`/user`">로그인 하기</router-link>
    </div>
    <div v-else>
      <b-row style="padding: 2% 10% 4% 10% ">
        <b-col>
          <div class="estateBox">
          <h4>공시지가 조회</h4>
          <a href="https://www.realtyprice.kr:447/">
            <img id="estateImg" src="~@/assets/gov.jpg">
          </a>
          </div>
        </b-col>
        <b-col>
          <div class="estateBox">
          <h4>취득세 조회</h4>
          <a href="https://www.wetax.go.kr">
            <img id="estateImg" src="~@/assets/wetax.png">
          </a>
          </div>
        </b-col>
        <b-col>
          <div class="estateBox">
          <h4>주택청약</h4>
          <a href="https://www.applyhome.co.kr">
            <img id="estateImg" src="~@/assets/re.jpg">
          </a>
          </div>
        </b-col>
        <b-col>
          <div class="estateBox">
          <h4>주택연금</h4>
          <a href="https://www.hf.go.kr/">
            <img id="estateImg" src="~@/assets/hf.jpg">
          </a>
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <div>
            <h3 class="title" id="news">부동산 뉴스</h3>
            <div class="list-group">
              <a
                class="list-group-item list-group-item-action"
                style=""
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=277&aid=0004864051"
                title="뉴스1"
                >경기지역 전세가 가파른 상승… 매매가 맹추격</a
              >
              <a
                class="list-group-item list-group-item-action"
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=015&aid=0004512123"
                title="뉴스2"
                >주민들, 신도시 반대했는데… 투기하려고 지정했나 반발</a
              >
              <a
                class="list-group-item list-group-item-action"
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=001&aid=0012255644"
                title="뉴스3"
                >경기도 '공직자 부동산 투기' 공익제보 가동</a
              >
              <a
                class="list-group-item list-group-item-action"
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=016&aid=0001805685"
                title="뉴스4"
                >서울 청약 이정도?</a
              >
            </div>
          </div>
        </b-col>
        <b-col>
          <div>
            <h3 class="title" id="news">신규 아파트</h3>
            <div class="list-group">
              <a
                class="list-group-item list-group-item-action"
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=215&aid=0000943269"
                title="소식1"
                >삼척 센트럴 두산위브</a
              >
              <a
                class="list-group-item list-group-item-action"
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=016&aid=0001805730"
                title="소식2"
                >인천 엘리웨이</a
              >
              <a
                class="list-group-item list-group-item-action"
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=025&aid=0003084440"
                title="소식3"
                >건대 더 메종</a
              >
              <a
                class="list-group-item list-group-item-action"
                href="http://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=009&aid=0004762134"
                title="소식4"
                >익산 이지움 더 테라스 아트리체</a
              >
            </div>
          </div>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  computed: {
    ...mapGetters(['user']),
  },
};
</script>

<style>
.list-group-item, .list-group-item-action {
  background-color: rgb(255, 255, 255, 0.4);
}
.list-group{
  font-family: TmoneyRoundWindRegular;
  font-size: 14px;
}
/* .news{
  width: 30%;
} */

.estateBox{
  width: 100%;
  height: 100%;
  position: relative;
  padding: 5%;
  border-radius: 16px;
  /* border: 1px solid; */
  background-color: rgba(255, 255, 255, 0.2);
  text-decoration: none;
}

#estateImg{
  border-radius: 100%;
  width: 100px;
  height: 100px;
}
</style>

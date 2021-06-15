<template>
  <b-container>
    <h1 id="menu_title">매물 검색</h1>
    <hr />
    <div v-if="user.userId == ''">
      <h1>로그인 후 이용할 수 있는 페이지 입니다</h1>
      <router-link :to="`/`">홈으로 이동</router-link> |
      <router-link :to="`/user`">로그인 하기</router-link>
    </div>
    <div v-else>
      <!-- 검색 창-->
      <div id="searchForm">
        <b-input-group class="mb-3">
          <template>
            <div>
              <b-form-select v-model="selectedCity" :options="citys"></b-form-select>
            </div>
            <div>
              <b-form-select v-model="selectedGu" :options="gus"></b-form-select>
            </div>
            <div>
              <b-form-select v-model="selectedDong" :options="dongs"></b-form-select>
            </div>
          </template>

          <b-form-input
            type="text"
            class="form-control"
            id="Keyword"
            v-model="keyword"
            @keypress.enter="check"
            ref="keyword"
            placeholder="검색어를 입력하세요."
          />
          <b-input-group-append>
            <b-button @click="check" variant="dark">
              <img src="~@/assets/house-search-button.png" id="search-button" />
            </b-button>
          </b-input-group-append>
        </b-input-group>
      </div>
      <b-row>
        <!-- 지도-->
        <b-col cols="7">
          <Map />
        </b-col>
        <!-- 검색 결과-->
        <b-col>
          <h3>검색결과</h3>
          <div>
            <table id="houseHeader" class="table table-bordered">
              <colgroup>
                <col :style="{ width: '17.5%' }" />
                <col :style="{ width: '52.9%' }" />
                <col :style="{ width: '29.6%' }" />
              </colgroup>
              <tr>
                <th id="ths">행정동</th>
                <th id="ths">아파트 이름</th>
                <th id="ths">매매가 (만원)</th>
              </tr>
            </table>
          </div>
          <div id="houseScroll">
            <table id="houseList" class="table table-bordered table-condensed">
              <colgroup>
                <col :style="{ width: '18%' }" />
                <col :style="{ width: '54%' }" />
                <col :style="{ width: '28%' }" />
              </colgroup>
              <tr v-for="(info, index) in esInfos.slice().reverse()" :key="`${index}`">
                <td>{{ info.dong }}</td>
                <td id="alignLeft">
                  <router-link
                    :to="`/search/read?aptName=${info.aptName}&dong=${info.dong}&dealAmount=${info.dealAmount}&lat=${info.lat}&lng=${info.lng}&buildYear=${info.buildYear}&area=${info.area}&no=${info.no}`"
                    >{{ info.aptName }}</router-link
                  >
                </td>
                <td id="alignLeft">
                  {{ wonPrice(info.dealAmount) }}
                </td> 
              </tr>
            </table>
          </div>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import Map from '@/components/search/Map.vue';
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';
export default {
  components: {
    Map,
  },
  data() {
    return {
      keyword: '',
      items: [],
      showDetail: {
        dong: '',
        aptName: '',
        dealAmount: '',
        lat: '',
        lng: '',
        img: '',
      },
      selectedCity: '',
      citys: [
        { value: '', text: '선택안함' },
        { value: '서울특별시', text: '서울특별시' },
        { value: '인천광역시', text: '인천광역시' },
        { value: '부산광역시', text: '부산광역시' },
        { value: '대구광역시', text: '대구광역시' },
        { value: '광주광역시', text: '광주광역시' },
        { value: '대전광역시', text: '대전광역시' },
        { value: '울산광역시', text: '울산광역시' },
        { value: '경기도', text: '경기도' },
        { value: '강원도', text: '강원도' },
        { value: '충청북도', text: '충청북도' },
        { value: '충청남도', text: '충청남도' },
        { value: '전라북도', text: '전라북도' },
        { value: '전라남도', text: '전라남도' },
        { value: '경상북도', text: '경상북도' },
        { value: '경상남도', text: '경상남도' },
        { value: '세종특별자치시', text: '세종특별자치시' },
        { value: '제주특별자치도', text: '제주특별자치도' },
      ],
      selectedGu: '',
      gus: [
        { value: '', text: '선택안함' },
        { value: '강남구', text: '강남구' },
        { value: '강동구', text: '강동구' },
        { value: '강북구', text: '강북구' },
        { value: '강서구', text: '강서구' },
        { value: '관악구', text: '관악구' },
        { value: '광진구', text: '광진구' },
        { value: '구로구', text: '구로구' },
        { value: '금천구', text: '금천구' },
        { value: '노원구', text: '노원구' },
        { value: '도봉구', text: '도봉구' },
        { value: '동대문구', text: '동대문구' },
        { value: '동작구', text: '동작구' },
        { value: '마포구', text: '마포구' },
        { value: '서대문구', text: '서대문구' },
        { value: '서초구', text: '서초구' },
        { value: '성동구', text: '성동구' },
        { value: '성북구', text: '성북구' },
        { value: '송파구', text: '송파구' },
        { value: '양천구', text: '양천구' },
        { value: '영등포구', text: '영등포구' },
        { value: '용산구', text: '용산구' },
        { value: '은평구', text: '은평구' },
        { value: '종로구', text: '종로구' },
        { value: '중구', text: '중구' },
        { value: '중랑구', text: '중랑구' },
      ],
      selectedDong: '',
      dongs: [
        { value: '', text: '선택안함' },
        { value: '개포동', text: '개포동' },
        { value: '논현동', text: '논현동' },
        { value: '대치동', text: '대치동' },
        { value: '도곡동', text: '도곡동' },
        { value: '삼성동', text: '삼성동' },
        { value: '세곡동', text: '세곡동' },
        { value: '수서동', text: '수서동' },
        { value: '신사동', text: '신사동' },
        { value: '압구정동', text: '압구정동' },
        { value: '역삼동', text: '역삼동' },
        { value: '율현동', text: '율현동' },
        { value: '일원동', text: '일원동' },
        { value: '자곡동', text: '자곡동' },
        { value: '청담동', text: '청담동' },
      ],
    };
  },
  methods: {
    check() {
      let err = true;
      let msg = '';

      if (!err) alert(msg);
      else this.search();
    },
    // 검색 데이터 가져오기
    search() {
      if (this.selectedCity == '') {
        alert('시를 선택해주세요!');
        return;
      } else if (this.selectedGu == '') {
        alert('구를 선택해주세요!');
        return;
      } else if (this.selectedDong == '') {
        alert('동을 선택해주세요!');
        return;
      }
      http
        .post('/happyhouse/house/search', {
          city: this.selectedCity,
          dong: this.selectedDong,
          gugun: this.selectedGu,
          word: this.keyword,
        })
        .then((response) => {
          this.items = response.data;
          this.$store.dispatch('addEsInfo', this.items).then(() => {});
        })
        .catch(() => {});
    },
    wonPrice(x) {
      if (x) {
        let won = x.toString().replace(/[^\d]+/g, '');
        let a = won.length;
        let price = '';
        if (a > 4) {
          price = won.substring(0, a - 4) + '억 ';
          for (let i = 0; i < 4; i++) {
            if (won.charAt(a - 4 + i) == 0) continue;
            else {
              price += won.substring(a - 4 + i, a);
              break;
            }
          }
          return price;
        } else {
          price = won;
          price.concat('만');
          return price;
        }
      }
    },
    showApt(info) {
      this.showApt.img = '@/assets/house' + Math.floor(Math.random() * 10 + 1) + '.jpg';
      alert(this.showApt.img);
      this.showDetail.aptName = info.aptName;
    },
  },
  beforeDestroy() {
    this.$store.dispatch('deleteEsInfo');
  },
  computed: {
    ...mapGetters(['user', 'esInfos']),
  },
};
</script>

<style>
#search-button {
  width: 30px;
  height: 20px;
}

#searchForm {
  width: 70%;
  margin: auto;
}

#houseHeader {
  margin-bottom: 0px;
  padding-bottom: 0px;
}
#houseScroll {
  overflow: scroll;
  margin: 10px 0 0 0;
  height: 500px;
}
#houseList {
  margin-top: 0px;
  padding-top: 0px;
}

#alignLeft {
  text-align: left;
}
</style>

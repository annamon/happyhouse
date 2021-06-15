<template>
  <b-container>
  <div>
    <h1 id="menu_title">아파트 상세정보</h1>
    <hr>
    <b-row>
      <b-col>
        <div>
        <img id="img" style="width:500px" :src="getPic()" />
        </div>
      </b-col> 
      <b-col>
        <div>
        <table class="table table-bordered" hover>
          <colgroup>
            <col :style="{ width: '30%' }" />
            <col :style="{ width: '70%' }" /> 
          </colgroup>
          <tr>
            <th id="ths">아파트이름</th>
            <td>{{ this.$route.query.aptName }}</td>
          </tr>
          <tr>
            <th id="ths">동</th>
            <td>{{ this.$route.query.dong }}</td>
          </tr>
          <tr>
            <th id="ths">가격</th>
            <td>{{ wonPrice(this.$route.query.dealAmount) }}만원</td>
          </tr>
          <tr>
            <th id="ths">건설년도</th>
            <td>{{ this.$route.query.buildYear }}년</td>
          </tr>
          <tr>
            <th id="ths" style="vertical-align: middle">
              관련 학군 <span>({{ items.length }}개)</span>
            </th>
            <td>
              <span v-for="(item, index) in items" :key="`${index}`">{{ item }},</span>
            </td>
          </tr>
        </table>
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <br>
        <br>
      <router-link :to="'/search'"
        ><b-button variant="primary" style="margin: 0 10px 0 0"> 검색으로 </b-button></router-link
      >
      <b-button variant="success" style="margin: 0 10px 0 0" @click="addBasket"> 찜하기 </b-button>
        <br>
      </b-col>
    </b-row>
  </div>
  </b-container>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';

export default {
  data() {
    return {
      rand: '@/assets/house2.jpg',
      items: [],
    };
  },
  methods: {
    getPic() {
      return require('@/assets/house' + Math.floor(Math.random() * 10 + 1) + '.jpg');
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
    addBasket() {
      http
        .post('/happyhouse/house/like', {
          id: this.user.userId,
          no: this.$route.query.no,
        })
        .then(() => {
          alert('찜 하셨습니다!');
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
  },
  created() {
    let record = {
      aptName: this.$route.query.aptName,
      dong: this.$route.query.dong,
      dealAmount: this.$route.query.dealAmount,
      buildYear: this.$route.query.buildYear,
      no: this.$route.query.no,
    };
    // 최근 본 상품 정보 추가
    this.$store.dispatch('addRecord', record);
    // 해당 상품 번호로 학군 조회
    http
      .get(`/happyhouse/house/school/${this.$route.query.no}`)
      .then((response) => {
        this.items = response.data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  computed: {
    ...mapGetters(['user']),
  },
};
</script>

<style></style>

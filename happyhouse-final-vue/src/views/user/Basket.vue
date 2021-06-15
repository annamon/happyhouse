<template>
  <div>
    <h1 id="menu_title">찜 목록</h1>
    <hr />
    <div v-if="items.length">
      <table class="table table-bordered table-condensed">
        <colgroup>
          <col :style="{ width: '20%' }" />
          <col :style="{ width: '20%' }" />
          <col :style="{ width: '20%' }" />
          <col :style="{ width: '20%' }" />
          <col :style="{ width: '20%' }" />
        </colgroup>
        <tr id="ths">
          <th>아파트이름</th>
          <th>행정동</th>
          <th>매매가</th>
          <th>건설년도</th>
          <th>삭제</th>
        </tr>
        <tr v-for="(item, index) in items.slice().reverse()" :key="`${index}`">
          <td>
            <router-link
              :to="`/search/read?aptName=${item.aptName}&dong=${item.dong}&dealAmount=${item.dealAmount}&buildYear=${item.buildYear}&no=${item.no}`"
              >{{ item.aptName }}</router-link
            >
          </td>
          <td>{{ item.dong }}</td>
          <td>{{ wonPrice(item.dealAmount) }}만원</td>
          <td>{{ item.buildYear }}년</td>
          <td>
            <button class="btn btn-danger" @click="deleteBasket(item.no)">X</button>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';

export default {
  data() {
    return {
      items: [],
    };
  },
  methods: {
    deleteBasket(num) {
      http
        .delete('/happyhouse/house/unlike', {
          data: {
            id: this.user.userId,
            no: num,
          },
        })
        .then(() => {
          alert('찜목록에서 삭제하였습니다!');
          this.$router.go();
        })
        .catch(() => {
          alert('오류가 발생하였습니다!');
        });
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
  },
  created() {
    http
      .get(`/happyhouse/house/like/${this.user.userId}`)
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

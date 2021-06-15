<template>
  <div>
    <h1 id="menu_title">최근 본 상품</h1>
    <hr />
    <div v-if="records.length">
      <table class="table table-bordered table-condensed">
        <colgroup>
          <col :style="{ width: '25%' }" />
          <col :style="{ width: '25%' }" />
          <col :style="{ width: '25%' }" />
          <col :style="{ width: '25%' }" />
        </colgroup>
        <tr id="ths">
          <th>아파트이름</th>
          <th>행정동</th>
          <th>매매가</th>
          <th>건설년도</th>
        </tr>
        <tr v-for="(item, index) in records.slice().reverse()" :key="`${index}`">
          <td>
            <router-link
              :to="`/search/read?aptName=${item.aptName}&dong=${item.dong}&dealAmount=${item.dealAmount}&buildYear=${item.buildYear}&no=${item.no}`"
              >{{ item.aptName }}</router-link
            >
          </td>
          <td>{{ item.dong }}</td>
          <td>{{ wonPrice(item.dealAmount) }}만원</td>
          <td>{{ item.buildYear }}년</td>
        </tr>
      </table>
    </div>
    <b-button variant="danger" @click="deleteRecord">최근 기록 지우기</b-button>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
export default {
  methods: {
    deleteRecord() {
      this.$store.dispatch('deleteRecord');
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
  computed: {
    ...mapGetters(['records']),
  },
};
</script>

<style></style>

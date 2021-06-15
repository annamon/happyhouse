<template>
  <div>
    <h1 id="menu_title">자유 게시판</h1>
    <hr />
    <div v-if="user.userId == ''">
      <h1>로그인 후 이용할 수 있는 페이지 입니다</h1>
      <router-link :to="`/`">홈으로 이동</router-link> |
      <router-link :to="`/user`">로그인 하기</router-link>
    </div>
    <div v-else>
      <div v-if="items.length">
        <table class="table table-bordered table-condensed">
          <colgroup>
            <col :style="{ width: '10%' }" />
            <col :style="{ width: '60%' }" />
            <col :style="{ width: '12%' }" />
            <col :style="{ width: '18%' }" />
          </colgroup>
          <tr id="ths">
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
          </tr>
          <!-- 게시글 역순 정렬(스택)-->
          <tr id="tds" v-for="(item, index) in items.slice().reverse()" :key="`${index}`">
            <td>{{ items.length - index }}</td>
            <td>
              <router-link :to="`/board/read?no=${item.no}`">{{ item.title }}</router-link>
            </td>
            <td>{{ item.id }}</td>
            <td>{{ cutTime(item.regtime) }}</td>
          </tr>
        </table>
      </div>
      <div v-else>작성된 글이 없습니다.</div>
      <div class="text-right">
        <button
          class="btn btn-primary"
          @click="moveCreate"
          v-if="user.userId != 'ssafy' && user.userId != ''">
        등록
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';

export default {
  name: 'list',
  data() {
    return {
      items: [],
    };
  },
  methods: {
    moveCreate() {
      this.$router.push('/board/create');
    },
    cutTime(x){
      if(x) return x.toString().slice(0, 10);
    }
  },
  created() {
    // Axios
    http
      .get('/happyhouse/board/')
      // 리스트는 data로 받는다.
      .then(({ data }) => {
        this.items = data;
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

<style>

</style>

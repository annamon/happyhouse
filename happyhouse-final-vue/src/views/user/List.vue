<template>
  <div>
    <h1 id="menu_title">회원목록</h1>
    <hr />
    <div v-if="user.userId == ''">
      <h1>로그인 후 이용할 수 있는 페이지 입니다</h1>
      <router-link :to="`/`">홈으로 이동</router-link> |
      <router-link :to="`/user`">로그인 하기</router-link>
    </div>
    <div v-else>
      <div v-if="items.length">
        <table class="table table-condensed">
          <tr id="ths">
            <th>아이디</th>
            <th>이름</th>
            <th>직업</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>가입일</th>
            <th>강퇴</th>
          </tr>
          <tr v-for="(item, index) in items.slice().reverse()" :key="`${index}`">
            <td>{{ item.id }}</td>
            <td>
              {{ item.name }}
            </td>
            <td>{{ item.job }}</td>
            <td>{{ item.email }}</td>
            <td>{{ item.number }}</td>
            <td>{{ cutTime(item.joindate) }}</td>
            <td>
              <button
                class="btn btn-danger"
                @click="deleteUser(item.id)"
                v-if="user.userId == 'ssafy'"
              >
                추방
              </button>
            </td>
          </tr>
        </table>
      </div>
      <div v-else>글이 없습니다.</div>
      <div class="text-center">
        <button class="btn btn-primary" @click="moveRead" v-if="user.userId == 'ssafy'">
          뒤로가기
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
    moveRead() {
      this.$router.push('/user/read');
    },
    cutTime(x) {
      if (x) return x.toString().slice(0, 10);
    },
    deleteUser(user) {
      http
        .delete(`/happyhouse/deleteUser/${user}`, {
          id: user,
        })
        .then(() => {
          alert('강퇴 성공');
          this.$router.go();
        })
        .catch(() => {
          alert('회원 정보를 불러올 수 없습니다!');
        });
    },
  },
  created() {
    // Axios
    http
      .get('/happyhouse/admin/allUser')
      // 리스트는 data로 받는다.
      .then(({ data }) => {
        this.items = data;
        console.log(data);
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

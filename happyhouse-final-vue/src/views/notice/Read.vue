<template>
  <div>
    <h1 id="menu_title">공지글</h1>
    <hr />
    <table class="table table-bordered">
      <tr>
        <th id="ths">작성자</th>
        <td>관리자</td>
      </tr>
      <tr>
        <th id="ths">제목</th>
        <td>{{ this.item.title }}</td>
      </tr>
      <tr>
        <th id="ths">날짜</th>
        <td>{{ this.item.regtime }}</td>
      </tr>
      <tr>
        <td colspan="2" v-html="handleNewLine(this.item.content)">
          {{ this.item.content }}
        </td>
      </tr>
    </table>
    <div id="board_content">
      <div id="buttons" style="float: left">
        <router-link to="/notice">
          <button class="btn btn-primary">목록</button>
        </router-link>
      </div>
      <div id="buttons" style="float: right">
        <button
          class="btn btn-danger"
          @click="deleteNotice"
          v-if="user.userId == item.id || user.userId == 'ssafy'"
        >
          삭제
        </button>
      </div>
      <div id="buttons" style="float: right">
        <router-link :to="'/notice/update?no=' + this.item.no">
          <button class="btn btn-success" v-if="user.userId == item.id" style="margin: 0 8px 0 0">
            수정
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';
export default {
  data() {
    return {
      item: {
        no: '',
        id: '',
        title: '',
        content: '',
        regtime: '',
      },
    };
  },
  methods: {
    deleteNotice() {
      http
        .delete(`/happyhouse/board/${this.item.no}`, {})
        .then(() => {
          this.$router.push('/notice');
          alert('삭제 성공');
        })
        .catch(() => {
          alert('공지사항 삭제에 실패했습니다!');
        });
    },
    handleNewLine(str) {
      return String(str).replace(/(?:\r\n|\r|\n)/g, '</br>');
    },
  },
  created() {
    http
      .get(`/happyhouse/board/${this.$route.query.no}`)
      .then((response) => {
        this.item = response.data;
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

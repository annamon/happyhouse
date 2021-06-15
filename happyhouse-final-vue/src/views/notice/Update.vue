<template>
  <div>
    <h1 id="menu_title">공지사항 수정</h1>
    <hr>
    <!-- 글번호-->
    <!-- <div class="form-group">
      <label for="no">No</label>
      <input type="text" class="form-control" id="no" ref="item.no" v-model="item.no" readonly />
    </div> -->
    <!-- 제목-->
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" ref="item.title" v-model="item.title" />
    </div>
    <!-- 날짜-->
    <div class="form-group">
      <label for="regtime">등록일</label>
      <input
        type="text"
        class="form-control"
        id="regtime"
        ref="item.regtime"
        v-model="item.regtime"
        readonly
      />
    </div>
    <!-- 내용-->
    <div class="form-group">
      <label for="content">내용</label>
      <textarea
        type="text"
        rows="8"
        class="form-control"
        id="content"
        ref="item.content"
        v-model="item.content"
      />
    </div>
    <div class="text-right">
      <button class="btn btn-success" @click="updateNotice" style="margin:0 8px 0 0">수정</button>
      <router-link :to="'/notice/read?no=' + this.item.no"
        ><button class="btn btn-secondary">취소</button></router-link
      >
    </div>
  </div>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from 'vuex';

export default {
  name: 'user-update',
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
    updateNotice() {
      http
        .put(`/happyhouse/board/${this.item.no}`, {
          no: this.item.no,
          id: this.item.id,
          title: this.item.title,
          content: this.item.content,
          regtime: this.item.regtime,
        })
        // .replace(/(?:\r\n|\r|\n)/g, '<br>'),
        .then(() => {
          console.log(this.item), alert('수정이 완료되었습니다.');
          this.moveRead();
        })
        .catch(() => {
          alert('아이디가 중복됩니다.');
        });
    },
    moveRead() {
      this.$router.push(`/notice/read?no=${this.item.no}`);
    },
  },
  // 회원 정보
  created() {
    http
      .get(`/happyhouse/board/${this.$route.query.no}`, {})
      .then((response) => {
        this.item = response.data;
      })
      .catch(() => {
        alert('회원 정보를 불러올 수 없습니다!');
      });
  },
  computed: {
    ...mapGetters(['user']),
  },
};
</script>

<style></style>

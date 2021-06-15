<template>
  <div>
    <h1 id="menu_title">공지사항 등록</h1>
    <hr>
    <div class="form-group">
      <label for="userId"></label>
      <input type="text" class="form-control" id="userId" ref="id" v-model="user.userId" hidden />
    </div>
    <div class="form-group">
      <label for="title">제목</label>
      <input 
        type="text"
        class="form-control"
        id="title"
        ref="title"
        placeholder="제목을 입력하세요"
        v-model="title"
      />
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea
        type="text"
        rows="8"
        class="form-control"
        id="content"
        ref="content"
        placeholder="내용을 입력하세요"
        v-model="content"
      ></textarea>
    </div>
    <div class="text-right">
      <b-button type="submit" @click="check" variant="primary">등록</b-button>
      <!-- <button class="btn btn-primary" v-if="type == 'create'" @click="checkHandler">등록</button> -->
      <!-- <button class="btn btn-primary" v-else @click="checkHandler">수정</button>
      <button class="btn btn-primary" @click="moveList">목록</button> -->
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import http from '@/utils/http-common';

export default {
  data() {
    return {
      id: '',
      title: '',
      content: '',
    };
  },
  methods: {
    // 입력 체크
    check() {
      let err = true;
      let msg = '';
      !this.title && ((msg = '글 제목을 입력해주세요'), (err = false), this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = '글 내용을 입력해주세요'), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      else this.write();
    },
    // 글 작성
    write() {
      http
        .post('/happyhouse/board/writeBoard', {
          id: this.user.userId,
          title: this.title,
          content: this.content,
        })
        .then(() => {
          alert('글 작성이 완료 되었습니다.');
          this.$router.push('/notice');
        })
        .catch(() => {
          alert('아이디가 중복됩니다.');
        });
    },
  },
  computed: {
    ...mapGetters(['user']),
  },
};
</script>

<style></style>

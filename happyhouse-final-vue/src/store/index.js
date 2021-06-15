import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    // 로그인
    login: {
      checkLogin: false,
      userId: '',
      userName: '',
    },
    // 부동산 정보
    esInfos: [],
    // 최근 본 상품
    records: [],
  },
  getters: {
    // 로그인 : 회원 이름 반환.
    user(state) {
      return state.login;
    },
    // 부동산 정보의 길이 반환
    totalEsInfoCount(state) {
      return state.esInfos.length;
    },
    // 부동산 정보 반환
    esInfos(state) {
      return state.esInfos;
    },
    // 최근 본 상품 반환
    records(state) {
      return state.records;
    },
  },
  mutations: {
    // 로그인
    LOGIN(state, user) {
      state.login.checkLogin = !state.login.checkLogin;
      state.login.userId = user.id;
      state.login.userName = user.name;
    },
    // 로그아웃
    LOGOUT(state) {
      state.login.checkLogin = !state.login.checkLogin;
      state.login.userId = '';
      state.login.userName = '';
    },
    // 부동산 검색 내용 추가
    ADD_ESINFO(state, esItems) {
      state.esInfos = esItems.map((esItem) => {
        // 그 이외의 배열은 그대로 return.
        return esItem;
      });
    },
    // 부동산 검색 내용 삭제
    DELETE_ESINFO(state) {
      state.esInfos = [];
    },
    // 최근 본 상품 추가
    ADD_RECORD(state, record) {
      for (let i = 0; i < state.records.length; i++) {
        if (state.records[i].no == record.no) {
          return;
        }
      }
      state.records.push(record);
    },
    // 최근 본 상품 전제 삭제
    DELETE_RECORD(state) {
      state.records = [];
    },
  },
  actions: {
    // 로그인
    loginComplete({ commit }, user) {
      commit('LOGIN', user);
    },
    // 로그아웃
    logout({ commit }) {
      commit('LOGOUT');
    },
    // 부동산 검색 내용 추가
    addEsInfo({ commit }, esItems) {
      commit('ADD_ESINFO', esItems);
    },
    // 부동산 검색 내용 삭제
    deleteEsInfo({ commit }) {
      commit('DELETE_ESINFO');
    },
    // 최근 본 상품 추가
    addRecord({ commit }, record) {
      commit('ADD_RECORD', record);
    },
    // 최근 본 상품 전제 삭제
    deleteRecord({ commit }) {
      commit('DELETE_RECORD');
    },
  },
  plugins: [createPersistedState()],
});

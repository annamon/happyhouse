import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
// User
import User from '@/views/User.vue';
import UserLogin from '@/views/user/Login.vue';
import UserJoin from '@/views/user/Join.vue';
import UserRead from '@/views/user/Read.vue';
import UserUpdate from '@/views/user/Update.vue';
import UserFind from '@/views/user/Find.vue';
import UserList from '@/views/user/List.vue';
import UserBasket from '@/views/user/Basket.vue';
import UserRecord from '@/views/user/Record.vue';
// Notice
import Notice from '@/views/Notice.vue';
import NoticeList from '@/views/notice/List.vue';
import NoticeCreate from '@/views/notice/Create.vue';
import NoticeRead from '@/views/notice/Read.vue';
import NoticeUpdate from '@/views/notice/Update.vue';
// Search
import Search from '@/views/Search.vue';
import SearchMain from '@/views/search/Main.vue';
import SearchRead from '@/views/search/Read.vue';
// Board
import Board from '@/views/Board.vue';
import BoardList from '@/views/board/List.vue';
import BoardCreate from '@/views/board/Create.vue';
import BoardRead from '@/views/board/Read.vue';
import BoardUpdate from '@/views/board/Update.vue';
// Estate
import Estate from '@/views/estate/Estate.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/user',
    name: 'User',
    component: User,
    redirect: '/user/login',
    children: [
      {
        path: 'login',
        name: 'UserLogin',
        component: UserLogin,
      },
      {
        path: 'join',
        name: 'UserJoin',
        component: UserJoin,
      },
      {
        path: 'read',
        name: 'UserRead',
        component: UserRead,
      },
      {
        path: 'update',
        name: 'UserUpdate',
        component: UserUpdate,
      },
      {
        path: 'find',
        name: 'UserFind',
        component: UserFind,
      },
      {
        path: 'list',
        name: 'UserList',
        component: UserList,
      },
      {
        path: 'basket',
        name: 'UserBasket',
        component: UserBasket,
      },
      {
        path: 'record',
        name: 'UserRecord',
        component: UserRecord,
      },
    ],
  },
  {
    path: '/notice',
    name: 'Notice',
    component: Notice,
    redirect: '/notice/list',
    children: [
      {
        path: 'list',
        name: 'NoticeList',
        component: NoticeList,
      },
      {
        path: 'create',
        name: 'NoticeCreate',
        component: NoticeCreate,
      },
      {
        path: 'read',
        name: 'NoticeRead',
        component: NoticeRead,
      },
      {
        path: 'update',
        name: 'Noticeupdate',
        component: NoticeUpdate,
      },
    ],
  },
  {
    path: '/search',
    name: 'Search',
    component: Search,
    redirect: '/search/main',
    children: [
      {
        path: 'main',
        name: 'SearchMain',
        component: SearchMain,
      },
      {
        path: 'read',
        name: 'SearchRead',
        component: SearchRead,
      },
    ],
  },
  {
    path: '/board',
    name: 'Board',
    component: Board,
    redirect: '/board/list',
    children: [
      {
        path: 'list',
        name: 'BoardList',
        component: BoardList,
      },
      {
        path: 'create',
        name: 'BoardCreate',
        component: BoardCreate,
      },
      {
        path: 'read',
        name: 'BoardRead',
        component: BoardRead,
      },
      {
        path: 'update',
        name: 'Boardupdate',
        component: BoardUpdate,
      },
    ],
  },
  {
    path: '/estate',
    name: 'Estate',
    component: Estate,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: '/',
  routes,
});

export default router;

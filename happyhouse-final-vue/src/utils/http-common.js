import axios from 'axios';

// axios 객체 생성
export default axios.create({
  // Spring Server로 접근한다.
  // baseURL: 'http://localhost:8197/ssafyvue/api',
  baseURL: 'http://localhost:8100/happyhouse_final',
  headers: {
    'Access-Control-Allow-Origin': '*',
    'Content-type': 'application/json',
  },
});

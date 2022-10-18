import axios from "axios";

const service = axios.create({
  baseURL: "/static/json",
  // baseURL: "http://localhost:8888",
  timeout: 10000
});
export default service;

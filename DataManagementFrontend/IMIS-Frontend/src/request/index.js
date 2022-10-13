import axios from "axios";

const service = axios.create({
  baseURL: "/static/json",
  timeout: 10000
});
export default service;

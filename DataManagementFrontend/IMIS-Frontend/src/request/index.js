import axios from "axios";
import store from "@/store";
import { getToken } from "@/request/token";
import { Message } from "element-ui";

const service = axios.create({
  // baseURL: "/static/json",
  baseURL: "http://localhost:8888",
  timeout: 10000
});

service.interceptors.request.use(
  config => {
    if (store.state.token) {
      config.headers["Authorization"] = getToken();
    }
    return config;
  },
  error => {
    Promise.reject(error);
  }
);

service.interceptors.response.use(
  response => {
    if (response.headers["session_time_out"] == "timeout") {
      store.dispatch("fedLogOut");
    }

    const res = response.data;

    if (res.code !== 0) {
      // //90001 Session超时
      // if (res.code === 90001) {
      //   return Promise.reject("error");
      // }

      // //90002 用户未登录
      // if (res.code === 90002) {
      //   Message({
      //     type: "warning",
      //     showClose: true,
      //     message: "未登录或登录超时，请重新登录哦~"
      //   });

      //   return Promise.reject("error");
      // }

      return Promise.reject(res.msg);
    } else {
      return response.data;
    }
  },
  error => {
    Message({
      type: "warning",
      showClose: true,
      message: "连接超时"
    });
    return Promise.reject("error");
  }
);

export default service;

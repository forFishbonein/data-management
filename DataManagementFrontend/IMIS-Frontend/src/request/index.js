import axios from "axios";
import store from "@/store";
import {getToken} from "@/request/token";
import {Message} from "element-ui";

const service = axios.create({
  // baseURL: "/static/json",
  baseURL: "http://localhost:8888"
  // headers: { "Content-Type": "application/json;charset=UTF-8" },
  // transformRequest: [
  //   function(data) {
  //     // Do whatever you want to transform the data
  //     let ret = "";
  //     for (let it in data) {
  //       ret +=
  //         encodeURIComponent(it) + "=" + encodeURIComponent(data[it]) + "&";
  //     }
  //     return ret;
  //   }
  // ]
});

service.interceptors.request.use(
  config => {
    // config.headers['Content-Type'] = 'application/json;charset=utf-8';
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
    if (res.type != null && res.type != "application/vnd.ms-excel") {
      if (res.code !== 0) {
        console.log(response);
        console.log(res);
        console.log("code不为0,默认报错!!!!加一下code");
        // //90001 Session超时
        // if (res.code === 90001) {
        //   return Promise.reject("error");
        // }

        // //90002 用户未登录
        // if (res.code === 90002) {
        Message({
          type: "warning",
          showClose: true,
          message: res.msg
        });

        //   return Promise.reject("error");
        // }

        return Promise.reject(res.msg);
      } else {
        return response.data;
      }
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

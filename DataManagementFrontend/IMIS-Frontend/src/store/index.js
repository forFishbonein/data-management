import Vuex from "vuex";
import Vue from "vue";
import { getToken, setToken, removeToken } from "@/request/token";
import { codeLogin, passLogin, getUserInfo } from "@/api/login";
import { postRegisterTeacher, postRegisterStudent } from "@/api/register";
import { getOneFile } from "@/api/file";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userId: "",
    userEmail: "",
    userSid: "",
    userName: "",
    createTime: "",
    updateTime: "",
    token: getToken(),
    Query: {
      TEMPLATE_TYPE: "",
      id: ""
    }
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token;
    },
    SET_USEREMAIL: (state, userEmail) => {
      state.userEmail = userEmail;
    },
    SET_USERNAME: (state, userName) => {
      state.userName = userName;
    },
    SET_USERID: (state, userId) => {
      state.userId = userId;
    },
    SET_USERSID: (state, userSid) => {
      state.userSid = userSid;
    },
    SET_CREATETIME: (state, createTime) => {
      state.createTime = createTime;
    },
    SET_UPDATETIME: (state, updateTime) => {
      state.updateTime = updateTime;
    },
    SET_QUERY: (state, obj) => {
      state.Query.TEMPLATE_TYPE = obj.TEMPLATE_TYPE;
      state.Query.id = obj.id;
    }
  },
  actions: {
    codeLogin({ commit }, user) {
      return new Promise((resolve, reject) => {
        codeLogin(user.email, user.code)
          .then(data => {
            if (data.success) {
              commit("SET_TOKEN", data.data);
              setToken(data.data);
              resolve();
            } else {
              reject(data.msg);
            }
          })
          .catch(error => {
            reject(error);
          });
      });
    },
    passLogin({ commit }, login) {
      return new Promise((resolve, reject) => {
        passLogin(login)
          .then(res => {
            console.log(res);
            // alert("1111");
            // if (res.success) {
            console.log(res.data.data);
            commit("SET_TOKEN", res.data.data);
            setToken(res.data.data);
            resolve();
            // } else {
            //   reject(res.msg);
            // }
          })
          .catch(error => {
            console.log(error);
            reject(error);
          });
      });
    },
    getUserInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        getUserInfo(state.token)
          .then(data => {
            if (data.success) {
              commit("SET_USEREMAIL", data.data.userEmail);
              commit("SET_USERNAME", data.data.userName);
              commit("SET_USERID", data.data.userId);
              commit("SET_USERSID", data.data.userSid);
              commit("SET_CREATETIME", data.data.createTime);
              commit("SET_UPDATETIME", data.data.updateTime);
              resolve(data);
            } else {
              commit("SET_USEREMAIL", "");
              commit("SET_USERNAME", "");
              commit("SET_USERID", "");
              commit("SET_USERSID", "");
              commit("SET_CREATETIME", "");
              commit("SET_UPDATETIME", "");
              removeToken();
              resolve(data);
            }
          })
          .catch(error => {
            commit("SET_USEREMAIL", "");
            commit("SET_USERNAME", "");
            commit("SET_USERID", "");
            commit("SET_USERSID", "");
            commit("SET_CREATETIME", "");
            commit("SET_UPDATETIME", "");
            removeToken();
            reject(error);
          });
      });
    },
    logout({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token)
          .then(data => {
            if (data.success) {
              commit("SET_USEREMAIL", "");
              commit("SET_USERNAME", "");
              commit("SET_USERID", "");
              commit("SET_USERSID", "");
              commit("SET_CREATETIME", "");
              commit("SET_UPDATETIME", "");
              removeToken();
              resolve();
            }
          })
          .catch(error => {
            reject(error);
          });
      });
    },
    // 前端 登出
    fedLogOut({ commit }) {
      return new Promise(resolve => {
        commit("SET_USEREMAIL", "");
        commit("SET_USERNAME", "");
        commit("SET_USERID", "");
        commit("SET_USERSID", "");
        commit("SET_CREATETIME", "");
        commit("SET_UPDATETIME", "");
        removeToken();
        resolve();
      }).catch(error => {
        reject(error);
      });
    },
    teacherRegister({ commit }, teacher) {
      return new Promise((resolve, reject) => {
        postRegisterTeacher(teacher)
          .then(data => {
            if (data.data) {
              commit("SET_TOKEN", data.data);
              setToken(data.data);
              resolve();
            } else {
              reject(data.msg);
            }
          })
          .catch(error => {
            reject(error);
          });
      });
    },
    // studentRegister({ commit }, user) {
    //   return new Promise((resolve, reject) => {
    //     postRegisterStudent(user.account, user.nickname, user.password)
    //       .then(data => {
    //         if (data.success) {
    //           // commit("SET_TOKEN", data.data);
    //           // setToken(data.data);
    //           resolve();
    //         } else {
    //           reject(data.msg);
    //         }
    //       })
    //       .catch(error => {
    //         reject(error);
    //       });
    //   });
    // }
    getDetails({ commit, state }, obj) {
      return new Promise((resolve, reject) => {
        commit("SET_QUERY", obj);
        getOneFile(state.Query)
          .then(res => {
            if (res.data) {
              resolve(res.data);
            } else {
              reject(res.msg);
            }
          })
          .catch(error => {
            reject(error);
          });
      });
    }
  }
});

import Vuex from "vuex";
import Vue from "vue";
import { getToken, setToken, removeToken } from "@/request/token";
import { codeLogin, passLogin, getUserInfo} from "@/api/login";
import { postRegisterTeacher, postRegisterStudent } from "@/api/register";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    id: "",
    account: "",
    name: "",
    token: getToken()
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token;
    },
    SET_ACCOUNT: (state, account) => {
      state.account = account;
    },
    SET_NAME: (state, name) => {
      state.name = name;
    },
    SET_ID: (state, id) => {
      state.id = id;
    }
  },
  actions: {
    codeLogin({ commit }, user) {
      return new Promise((resolve, reject) => {
        codeLogin(user.account, user.vcode)
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
    passLogin({ commit }, user) {
      return new Promise((resolve, reject) => {
        passLogin(user.account, user.password)
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
    // getUserInfo({ commit, state }) {
    //   let that = this;
    //   return new Promise((resolve, reject) => {
    //     getUserInfo(state.token)
    //       .then(data => {
    //         if (data.success) {
    //           commit("SET_ACCOUNT", data.data.account);
    //           commit("SET_NAME", data.data.teacherName);
    //           commit("SET_ID", data.data.id);
    //           resolve(data);
    //         } else {
    //           commit("SET_ACCOUNT", "");
    //           commit("SET_NAME", "");
    //           commit("SET_ID", "");
    //           removeToken();
    //           resolve(data);
    //         }
    //       })
    //       .catch(error => {
    //         commit("SET_ACCOUNT", "");
    //         commit("SET_NAME", "");
    //         commit("SET_ID", "");
    //         removeToken();
    //         reject(error);
    //       });
    //   });
    // },
    // logout({ commit, state }) {
    //   return new Promise((resolve, reject) => {
    //     logout(state.token)
    //       .then(data => {
    //         if (data.success) {
    //           commit("SET_TOKEN", "");
    //           commit("SET_ACCOUNT", "");
    //           commit("SET_NAME", "");
    //           commit("SET_ID", "");
    //           removeToken();
    //           resolve();
    //         }
    //       })
    //       .catch(error => {
    //         reject(error);
    //       });
    //   });
    // },
    // 前端 登出
    fedLogOut({ commit }) {
      return new Promise(resolve => {
        commit("SET_TOKEN", "");
        commit("SET_ACCOUNT", "");
        commit("SET_NAME", "");
        commit("SET_ID", "");
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
              // commit("SET_TOKEN", data.data);
              // setToken(data.data);
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
    studentRegister({ commit }, user) {
      return new Promise((resolve, reject) => {
        postRegisterStudent(user.account, user.nickname, user.password)
          .then(data => {
            if (data.success) {
              // commit("SET_TOKEN", data.data);
              // setToken(data.data);
              resolve();
            } else {
              reject(data.msg);
            }
          })
          .catch(error => {
            reject(error);
          });
      });
    }
  }
});

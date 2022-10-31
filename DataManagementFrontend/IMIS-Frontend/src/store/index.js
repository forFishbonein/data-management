import Vuex from "vuex";
import Vue from "vue";
import { getToken, removeToken, setToken } from "@/request/token";
import { getFlag, setFlag, getPageFrom, setPageFrom } from "@/request/flag";
import { codeLogin, getUserInfo, passLogin, logout } from "@/api/login";
import { postRegisterTeacher } from "@/api/register";
import { getOneFile } from "@/api/file";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    teacherId: "",
    teacherEmail: "",
    teacherName: "",
    teacherSid: "",
    teacherTitle: "",
    teacherTele: "",
    createTime: "",
    updateTime: "",
    token: getToken(),
    Query: {
      TEMPLATE_TYPE: "",
      id: ""
    },
    flag: getFlag(),
    pageFrom: getPageFrom()
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token;
    },
    SET_TEACHEREMAIL: (state, teacherEmail) => {
      state.teacherEmail = teacherEmail;
    },
    SET_TEACHERNAME: (state, teacherName) => {
      state.teacherName = teacherName;
    },
    SET_TEACHERID: (state, teacherId) => {
      state.teacherId = teacherId;
    },
    SET_TEACHERSID: (state, teacherSid) => {
      state.teacherSid = teacherSid;
    },
    SET_TEACHERTITLE: (state, teacherTitle) => {
      state.teacherTitle = teacherTitle;
    },
    SET_TEACHERTELE: (state, teacherTele) => {
      state.teacherTele = teacherTele;
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
    },
    SET_FLAG: (state, shu) => {
      state.flag = shu;
      setFlag(shu);
    },
    SET_PAGEFROM: (state, page) => {
      state.pageFrom = page;
      setPageFrom(page);
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
            // if (res.success) {
            console.log(res.data);
            commit("SET_TOKEN", res.data);
            setToken(res.data);
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
          .then(res => {
            if (res) {
              commit("SET_TEACHEREMAIL", res.data.teacherEmail);
              commit("SET_TEACHERNAME", res.data.teacherName);
              commit("SET_TEACHERID", res.data.teacherId);
              commit("SET_TEACHERSID", res.data.teacherSid);
              commit("SET_TEACHERTITLE", res.data.teacherTitle);
              commit("SET_TEACHERTELE", res.data.teacherTele);
              commit("SET_CREATETIME", res.data.createTime);
              commit("SET_UPDATETIME", res.data.updateTime);
              resolve(res);
            } else {
              commit("SET_TEACHEREMAIL", "");
              commit("SET_TEACHERNAME", "");
              commit("SET_TEACHERID", "");
              commit("SET_TEACHERSID", "");
              commit("SET_TEACHERTITLE", "");
              commit("SET_TEACHERTELE", "");
              commit("SET_CREATETIME", "");
              commit("SET_UPDATETIME", "");
              removeToken();
              resolve(res);
            }
          })
          .catch(error => {
            commit("SET_TEACHEREMAIL", "");
            commit("SET_TEACHERNAME", "");
            commit("SET_TEACHERID", "");
            commit("SET_TEACHERSID", "");
            commit("SET_TEACHERTITLE", "");
            commit("SET_TEACHERTELE", "");
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
          .then(res => {
            if (res) {
              commit("SET_TEACHEREMAIL", "");
              commit("SET_TEACHERNAME", "");
              commit("SET_TEACHERID", "");
              commit("SET_TEACHERSID", "");
              commit("SET_TEACHERTITLE", "");
              commit("SET_TEACHERTELE", "");
              commit("SET_CREATETIME", "");
              commit("SET_UPDATETIME", "");
              removeToken();
              resolve(res);
            }
          })
          .catch(error => {
            reject(error);
          });
      });
    },
    // 前端 登出
    fedLogOut({ commit }) {
      return new Promise(res => {
        commit("SET_TEACHEREMAIL", "");
        commit("SET_TEACHERNAME", "");
        commit("SET_TEACHERID", "");
        commit("SET_TEACHERSID", "");
        commit("SET_TEACHERTITLE", "");
        commit("SET_TEACHERTELE", "");
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
    },
    changeFlag({ commit, state }, shu) {
      commit("SET_FLAG", shu);
    },
    changePageFrom({ commit, state }, page) {
      commit("SET_PAGEFROM", page);
    }
  }
});

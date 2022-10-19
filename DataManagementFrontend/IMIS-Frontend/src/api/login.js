import request from "@/request";

export function loginA(account, vcode) {
  const data = {
    account,
    vcode
  };
  return request({
    url: "/logina",
    method: "post",
    data
  });
}

export function loginB(account, password) {
  const data = {
    account,
    password
  };
  return request({
    url: "/loginb",
    method: "post",
    data
  });
}

export function logout(token) {
  return request({
    headers: { Authorization: token },
    url: "/logout",
    method: "get"
  });
}

export function getUserInfo(token) {
  return request({
    headers: { Authorization: token },
    url: "/users/currentUser",
    method: "get"
  });
}

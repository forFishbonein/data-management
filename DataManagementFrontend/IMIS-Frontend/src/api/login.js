import request from "@/request";

export function codeLogin(data) {
  return request({
    data,
    method: "post",
    url: "http://localhost:8888/login"
  });
}

export function passLogin(data) {
  return request({
    data,
    method: "post",
    url: "http://localhost:8888/passLogin"
  });
}

export function getUserInfo(token ,id) {
  return request({
    headers: { Authorization: token },
    url: `/users/${id}`,
    method: "get"
  });
}

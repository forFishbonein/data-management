import request from "@/request";

export function codeLogin(data) {
  return request({
    data: data,
    method: "post",
    url: "/t/login"
  });
}

export function passLogin(login) {
  // console.log(login);
  return request({
    data: login,
    method: "post",
    url: "/t/passLogin"
  });
}

export function getUserInfo(token, id) {
  return request({
    headers: { Authorization: token },
    url: `/users/${id}`,
    method: "get"
  });
}

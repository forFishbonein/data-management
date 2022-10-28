import request from "@/request";

export function insertTeacherFile(data) {
  return request({
    data,
    method: "put",
    url: "/file",
  });
}

export function getById(id) {
  return request({
    method: "get",
    url: "/file/"
  });
}


import request from "@/request";

export function insertTeacherFile(data) {
  return request({
    data,
    method: "put",
    url: "/file",
  });
}

export function getById() {
  return request({
    method: "get",
    url: "/file"
  });
}


import request from "@/request";

export function insertTeacherFile(data) {
  return request({
    data,
    method: "put",
    url: "/file",
  });
}

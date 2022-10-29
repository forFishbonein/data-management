import request from "@/request";

export function insertTeacherFile(data) {
  return request({
    data,
    method: "put",
    url: "/file",
  });
}

export function getOneFile(data) {
  console.log(data);
  return request({
    data: data,
    method: "post",
    url: "/file/detail"
  });
}



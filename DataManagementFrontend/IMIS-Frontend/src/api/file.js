import request from "@/request";

export function insertTeacherFile(data) {
  return request({
    data,
    method: "put",
    url: "/file"
  });
}

export function updateTeacherFile(data) {
  return request({
    data,
    method: "post",
    url: "/file"
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

export function excelExport(data) {
  console.log(data);
  return request({
    data: data,
    method: "post",
    url: "/excel/export",
    // headers: {
    //   "Content-Type": "application/x-www-form-urlencoded"
    // },
    responseType: "blob"
  });
}

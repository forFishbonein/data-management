import request from "@/request";

export function insertTeacherFile(data) {
  console.log("--------data")
  console.log(data);
  console.log("--------data")
  return request({
    data,
    method: "post",
    url: "/file",
  });
}

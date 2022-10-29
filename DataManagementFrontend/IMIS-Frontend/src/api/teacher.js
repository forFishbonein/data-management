import request from "@/request";

export function getAllTeacher() {
  return request({
    method: "get",
    url: "/t"
  });
}


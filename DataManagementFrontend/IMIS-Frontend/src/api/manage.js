import request from "@/request";

export function getAllResource() {
  return request({
    method: "get",
    url: "/getAllResource.json"
  });
}

export function getSearchResults(keyword) {
  return request({
    method: "get",
    data: keyword,
    url: "/results.json"
  });
}

export function test() {
  return request({
    method: "get",
    url: "/file"
  });
}

export function getByTeacherId(id) {
  return request({
    method: "get",
    data: {"id": id},
    url: "/getByTeacherId.json"
  });
}

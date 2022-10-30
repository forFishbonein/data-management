import request from "@/request";

export function getMaterials(id) {
  return request({
    method: "get",
    url: `/file/${id}`
  });
}

export function getSearchResults(keyword) {
  return request({
    method: "get",
    data: keyword,
    url: "/results"
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
    url: "/getByTeacherId"
  });
}

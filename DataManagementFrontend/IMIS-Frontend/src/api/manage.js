import request from "@/request";

export function getAllResource() {
  return request({
    method: "get",
    url: "/file"
  });
}

export function getSearchResults(keyword) {
  return request({
    method: "get",
    data: keyword,
    url: "/results.json"
  });
}

export function getByTeacherId(id) {
  return request({
    method: "get",
    data: {"id": id},
    url: "/getByTeacherId.json"
  });
}

export function updateById(data) {
  console.log(data);
  return request({
    data: data,
    method: "post",
    url: "/file"
  });
}

export function deleteById(data) {
  console.log(data)
  return request({
    data: data,
    method: "delete",
    url: "/file"
  });
}

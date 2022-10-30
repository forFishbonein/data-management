import request from "@/request";

export function getAllTeacher() {
  return request({
    method: "get",
    url: "/t"
  });
}

// export function getProfile(id) {
//   return request({
//     method: "get",
//     url: `/file/${id}`
//   });
// }


export function getProfile() {
  return request({
    method: "get",
    url: `/file/1584124052249804800`
  });
}
import request from "@/request"

export function getMaterials(){
  return request({
    method: 'get',
    url: '/materials.json',
  })
}

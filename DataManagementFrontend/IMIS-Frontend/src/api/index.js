import request from "@/request"

export function getMaterials(){
  return request({
    method: 'get',
    url: '/materials.json',
  })
}

export function getSearchResults(keyword){
  return request({
    method: 'get',
    data: keyword,
    url: '/results.json',
  })
}

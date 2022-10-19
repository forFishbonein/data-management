import request from "@/request"

export function postCodeTeacher(data){
  return request({
    data,
    method: 'post',
    url: 'http://localhost:8888/sendEmail',
  })
}

export function postRegisterTeacher(data){
  return request({
    data,
    method: 'post',
    url: 'http://localhost:8888/t/register',
  })
}

export function postRegisterStudent(data){
  return request({
    data,
    method: 'post',
    url: '/',
  })
}

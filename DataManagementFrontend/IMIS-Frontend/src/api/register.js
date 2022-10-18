import request from "@/request"

export function postRegisterTeacher(teacher){
  return request({
    data: teacher,
    method: 'post',
    url: 'http://localhost:8888/t/register',
  })
}

export function postRegisterStudent(student){
  return request({
    data: student,
    method: 'post',
    url: '/',
  })
}

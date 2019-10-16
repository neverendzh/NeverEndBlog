import request from '@/utlis/request'
// 日记列表
export function diaryList (params) {
  return request({
    url: 'admin/sel/diary',
    method: 'post',
    data: params
  })
}
import request from '@/utlis/request'
// 留言列表
export function messageList (params) {
  return request({
    url: 'album/see/leaving/message',
    method: 'post',
    data: params
  })
}
//发表留言
export function submitMessage (params) {
  return request({
    url: '/album/leaving/message',
    method: 'post',
    params
  })
}
//回复留言接口
export function replyMessage (params) {
  return request({
    url: '/album/Reply/leaving/message',
    method: 'post',
    params
  })
}
//查看回复留言
export function seereplyMessage (params) {
  return request({
    url: '/album/see/rep/leaving/message',
    method: 'post',
    params
  })
}
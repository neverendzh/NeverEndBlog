import request from '@/utlis/request'
// 首页列表
export function titleList (params) {
  return request({
    url: 'lan/mu/top',
    method: 'post',
    data: params
  })
}
//树形数据
export function acticletree (params) {
    return request({
      url: 'system/admin/acticle/tree',
      method: 'get',
      data: params
    })
  }
  //查询树型id对应的文章列表
  export function searchacticletree (params) {
    return request({
      url: 'user/index/articlesHort/fenlei',
      method: 'get',
      params
    })
  }
  //根据关键字搜索文章
  export function searchacticle (params) {
    return request({
      url: 'user/index/search',
      method: 'get',
      params
    })
  }
  //文章首页排序
  export function acticletHort (params) {
    return request({
      url: 'user/index/articlesHort',
      method: 'get',
      data: params
    })
  }
  //置顶文章列表
  export function acticletTop (params) {
    return request({
      url: 'user/index/articlelevel',
      method: 'get',
      data: params
    })
  }
  //查看发布的文章
    export function acticletyulan (params) {
      return request({
        url: 'system/admin/fabu/yulan/json',
        method: 'get',
        params
      })
    }

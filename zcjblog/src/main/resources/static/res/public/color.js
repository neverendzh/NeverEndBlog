layui.use(['colorpicker','layer'], function(){
    layer = layui.layer;
    var $ = layui.$
        ,colorpicker = layui.colorpicker;
    //开启全功能
    colorpicker.render({
        elem: '#test-all'
        ,color: 'rgba(7, 155, 140, 1)'
        ,format: 'rgb'
        ,predefine: true
        ,alpha: true
        ,done: function(color){
            $('#test-all-input').val(color); //向隐藏域赋值
            color || this.change(color); //清空时执行 change
        }
        ,change: function(color){
            //给当前页面头部和左侧设置主题色
            $('.layui-side-scroll,.layui-header,.layui-side .layui-nav').css('background-color', color);
        }
    });
});

layui.use(['layer', 'form'], function(){
    var layer = layui.layer
        ,form = layui.form;

    form.on('select(filter)', function(data){
        console.log(data.elem); //得到select原始DOM对象
        console.log(data.value); //得到被选中的值
        console.log(data.othis); //得到美化后的DOM对象
    });
});

CKEDITOR.replace( 'editor1');
function huQuTextHtml() {
    var dataht = CKEDITOR.instances.editor1.getData();
    var datauht = encodeURIComponent(dataht);
    $.ajax({
        type:'post',
        url:'/system/yulan',
        data:'context='+datauht+"&articleName=000标题&articleSortId=1&briefIntroduction=测试摘要",
        success:function(data){
            if (data.code == "1"){
                window.open(data.url);
            }
        }
    });
}
function releaseBlog() {
    layui.use('layer', function(){
        //询问框
        layer.confirm('确定发布', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var index = layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });
            var dataht = CKEDITOR.instances.editor1.getData();
            var datauht = encodeURIComponent(dataht);
            $.ajax({
                type:'post',
                url:'/system/publish/articles',
                data:'context='+datauht+"&articleName=000标题&articleSortId=1&briefIntroduction=测试摘要"+datauht,
                success:function(data){
                    layer.close(index);
                    if (data.code == "1"){
                        layer.msg("发布成功");
                    }
                }
            });
        }, function(){
            layer.msg('已取消');
        });

    });
}
function clearText() {
    CKEDITOR.instances.editor1.setData(' ')
}

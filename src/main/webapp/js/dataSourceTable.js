var table;
layui.use('table', function(){
    table = layui.table;
});
table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
        ,layEvent = obj.event; //获得 lay-event 对应的值
   if(layEvent === 'del'){
        layer.confirm('真的删除行么', function(index){

            $.ajax({
                url:'/user/deleteUser.action?id='+data.id,
                dataType:'text',
                type:'post',
                success:function(data){
                    if(data==="success"){
                        layer.msg('删除成功',{icon:1},function(){

                            layer.close(index);
                        });
                    }else if(data==="no"){
                        layer.msg('删除失败',{icon:2},function(){
                            layer.close(index);
                        });
                    }
                }

            })
            obj.del(); //删除对应行（tr）的DOM结构
        });
    } else if(layEvent === 'edit'){
        layer.open({
            type: 2,
            area: ['480px', '320px'], //宽高
            skin: 'layer-ext-seaning',
            content:'upDatedataSourcewh.html',
            success:function (layero,index) {
                //获取到弹出层的窗口对象
                var iframeWin=window[layero.find('iframe')[0]['name']];
                if(null!=iframeWin){
                    //调用弹出层的方法，传值回显
                    iframeWin.test(data.describe,data.name,data.collection,data.source);
                }
            },
            end:function () {
                table.reload("test");
            }

        });
    }
});
$('#button1').click(function(){
    layer.open({
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['480px', '320px'], //宽高
        content: '/dataSourcewh.html',
        end:function () {
            location.reload();
        }
    });


});
$('#button2').click(function(){
   var ziduan=$('#describe').val();
    table.render({
        elem: '#main',
        url: '/comname/getDataSourcewh.action?ziduan=' + ziduan,
        height: 'full-10',
        cols: [[

            {field: 'describe', event: 'test', title: '数据源'},
            {field: 'name', sort: 'ture', title: '描述'},
            {field: 'collection', event: 'test', title: '对应Collection'},
            {field: 'source', sort: 'true', title: '对应Source'},
            {fixed: 'right', align: 'center', toolbar: '#barDemo'}
        ]],
        page: false
    })


});

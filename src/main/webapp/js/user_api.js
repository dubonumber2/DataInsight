
var user_type="";
var operation_type="";
layui.use('form', function(){
    var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
    form.render();
    form.render('select','test3');
    form.on('select(user_type)',function(data){
        user_type=data.value;
    });
    form.render();
    form.render('select','test4');
    form.on('select(operation_type)',function(data){
        operation_type=data.value;
    });

});

var starDate="";
var endDate="";
layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: '#enddate', //指定元素
        done: function (value) {
            starDate=value;
        }
    });
    laydate.render({
        elem: '#zenddate', //指定元素
        done: function (value) {
            endDate=value;
        }
    });
});


    $('#button1').click(function(){
        var table=layui.table;
            table.render({
                elem: '#main',
                height: 'full-10',
                cellMinWidth: 80 ,
                url: '/useroperation/getApi.action?starDate='+starDate+'&endDate='+endDate+'&operation_explain='+user_type+'&operation_type='+operation_type,
                cols:[[
                    {field: 'ip', title: 'ip地址'},
                    {field: 'ip_service', title: 'ip来源'},
                    {field:'operation_type',sort: true,title:'操作类型'},
                    {field:'operation_explain',sort: true,title:'操作详情'},
                    {field:'operation_time', sort: true,title:'操作时间'},
                ]],
                page: true,
                limit: 600,
                limits: [600, 900, 1200]

            })
    });



$('#button2').click(function(){
    var url='/useroperation/getApi.action?starDate='+starDate+'&endDate='+endDate+'&operation_type='+operation_type+'&operation_explain='+user_type+'&dowload=dowload&page=1&limit=5000';
    window.location.href=url;
})



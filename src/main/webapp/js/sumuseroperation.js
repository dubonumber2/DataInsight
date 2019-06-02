var jsondt;
var str="";

$.ajax({
    url:'/comname/getClueminingCompany.action',
    type:'post',
    dataType:'json',
    async:false,
    success:function(data){

        jsondt=data;
    }
});
str+='<option value="">直接选择或搜索选择</option>'
for(var i=0;i<jsondt.length;i++){
    str+='<option value="'+jsondt[i].name+'">'+jsondt[i].name+'</option>'
};
var user_company="";
document.getElementById("user_company").innerHTML=str;
layui.use('form', function(){
    var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

    form.render();
    form.render('select', 'test2');
    form.on('select', function(data) {
         user_company = data.value;

    });
});
    $('#button1').click(function(){
        var table=layui.table;
            table.render({
                elem: '#main',
                height: 'full-10',
                cellMinWidth: 80 ,
                url: '/useroperation/getSum.action?user_company='+user_company,
                cols: [[
                    {field: 'user_company', title: '公司名称'},
                    {field:'operation_name',sort: true,title:'操作名称'},
                    {field:'realname',event:'test',title:'真实姓名'},
                    {field:'user_name',event:'test',title:'用户名'},
                    {field:'sumcount',sort: true,title:'操作次数'},
                    {field:'dowloadcount',sort: true,title:'累计下载量'}
                ]],
                page: false
            })
    });
$('#button2').click(function(){
    var url='';
    url='/useroperation/getSum.action?user_company='+user_company+'&dowload=dowload';
    window.location.href=url;
})



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
str+='<option value="">请选择</option>'
for(var i=0;i<jsondt.length;i++){
    str+='<option value="'+jsondt[i].name+'">'+jsondt[i].name+'</option>'
};
var user_company="";
var user_type="";
document.getElementById("user_company").innerHTML=str;
layui.use('form', function(){
    var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

    form.render();
    form.render('select', 'test2');
    form.on('select(company)', function(data) {
         user_company = data.value;
    });
    form.render('select','test3');
    form.on('select(user_type)',function(data){
        user_type=data.value;
    })
});



var operation_time="";
var end_time="";
layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: '#enddate', //指定元素
        done: function (value) {
            operation_time=value;
        }
    });
    laydate.render({
        elem: '#zenddate', //指定元素
        done: function (value) {
            end_time=value;
        }
    });
});
    var operation_name="";
    var user_name="";
    var realname="";
    $('#button1').click(function(){
        var table=layui.table;
         user_name=document.getElementById("username").value;
         realname=document.getElementById("realname").value;
        operation_name=$('input[name="sex"]:checked').val();
        if(operation_name==='下载操作') {
            table.render({
                elem: '#main',
                height: 'full-10',
                cellMinWidth: 80 ,
                url: '/useroperation/getByName2.action?user_name=' + user_name + '&operation_time=' + operation_time +'&end_time='+end_time+'&operation_name=' + operation_name+'&user_company='+user_company+'&realname='+realname+'&user_type='+user_type,
                cols:[[
                    {field: 'user_company', title: '公司名称'},
                    {field: 'realname', title: '真实姓名'},
                    {field:'user_name',title:'用户名'},
                    {field:'operation_explain',sort: true,title:'操作详情'},
                    {field:'operation_time', sort: true,title:'操作时间'},
                    {field:'dowloadcount',style:'background-color: #009688; color: #fff;',sort: true,title:'下载量'},
                ]],
                page:false
            })
        }else {
            table.render({
                elem: '#main',
                height: 'full-10',
                cellMinWidth: 80 ,
                url: '/useroperation/getByName1.action?user_name=' + user_name + '&operation_time=' + operation_time +'&end_time='+end_time+ '&operation_name=' + operation_name+'&user_company='+user_company+'&realname='+realname+'&user_type='+user_type,
                cols: [[
                    {field: 'user_company', title: '公司名称'},
                    {field: 'realname', title: '真实姓名'},
                    {field: 'user_name', title: '用户名'},
                    {field: 'operation_explain', sort: true, title: '操作详情'},
                    {field: 'operation_time', sort: true, title: '操作时间'},
                ]],
                page: true,
                limit: 100,
                limits: [100, 200, 300]

            })
        }
    });
$('#button2').click(function(){
    var url='';
    user_name=document.getElementById("username").value;
    realname=document.getElementById("realname").value;
    operation_name=$('input[name="sex"]:checked').val();
    if(operation_name==='下载操作'){
        //alert(user_name+": "+operation_time+"end:"+end_time+"操作名称:"+operation_name);
        url='/useroperation/getByName2.action?user_name=' + user_name + '&operation_time=' + operation_time +'&end_time='+end_time+'&operation_name=' + operation_name+'&user_company='+user_company+'&realname='+realname+'&user_type='+user_type+'&dowload=dowload';

    }else{
       // alert(user_name+": "+operation_time+"end:"+end_time+"操作名称:"+operation_name);
        url='/useroperation/dowloadByName1.action?user_name=' + user_name + '&operation_time=' + operation_time +'&end_time='+end_time+ '&operation_name=' + operation_name+'&user_company='+user_company+'&realname='+realname+'&user_type='+user_type+'&page=1';
    }

    window.location.href=url;
})



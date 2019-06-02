
var enddate="";
layui.use('laydate', function(){
    var laydate = layui.laydate;
    var table=layui.table;
    //执行一个laydate实例
    laydate.render({
        elem: '#enddate', //指定元素
        done:function(value){
            enddate=value;
            table.render({
                elem:'#main',
                height:'full-10',
                url:'/mongo/getDate.action?date='+enddate,
                cols:[[

                    {field:'type', width:145,title:'数据源'},
                    {field:'mongoCount', width:145, sort: true,title:'MongoDB总量'},
                    {field:'mysqlCount', width:112, sort: true,title:'Mysql总量'},
                    {field:'mongoIncrement', width:137, sort: true,title:'MongoDB增量'},
                    {field:'mysqlIncrement', width:120, sort: true,title:'Mysql增量'},
                    {field:'errorCount', width:134, sort: true,title:'增量的误差数'},
                    {field:'mongoNewTime', width:155, sort: true,title:'Mongo最新时间'},
                    {field:'overTime', width:122, sort: true,title:'统计时间'}

                ]],
                page:false,
                limit:200,
                limits:[100,200,500,800]
            });
        }
    });
});

$('#button1').click(function(){
    var url='';

        url='/mongo/getDate.action?dowload=dowload&date='+enddate;


    window.location.href=url;
})
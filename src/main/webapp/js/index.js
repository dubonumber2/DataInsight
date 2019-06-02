


var menuStr="";
$.ajax({
    url:'/menu/getMenuByRole_id.action',
    dataType:'json',
    async:false,
    success:function(menulist){
        for(var i=0;i<menulist.length;i++){
            var menu=menulist[i];//每个一级菜单
            menuStr+="<li class='layui-nav-item' >"
            menuStr+="<a  href="+'javascript:;'+">"+menulist[i].text+"</a>"
            menuStr+="<dl class='layui-nav-child'>"
            var chimenu=menu.children;
            for(var j=0;j<chimenu.length;j++){
                menuStr+=" <dd><a href='javascript:;' data-url='"+chimenu[j].url+"'><label>"+chimenu[j].text+"</label></a></dd>"
            }
            menuStr+="</dl></<li>"
        }
    }
});
$('#sideNav').html(menuStr);


layui.use(['element', 'layer'], function() {
    var $ = layui.jquery,
        element=layui.element;

    //iframe自适应
    $(window).on('resize', function() {
        var $obj = $('#tabContainers');
        $obj.height($(this).height()-145);
        $obj.find('iframe').each(function() {
            $(this).height($obj.height());
            $(this).width($obj.width());
        });
    }).resize();

    //添加tab
    var $tabs = $('#tabTitle'); //tab标题
    var $tabContainers = $('#tabContainer'); //tab 内容块
    var $sideNav = $('#sideNav'); //侧边导航
    var i=1;
//给nav绑定事件
    $('.layui-nav .layui-nav-item .layui-nav-child dd> a').each(function() {
        var $obj = $(this);
        var url = $obj.data('url'); //tab内容的地址
        //获取设定的url
        if(url !== undefined) {
            $obj.on('click', function() {
                var tabTitle = $obj.html();
                var count = 0;
                var tabId = $tabs.find('li:last-child').attr('lay-id');
                $tabs.find('li').each(function(i, e) {
                    if($(this).find('label').text() === $obj.text()) {
                        count++;
                        tabId = $(this).attr('lay-id');
                    };
                });

                if(count === 0) {
                    //添加删除样式
                    /*tabTitle += '<i class="layui-icon layui-unselect layui-tab-close">&#x1006;</i>';*/
                    //添加tab
                    element.tabAdd('page-tab', {
                        title: tabTitle,
                        content: '<iframe src="' + url + '"></iframe>',
                        id: ++i
                    });
                    tabId = $tabs.find('li:last-child').attr('lay-id');
                    console.log(tabId);
                    //iframe 自适应
                    var $content = $('.layui-tab-content');
                    $content.find('iframe').each(function() {
                        $(this).height($content.height());

                    });
                    //点击tab li切换导航，切换侧边导航的layui-this
                    var $li = $tabs.find('li');
                    $li.find('label').on('click', function() {
                        var thisPage = $(this).text(); //当前显示页的标题
                        var sidePage = $sideNav.find('dd.layui-this').find('a').text(); //当前侧面导航显示的标题
                        if(thisPage != sidePage) {
                            $sideNav.find('dd').each(function() {
                                if($(this).find('label').text() == thisPage) {
                                    $sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
                                    $(this).addClass('layui-this');
                                }
                            })
                            if(thisPage == '爬虫抓取统计') { //始终留置一个tab
                                $sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
                            }
                        }
                    })
                    //给tab-nav绑定关闭事件
                    $li.eq($li.length - 1).children('i.layui-tab-close').on('click', function() {
                        element.tabDelete('page-tab', tabId);
                        var thisPage = $tabs.find('li.layui-this').find('label').text(); //当前显示页的标题
                        var sidePage = $sideNav.find('dd.layui-this').find('a').text(); //当前侧面导航显示的标题
                        if(thisPage != sidePage) {
                            $sideNav.find('dd').each(function() {
                                if($(this).find('label').text() == thisPage) {
                                    $sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
                                    $(this).addClass('layui-this');
                                }
                            })
                            /*if(thisPage == '爬虫抓取统计') { //始终留置一个tab
                                $sideNav.find('.layui-nav-child >dd').removeClass('layui-this');
                            }*/
                        }
                    });
                    //获取焦点
                    element.tabChange('page-tab', tabId);
                } else {
                    //切换tab
                    element.tabChange('page-tab', tabId);
                }
            });
        }
    });
        element.init();
})
var realName="";
$.ajax({
    url:'/user/getMsg.action',
    dataType:'text',
    async:false,
    success:function(data){
      realName=data;
    }
});

/*document.getElementById("msg").innerText=realName;*/

$('#msg').append(realName);
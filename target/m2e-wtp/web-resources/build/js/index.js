/**
 * 首页脚本
 */
;
window.index || (function ($) {
    'use strict';

    var sidebar, refreshContent, loadContent, loadDialog;


    var initSidebar = (function () {
        var emptyUrl = 'javascript:;';
        var selectMenu;
        return function (menus, panel, treeviewMenu,count) {
            menus=menus.sort(function(a,b){return a.weight-b.weight});
            for (var i = 0; i < menus.length; i++) {
                (function (menu) {
                    var url = menu.url ? menu.url : emptyUrl;
                    var htmtxt = '<li id="sidebar_' + menu.key + ' sidebar_menu" value="'+menu.weight+'">' +
                        '<a id="at" href="' + url + '">' +
                        '<i class="fa ' + menu.icon + '"></i>  ' +
                        '<span>' + menu.name + '</span>';
                    if(menu.key=='readData.readDataList'||menu.key=='readData.readDataListHospital'||menu.key=='readData.readDataListDepartment'){
                        if(count!=0){
                             htmtxt +='<span id="readCount" class="label label-danger pull-right">'+count+'</span>';
                         }else{
                            htmtxt +='<span id="readCount" class="label label-danger pull-right" style="display: none">'+count+'</span>';
                        }
                    }

                    htmtxt += '</a></li>';
                    var item = $(htmtxt)
                        .appendTo(panel);

                    if (treeviewMenu) {
                        item.addClass('treeview');
                        if(menu.key=='outsideService'||menu.key=='readData'||menu.key=='insideService'){
                            item.addClass("active");
                        }
                    }
                    if (menu.childs && menu.childs.length) {
                        item.find("a").append('<i class="fa fa-angle-left pull-right"></i>');
                        initSidebar(
                            menu.childs,
                            $('<ul class="treeview-menu"></ul>').appendTo(item),
                            false,
                            count
                        )
                    }

                    item.find("a").unbind("click").click(function () {
                        var h = this.href;
                        if (h.length > 0 && h != emptyUrl) {
                            $('.sidebar').find("li.active").removeClass("active");
                            selectMenu = item;
                            $(this).parents("li").addClass("active");
                            loadContent(h);
                        }
                        if (selectMenu) {
                            selectMenu.addClass("active").parents("li").addClass("active");
                        }
                        return false;
                    })
                })(menus[i]);
            }
        }
    })();

    sidebar = function(menus, panel, treeviewMenu,count){
        initSidebar(menus, panel, treeviewMenu,count);
        initSidebarScroll();
    };

    var isInitSidebarScroll = false;
    function initSidebarScroll(){
        var sidebar = $(".sidebar-menu");
        var height = $(window).height() - $("#content_heade").height();
        var sidebarHeight = sidebar[0].scrollHeight;

        var top = 0;
        Object.defineProperty(sidebar[0], "scrollTop", {
            set : function (val) {
                top = val;
                $(this).css("position", "relative").css("top", - val + "px");
            },
            get : function(){
                return top;
            }
        });

        if(sidebarHeight > height){
            if(!isInitSidebarScroll){
                isInitSidebarScroll = true;
                sidebar.slimScroll({
                    height: height,color:"#FFF"
                });
            }else {
                sidebar.parent().height(height);
                sidebar.height(height);
            }
            sidebar.parent().css("overflow", "visible");
            sidebar.css("overflow", "visible");
        }
    }

    $(window).resize(initSidebarScroll);

    function load(container, url, selector, callback) {
        return $.ajax({
            url: url,
            // if "type" variable is undefined, then "GET" method will be used\
            dataType: "html"
        }).done(function (responseText) {
            var ele = $('<div>').append(
                $.parseHTML(responseText, true)
            );
            container.html(ele.find(selector));
            eval(ele.find("script").text());
        }).complete(callback && function (jqXHR, status) {
            container.each(callback, [jqXHR.responseText, status, jqXHR]);
        });
    }

    loadContent = (function () {
        var curUrl;
        var request = null;
        return function (url, notHistory) {
            if(!notHistory){
                history.pushState({url:url}, null);
            }
            if (request) {
                request.abort();
            }
            request = load($(".content-wrapper").stopLoading().startLoading(), url, ".content-wrapper-inner", function () {
                request = null;
            });

            //request = $(".content-wrapper").stopLoading().startLoading().load(url + "  .content-wrapper-inner", function (txt) {
            //
            //});
            curUrl = url;
        }
    })();

    $(window).on('popstate', function(e) {
        loadContent(e.originalEvent.state.url, true);
    });

    loadDialog = (function (options) {
        var url = ((typeof options) == "string") ? options : options.url;
        var target = ((typeof options) == "string") ? options : options.target;
        options = $.extend({backdrop: false, content: "加载中..."}, $.isPlainObject(options) ? options : {});
        if (!url) {
            $.alert("url 不能为空");
            return null;
        }
        var dialog;

        dialog = $.dialog(options);

        var body = dialog.body;

        body.startLoading();
        dialog.overlay.on('shown.bs.modal', function () {

            var top = parseInt(dialog.dialog.css("marginTop"));
            if (!top) {
                top = 0;
            }

            body.css("max-height", $(window).height() - (dialog.dialog.height() - body.height()) - (top));

            //TODO 加载被稍微延迟了，所以可能需呀修改，加快加载速度,修改需要谨慎
            body.load(url + "  .dialog-content", function (txt) {
                var doc = $('<div>').append(
                    $.parseHTML(txt, true)
                );
                eval(doc.find("script").text());

                var buttons = body.find(".dialog-footer-buttons");
                buttons.find("[type='submit']").click(function () {
                    body.find("form").submit();
                });
                buttons.appendTo(dialog.dialog.find(".modal-footer").empty());

                body.find("form").submit(function () {
                    //ajax 请求
                    //buttons.find("button").attr("disabled", "disabled");
                    var form = $(this);
                    dialog.dialog.startLoading();
                    $.ajax({
                        cache: false,
                        dataType: "json",
                        type: form.attr("method"),
                        url: form.attr("action"),
                        data: form.serialize(),
                        error: function (request) {
                            dialog.dialog.stopLoading();
                            $.alert(request);
                        },
                        success: function (data) {
                            dialog.dialog.stopLoading();
                            if (data.status == 1) {
                                form.vaild(data.msgMap);
                            } else if (data.status == 0) {
                                dialog.close();
                                if (target != undefined) {

                                    loadContent(target);
                                }
                            } else {
                                $.alert(data.msg);
                            }
                        }
                    });
                    return false;
                });
            });
        });
        return dialog;
    });
    //{"status":1,"msgMap":{"truename":"truename必须是10到2个字符!","password":"密码必须是30到6个字符!","cellphone":"cellphone
    //    必须是11到11个字符!","username":"username必须是20到6个字符!"}}



    refreshContent = function () {
        loadContent(curUrl);
    };

    window.index = {
        sidebar: sidebar,
        refreshContent: refreshContent,
        loadContent: loadContent,
        loadDialog: loadDialog
    }
}(jQuery));
/**
 * 主要js
 */
;
window.mini || (function ($) {
    'use strict';
    var doc = $(document),
        win = $(window), body = $(document.body),
        m = window.mini = {
            vaild: function (msgs) {
                var missMsgs = [];
                this.find(".vaild-message").remove();
                this.find(".has-error").removeClass("has-error");
                var first = null;
                for (var name in msgs) {
                    var input = this.find("*[name='" + name + "']");
                    if (!first) {
                        first = input;
                    }
                    if (input.length) {
                        if (input.attr('id') == name) {
                            var group = input.parents('.form-group');
                            group.addClass("has-error");
                            var lable = group.find("label");
                            if (!lable.length) {
                                lable = $('<label class="control-label" for="' + name + '"></label>');
                                input.before(
                                    lable
                                );  //<i class="fa fa-times-circle-o"></i>' + msgs[name] + '
                            }
                            lable.append('<span class="vaild-message"> ' + msgs[name] + '</span>');
                        } else {
                            alert("表单域必须id 和name 属性相同, name:" + name);
                        }
                    } else {
                        missMsgs.push(msgs[name]);
                    }
                }
                if (first) {
                    first.focus();
                }
                if (missMsgs.length) {
                    var a = this.find(".alert");
                    if (!a.length) {
                        a = $('<div class="alert"></div>');
                    }
                    a.addClass('alert-danger alert-dismissable')
                        .append('<button type="button" class="close" ' +
                        'data-dismiss="alert" aria-hidden="true">&times;</button>' +
                        '<h4><i class="icon fa fa-ban"></i> 错误!</h4>');
                    for (var i = 0; i < missMsgs.length; i++) {
                        a.append('<div>' + missMsgs[i] + '</div>');
                    }
                }
                //var fild = this.find("#name");
                //alert(find.length);
                return this;
            },
            /**
             * 需要 有一个 select-row-checkbox  选择列
             * @returns {mini}
             */

            baseTable: function () {
                var t = this;
                t.find("tbody").find("tr").click(function (e) {
                    if (!$(e.target).is("input")) {
                        var c = $(this).find(".select-row-checkbox");
                        c.prop("checked", !c.prop("checked"));
                        changeChecked(c);
                    }
                });

                function changeChecked(c) {
                    var t = c.parents("tr");
                    if (c.prop("checked")) {
                        t.addClass("danger select");
                    } else {
                        t.removeClass("danger select");
                    }
                }

                t.find(".select-row-checkbox").change(function () {
                    changeChecked($(this));
                });
                return t;
            },
            startLoading: function () {
                return this.addClass("overlay-wrapper")
                    .append(
                    $('<div class="overlay">' +
                        '<i class="fa fa-spinner fa-spin"></i>' +
                        '</div>')
                );
            },
            stopLoading: function () {
                this.removeClass("overlay-wrapper").find(".overlay").remove();
                return this;
            },
            alert: function (content) {
                $.dialog({
                    type: "alert",
                    title: "提示",
                    content: content,
                    size: 'modal-sm'
                });
            },
            heartRateGrid: function (cfg) {
                cfg = $.extend({
                    data: [],
                    doctor_data:0,
                    fetal_data: 0,
                    fontSize: "12",
                    fontStyle: "italic",
                    fontName: '"Source Sans Pro","Helvetica Neue",Helvetica,Arial,sans-serif',//"Source Sans Pro","Helvetica Neue",Helvetica,Arial,sans-serif
                    width: "170mm",
                    height: "100mm",
                    divY: "5",
                    xStart:0,
                    padding: [10, 4, 10, 6],//注意单位也是mm
                    lineColor: "#000",
                    paintRatioWidth: null, // paintRatio打印倍率，用这个进行缩放满足最后的打印尺寸，注意宽度。。如果可能被浏览器再次进行缩放
                    paintRatioHeight: null, // paintRatio打印倍率
                    dataShowCount: 20 * 120,//显示数量，根据这个计算x 的宽度，可以大于数据，如果不填写，或者null，表示直接使用数据的长度
                    lineWidth: 1,
                    printRatio: 4,//打印倍数
                    wrong: {
                        start: 90, end: 100, lineColor: "green", lineWidth: 1,
                        rectColor: "rgba(205,237,253,0.3)"
                    },
                    xRuler: 120,//120
                    xRulerText: function (v, n) {
                        return n + "'"
                    },
                    xRulerLine: function (v, n) {
                        return 1;
                    },
                    xRulerColor: function (v, n) {
                        return "#000";
                    },
                    xRulerStyle: function (v, n) {
                        return 0;
                    },
                    xRulerDottedColor: function (v, n) {
                        return "#ccc";
                    },
                    yMax: 220,
                    yMin: 40,
                    yRuler: {
                        "40": {line: 1, color: "#000"},
                        "50": {line: 1, color: "#000"},
                        "60": {line: 1, color: "#000", text: "60"},
                        "70": {line: 1, color: "#000"},
                        "80": {line: 1, color: "#000", text: "80"},
                        "90": {line: 1, color: "#000"},
                        "100": {line: 1, color: "#000", text: "100"},
                        "110": {line: 1, color: "#000"},
                        "120": {line: 1, color: "#000", text: "120"},
                        "130": {line: 1, color: "#000"},
                        "140": {line: 1, color: "#000", text: "140"},
                        "150": {line: 1, color: "#000"},
                        "160": {line: 1, color: "#000", text: "160"},
                        "170": {line: 1, color: "#000"},
                        "180": {line: 1, color: "#000", text: "180"},
                        "190": {line: 1, color: "#000"},
                        "200": {line: 1, color: "#000", text: "200"},
                        "210": {line: 1, color: "#000"},
                        "220": {line: 1, color: "#000", text: "220"}
                    },
                    yRuler_: {
                        "40": {line: 1, color: "#adadad"},
                        "45": {line: 1, color: "#adadad"},
                        "50": {line: 1, color: "#adadad"},
                        "55": {line: 1, color: "#adadad"},
                        "60": {line: 1, color: "#fff"},
                        "65": {line: 1, color: "#adadad"},
                        "70": {line: 1, color: "#adadad"},
                        "75": {line: 1, color: "#adadad"},
                        "80": {line: 1, color: "#fff"},
                        "85": {line: 1, color: "#adadad"},
                        "90": {line: 1, color: "#adadad"},
                        "95": {line: 1, color: "#adadad"},
                        "100": {line: 1, color: "#adadad"},
                        "105": {line: 1, color: "#adadad"},
                        "110": {line: 1, color: "#fff"},
                        "115": {line: 1, color: "#adadad"},
                        "120": {line: 1, color: "#adadad"},
                        "125": {line: 1, color: "#adadad"},
                        "130": {line: 1, color: "#adadad"},
                        "135": {line: 1, color: "#adadad"},
                        "140": {line: 1, color: "#adadad"},
                        "145": {line: 1, color: "#adadad"},
                        "150": {line: 1, color: "#adadad"},
                        "155": {line: 1, color: "#adadad"},
                        "160": {line: 1, color: "#adadad"},
                        "165": {line: 1, color: "#adadad"},
                        "170": {line: 1, color: "#adadad"},
                        "175": {line: 1, color: "#adadad"},
                        "180": {line: 1, color: "#adadad"},
                        "185": {line: 1, color: "#adadad"},
                        "190": {line: 1, color: "#adadad"},
                        "195": {line: 1, color: "#adadad"},
                        "200": {line: 1, color: "#adadad"},
                        "205": {line: 1, color: "#adadad"},
                        "210": {line: 1, color: "#adadad"},
                        "215": {line: 1, color: "#adadad"},
                        "220": {line: 1, color: "#adadad"}
                    }
                }, $.isPlainObject(cfg) ? cfg : {});

                var wrap = $("<div>").addClass("center-block").appendTo(this);
                var ratio = (window.devicePixelRatio || 1) * cfg.printRatio;
                var paintRatio = 1.0;
                if (cfg.paintRatioWidth) {
                    cfg.width = Math.floor(parseInt(cfg.width) * cfg.paintRatioWidth) + "mm";
                }
                wrap.width(cfg.width);
                if (cfg.paintRatioHeight) {
                    cfg.height = Math.floor(parseInt(cfg.height) * cfg.paintRatioHeight) + "mm";
                }
                wrap.height(cfg.height);

                var width = wrap.width();
                var height = wrap.height();
                var canvas = $('<canvas width="' + width * ratio +
                    '" height="' + height * ratio + '" id="canvas">' +
                    '</canvas>')
                    .appendTo(wrap).width(width).height(height)[0];

                var mmRatio = (width / parseInt(cfg.width));

                var pad = cfg.padding;
                for (var i = 0; i < pad.length; i++) {
                    pad[i] = pad[i] * mmRatio;
                }

                cfg.ratio = ratio;
                cfg.showWidth = width * ratio;
                cfg.showHeight = height * ratio;

                m.heartRateGridPaint(canvas, cfg);
            },
            heartRateGridPaint: function (canvas, cfg) {
                var ratio = cfg.ratio;
                var heartRate = cfg.data;

                var dataShowCount = Math.max(cfg.dataShowCount || heartRate.length, heartRate.length);
                var ceilCount = Math.ceil(dataShowCount / cfg.xRuler) * cfg.xRuler;
                //console.log(ceilCount,heartRate.length/cfg.xRuler,heartRate.length%cfg.xRuler, Math.ceil(heartRate.length/cfg.xRuler));

                var pad = cfg.padding;
                var padTop = Math.floor(pad[0] * ratio);//面板内补丁
                var padRight = Math.floor(pad[1] * ratio);//面板内补丁
                var padBottom = Math.floor(pad[2] * ratio);//面板内补丁
                var padLeft = Math.floor(pad[3] * ratio);//面板内补丁

                var showWidth = cfg.showWidth;
                var showHeight = cfg.showHeight;
                var bodyWidth = showWidth - padRight - padLeft;
                var bodyHeight = showHeight - padTop - padBottom;
                var yValue = cfg.yMax - cfg.yMin;

                //胎动数据，和长度
                var daidong_data = cfg.fetal_data;
                //console.log('胎动数据，和长度:'+daidong_data.length);

                var doctor_data=cfg.doctor_data;
                //console.log('医生干预的胎动值:'+doctor_data);
                //console.log('医生干预的胎动值，和长度:'+doctor_data.length);

                var ctx = canvas.getContext("2d");
                var font = cfg.fontStyle + " " + (cfg.fontSize * ratio) + "px " + cfg.fontName;

                var numberFontSize = calFontSize("888");
                ctx.font = font;

                var xWidth = bodyWidth / ceilCount;
                var wrong = cfg.wrong;
                var wrongY;
                if (wrong) {
                    wrongY = calYValue(wrong.end) ;
                    ctx.save();
                    ctx.fillStyle = wrong.rectColor;
                    ctx.fillRect(padLeft, wrongY, bodyWidth, calYValue(wrong.start) - wrongY);
                    ctx.restore();
                }
                //y 轴承线条
                var line, x, y;
                var yRuler = cfg.yRuler;
                var yRuler_ = cfg.yRuler_;
                if (cfg.divY == 5) {
                    for (var rk in yRuler_) {
                        if (yRuler_.hasOwnProperty(rk)) {
                            ctx.beginPath();
                            var r = yRuler_[rk];
                            line = calLineWidth(r.line);
                            ctx.lineWidth = line;
                            ctx.strokeStyle = r.color;
                            y = calYValue(parseInt(rk));
                            for (var l = 0; l < bodyWidth - 20; l = l + 40) {
                                ctx.moveTo(padLeft + l, y);
                                ctx.lineTo(padLeft + l + 20, y);
                            }
                            ctx.stroke();
                            ctx.closePath();
                        }
                    }
                }
                for (var rk in yRuler) {
                    if (yRuler.hasOwnProperty(rk)) {
                        ctx.beginPath();
                        var r = yRuler[rk];
                        line = calLineWidth(r.line);
                        ctx.lineWidth = line;
                        ctx.strokeStyle = r.color;
                        y = calYValue(parseInt(rk));
                        ctx.moveTo(padLeft, y);
                        ctx.lineTo(padLeft + bodyWidth, y);
                        ctx.stroke();
                        ctx.closePath();
                        if (r.text) {
                            ctx.fillText(
                                r.text,
                                padLeft - numberFontSize.width - 2 * ratio,
                                Math.round(y + (numberFontSize.height / 3) / 2 + line / 2)
                            );
                        }
                    }
                }
                //x线条
                var xEnd = 0;
                for (var i = 0, n = 0; i <= ceilCount; i += cfg.xRuler, n++) {
                    ctx.beginPath();
                    line = calLineWidth(cfg.xRulerLine(i, n));
                    ctx.strokeStyle = cfg.xRulerColor(i, n);
                    ctx.lineWidth = line;
                    var style = cfg.xRulerStyle(i, n);
                    x = calXValue(parseInt(i));

                    if (style == 0) {
                        ctx.moveTo(x, padTop);
                        ctx.lineTo(x, padTop + bodyHeight);
                        ctx.stroke();
                        ctx.closePath();
                        var text = cfg.xRulerText(i, n);
                        if (text) {
                            ctx.fillText(
                                text,
                                x - numberFontSize.width - (-12 * ratio),
                                padTop + bodyHeight + numberFontSize.height + 2
                            );
                        }

                    } else {
                        ctx.strokeStyle = cfg.xRulerDottedColor(i, n);
                        for (var l = 0; l < bodyHeight; l = l + 40) {
                            ctx.moveTo(x, padTop + l);
                            ctx.lineTo(x, padTop + l + 20);
                        }
                        ctx.stroke();
                        ctx.closePath();
                    }
                }
                xEnd = n;
                printTaiDong(daidong_data);
                printTaiDong(doctor_data,true);
                function printTaiDong(data, direction) {
                    if (data != null && data.length > 0) {
                        var xEndMs = xEnd *60 * 1000;
                        var xStartMs = cfg.xStart * 60 * 1000;
                        for (var i = 0; i < data.length; i++) {
                            var dMs = data[i];
                            if(dMs<xStartMs||dMs>xEndMs){
                                continue;
                            }
                            var dS = dMs / 1000;
                            var preDMs = 0;
                            var preDS = 0;
                            if (i > 0) {
                                preDMs = data[i - 1];
                                preDS = preDMs / 1000;
                                if (dS - preDS < 5) {
                                    continue;
                                }
                            }
                            var x = (dMs-xStartMs)*xWidth/500;//xWidth 代表的是两个点之间的宽度，一秒钟两个点，那么两个点之间的时间间隔就是500毫秒
                            printArrow(x,direction);
                        }
                    }
                }

                //绘制曲线
                paintLine(cfg.lineWidth, cfg.lineColor);

                if (wrong) {
                    ctx.save();
                    ctx.beginPath();
                    wrongY = calYValue(wrong.end);
                    ctx.rect(
                        padLeft, wrongY,
                        bodyWidth, calYValue(wrong.start) - wrongY
                    );
                    ctx.clip();
                    paintLine(wrong.lineWidth, wrong.lineColor);
                    ctx.restore();
                }

                function calLineWidth(width) {
                    return width * ratio;
                }

                //计算y轴线条的位置
                function calYValue(y) {
                    return Math.round(padTop + bodyHeight * (yValue - (y - cfg.yMin)) / yValue);
                }

                function calXValue(x) {
                    return Math.round(padLeft + xWidth * x);
                }

                function calFontSize(str) {
                    var m = ctx.measureText(str);
                    return {
                        width: Math.round(m.width * ratio),
                        height: Math.round(m.width * ratio)
                    }
                }

                function printArrow(x, direction) {
                    //参数说明 x横轴位置，direction箭头是否朝下，true为朝下，false或者缺省箭头朝上。
                    //内部参数说明 ox,oy原点坐标  x1,y1第一个端点的坐标，x2,y2第二个端点的坐标
                    var y = 50;
                    var x1 = x;
                    var x2 = x;
                    var y1, y2;
                    if (direction) {
                        y1 = Math.round((bodyHeight / yValue) * (y - cfg.yMin));
                        y2 = 0;
                    } else {
                        y1 = 0;
                        y2 = Math.round((bodyHeight / yValue) * (y - cfg.yMin));
                    }

                    var ox = 0;
                    var oy = 0;
                    var sta = new Array(x1 + padLeft, -y1 + showHeight - padBottom);
                    var end = new Array(x2 + padLeft, -y2 + showHeight - padBottom);
                    //画线
                    ctx.beginPath();
                    ctx.lineWidth = calLineWidth(cfg.lineWidth * 1.5);
                    ctx.translate(ox, oy, 0); //坐标源点
                    ctx.moveTo(sta[0], sta[1]);
                    ctx.lineTo(end[0], end[1]);
                    ctx.fill();
                    ctx.stroke();
                    ctx.save();
                    //画箭头
                    ctx.translate(end[0], end[1]);
                    //我的箭头本垂直向下，算出直线偏离Y的角，然后旋转 ,rotate是顺时针旋转的，所以加个负号
                    var ang = (end[0] - sta[0]) / (end[1] - sta[1]);
                    ang = Math.atan(ang);
                    if (end[1] - sta[1] >= 0) {
                        ctx.rotate(-ang);
                    } else {
                        ctx.rotate(Math.PI - ang);//加个180度，反过来
                    }
                    var arrowSize = 0.6 * ratio;
                    ctx.lineTo(-5 * arrowSize, -10 * arrowSize);
                    ctx.lineTo(0, -5 * arrowSize);
                    ctx.lineTo(5 * arrowSize, -10 * arrowSize);
                    ctx.lineTo(0, 0);
                    ctx.fill(); //箭头是个封闭图形
                    ctx.restore();   //恢复到堆的上一个状态，其实这里没什么用。
                    ctx.closePath();
                }

                function paintLine(lineWidth, strokeStyle) {
                    ctx.beginPath();
                    //绘制曲线
                    ctx.lineWidth = calLineWidth(lineWidth);
                    ctx.strokeStyle = strokeStyle;
                    var isStart = false;
                    for (var i = 0; i < heartRate.length; i++) {
                        //计算当前点
                        var point = heartRate[i];
                        //计算心跳值的绝对值>20
                        var pointDiffer = 0;
                        if (i > 0) {
                            pointDiffer = Math.abs(heartRate[i - 1] - point);
                        }
                        if (point > 40 && point <= 220) {
                            if (isStart && pointDiffer < 20) {
                                ctx.lineTo(calXValue(i), calYValue(point));
                            } else {
                                ctx.moveTo(calXValue(i), calYValue(point));
                            }
                            isStart = true
                        }
                        else {
                            isStart = false
                        }
                    }
                    ctx.stroke();
                    ctx.closePath();
                }
            },
            /**
             * 基于bootstrap编写的模态提示框
             * 默认:中； 加大: modal-lg；  最小: modal-sm
             */
            dialog: function (options) {
                options = $.extend(
                    {
                        type: "confirm",
                        title: "友情提示",
                        content: "您确定吗？",
                        cancelCallBack: function () {
                        },
                        sureCallBack: function () {
                        },
                        showAnimate: true,
                        size: "",
                        backdrop: true,
                        sureText: "确定"
                    }, $.isPlainObject(options) ? options : {});

                var type = options.type;//类型 alert  confirm success failed
                var title = options.title;//标题
                var content = options.content;//提示内容

                var cancelCallBack = options.cancelCallBack;//关闭按钮，X点击回调
                var sureCallBack = options.sureCallBack;//确认按钮回调

                var showAnimate = options.showAnimate;//是否显示动画效果
                var size = options.size;

                var backdrop = options.backdrop;
                var sureText = options.sureText;
                if (type == "success") {
                    content = '<div style="text-align: center">' +
                        '<span class="glyphicon glyphicon-ok" style="color:green;font-size:40px;"></span>' +
                        '</div>' +
                        '   <div style="text-align: center">' + content + '</div>';

                    type = "alert";
                } else if (type == "failed") {
                    content = '<div style="text-align: center">' +
                        '<span class="glyphicon glyphicon-remove" style="color:red;font-size:40px;"></span>' +
                        '</div>' +
                        '<div style="text-align: center">' + content + '</div>';

                    type = "alert";
                }

                var fade = showAnimate ? "fade" : "";
                //  var wModalId = "wModal"+($(".wModal").length+1);

                var overlayDiv = $('<div class="modal wModal ' + fade + ' " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
                    + '<div class="modal-dialog ' + size + '">'
                    + '<div class="modal-content">'
                    + '<div class="modal-header">'
                    + '<button type="button" class="close wCancle" ><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>'
                    + '<h4 class="modal-title" id="wModalLabel">' + title + '</h4>'
                    + '</div>'
                    + '<div class="modal-body">'
                    + content
                    + '</div>'
                    + '<div class="modal-footer">'
                    + '<button type="button" class="btn btn-default pull-left wCancle" >关闭</button>'
                    + '<button type="button" class="btn btn-primary wSure" >' + sureText + '</button>'
                    + '</div>'
                    + '</div>'
                    + '</div>'
                    + '</div>').appendTo("body");
                //$("body").append(modalHtml);

                var sure = overlayDiv.find(".wSure");
                var wCancle = overlayDiv.find(".wCancle");

                if (type == "alert") {
                    sure.hide();
                } else if (type == "confirm") {
                    sure.show();
                }

                overlayDiv.on('hidden.bs.modal', function (e) {
                    overlayDiv.remove();
                });

                if (options.shown) {
                    overlayDiv.on('shown.bs.modal', options.shown);
                }

                //初始化modal
                overlayDiv.modal({
                    keyboard: true,
                    backdrop: backdrop
                });


                //绑定事件
                sure.click(function () {
                    var close = false;
                    if (sureCallBack) {
                        // 返回true，不关闭窗口，返回false或不返回值，关闭窗口
                        close = sureCallBack();
                    }
                    if (!close) {
                        overlayDiv.modal('hide');
                    }
                });

                var cancelFun = function () {
                    var close = false;
                    if (cancelCallBack) {
                        close = cancelCallBack();
                    }
                    if (!close) {
                        overlayDiv.modal('hide');
                    }
                };
                wCancle.click(cancelFun);
                return {
                    overlay: overlayDiv,
                    body: overlayDiv.find('.modal-body'),
                    dialog: overlayDiv.find('.modal-dialog'),
                    close: cancelFun
                };
            },
            ajaxError: function (e, r, s) {
                Messenger.options = {
                    extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-center',
                    theme: 'flat',
                    maxMessages: 6
                };
                if ((r != null ? r.status : void 0) === 404) {
                    Messenger().post({
                        message: '请求不能找到：' + s.url,
                        type: 'error',
                        showCloseButton: true
                    });
                } else {
                    Messenger().post({
                        message: '请求错误：' + s.url,
                        type: 'error',
                        showCloseButton: true
                    });
                }
            }
        };


    $.fn.extend({
        vaild: m.vaild, startLoading: m.startLoading,
        stopLoading: m.stopLoading, baseTable: m.baseTable, heartRateGrid: m.heartRateGrid
    });

    $.extend({
        dialog: m.dialog, alert: m.alert
    });

    $.mini = {
        ajaxGet: m.ajaxGet
    };
}(jQuery));
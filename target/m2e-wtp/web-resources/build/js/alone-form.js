/**
 * 兼容js
 */
;(function ($) {
    $("form").submit(function(){
        //ajax 请求
        //buttons.find("button").attr("disabled", "disabled");
        var form = $(this);
        form.startLoading();
        $.ajax({
            cache: false,
            dataType: "json",
            type: form.attr("method"),
            url: form.attr("action"),
            data: form.serialize(),
            error: function(request) {
                form.stopLoading();
                $.alert(request);
            },
            success: function(data) {
                form.stopLoading();
                if(data.status == 1){
                    form.vaild(data.msgMap);
                } else if(data.status == 0){
                    $.alert("成功！");
                } else{
                    $.alert(data.msg);
                }
            }
        });
        return false;
    });
}(jQuery));





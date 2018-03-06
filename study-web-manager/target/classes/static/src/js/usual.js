//全局路径
var contextPath = $("#contextPath").val();
$(function () {
    flushResult();
    $('.data-maintenance').on('click', function () {
        layer.open({
            type: 1,
            title: '文件上传',
            area: ['566px', '220px'],
            content: $('.file-upload'),
            btn: ['提交文件', '取消'],
            yes: function (index) {
                var msg = layer.msg('努力保存中', {icon: 16, shade: [0.5, '#f5f5f5'], time: 120000});
                var form = new FormData(document.getElementById("myForm"));
                $.ajax({
                    url: contextPath + '/systemmanager/workdate/submitfile.json',
                    type: 'post',
                    data: form,
                    // 告诉jQuery不要去处理发送的数据
                    processData: false,
                    // 告诉jQuery不要去设置Content-Type请求头
                    contentType: false,
                    success: function (result) {
                        layer.close(msg);
                        layer.close(index);
                        if (result.success) {
                            layer.open({
                                type: 1,
                                title: '文件上传进度提示',
                                area: ['450px', '400px'], //宽高
                                content: $('.wlk-bottom'),
                                btn: ['刷新', '取消'],
                                yes: function (index) {
                                    showResult(result.result);
                                },
                                btn2: function (index) {
                                    layer.close(index);
                                }
                            });
                            showResult(result.result);
                        } else {
                            layer.msg(result.message);
                        }
                    },
                    error: function () {
                        layer.close(index);
                        layer.alert("保存异常");
                    }
                });
            },
            btn2: function (index) {
                layer.close(index);
            }
        })
    });
});
function flushResult() {
    $.post(contextPath + '/systemmanager/getdate.json', {
        isWork: 'N'
    }, function (result) {
        if (result['success']) {
            var data = result['result'];
            $('#calendar').calendar({
                renderDay: function (e) {
                    for (var i = 0; i < data.length; i++) {
                        if (data[i].transDate.length >= 8) {
                            var year = data[i].transDate.substring(0, 4);
                            var month = data[i].transDate.substring(4, 6);
                            var date = data[i].transDate.substring(6, 8);
                            var circleDateTime = new Date(year + '/' + month + '/' + date).getTime();
                            if (e.date.getTime() == circleDateTime) {
                                $(e.element).css('background-color', '#3797d9');
                                $(e.element).css('color', 'white');
                                $(e.element).css('border-radius', '15px');
                                break;
                            }else{
                                $(e.element).removeAttr("style");
                            }
                        }
                    }
                }
            });
        }
    });
}


function showResult(impProcLogId) {
    if (impProcLogId == "" || impProcLogId == null) {
        document.getElementById("p").innerHTML = "导入的文件格式不对或不能为空";
    } else if (impProcLogId != null && impProcLogId != '') {
        $.post(contextPath + '/channelmanager/impProcLog_view.json', {
            'impProcLogId': impProcLogId
        }, function (result) {

            var impProcLogVo = result.result;
            var html = impProcLogVo.restBrief + "<br>" + impProcLogVo.restDtl;
            document.getElementById("p").innerHTML = "";
            document.getElementById("p").insertAdjacentHTML("afterBegin", html);
            if (impProcLogVo.restBrief != '读取完成') {
                showResult(impProcLogId);
            } else {
                flushResult();
            }
        })
    }
}
$(function() {
    $("#indexForm").on('submit', function() {
        $(this).ajaxSubmit({
            type: 'post', // 提交方式 get/post
            dataType: 'json',
            url: "", // 需要提交的 url
            success: function(data) { // data 保存提交后返回的数据，一般为 json 数据


            },
            error:function(data){

            }

        });

        return false; // 阻止表单自动提交事件，必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
    });
});
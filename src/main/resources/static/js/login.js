$(function () {

    $("input[name='LoginButton']").click(function () {
        var username= $("#username").val();
        var pwd=$("#password").val();
        var quser=new Object();
        quser.username=username;
        quser.password=pwd;
        sendData(JSON.stringify(quser));
    });

});

//发送请求
/**
 * jquery发送请求
 * */
function sendData(datas){
    $(function(){
        //加载网络数据
        $.ajax({
            type:"post",
            url:"http://localhost:8080/login/submit",
            data:{"quser":datas},
            async:true,
            dataType:"json",
            success:function(data){

               var code= data.resultCode;
               if(code>0){//登录成功
                   window.location.href="http://localhost:8080/back/home";
               }else{
                   //登录失败
                   $("#_warn").text(data.msg);
               }
                //页面的跳转
                // window.location.href="http://localhost:8080/findallques";
            }
        });
    })
}

$(function(){
    $("#nav-items-recycling").css("backgroundColor","#1f5c99");
    $("#nav-items-recycling").click(function(){

        $("#nav-items-analysis").css("backgroundColor","#0e2b47");
        $("#nav-items-recycling").css("backgroundColor","#1f5c99");
    });
    $("#nav-items-analysis").click(function(){
        /*background: #1f5c99;
   color: #fff;*/
        $("#nav-items-analysis").css("backgroundColor","#1f5c99");
        $("#nav-items-recycling").css("backgroundColor","#0e2b47");
    });




})
/**点击下拉列表*/
$(function(){
    $("select._select").change(function () {

       var _qinfo="http://gsmzzk.com:8080/front/generate/"+$(this).val()
       var _selectedIndex=$(this).get(0).selectedIndex;

       $("._select option").attr("selected",false);
        $("._select option").eq(_selectedIndex).attr("selected",true);
         $( document.getElementById("external-frame").contentWindow.document.getElementsByClassName("_link")[0]).val(_qinfo);

         $( document.getElementById("external-frame").contentWindow.document.getElementById("qrcode")).html("");
         $( document.getElementById("external-frame").contentWindow.document.getElementById("qrcode")).qrcode(
             {width: 140,height: 140,correctLevel:0,text: _qinfo}
         );
    });
})


function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
            iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
        }
    }
};

window.onload = function () {
    setIframeHeight(document.getElementById('external-frame'));
};

/**
 * 下载excel
 * */
function _download(){


   //获取到qno
    var _qno=$("select._select option[selected='selected']").val();

    window.location.href="http://localhost:8080/back/"+_qno+"/download";
}

function sendData(_qno){
    $(function(){
        //加载网络数据
        $.ajax({
            type:"post",
            url:_qno+"/download",

            async:true,
            dataType:"json",
            success:function(data){
                console.log(data);
                //页面的跳转
               // window.location.href="findallques";
                window.location.href="http://localhost:8080/back/1527812674200/download";
            }
        });
    })
}

/*jQuery(function(){
    jQuery('#qrcode').qrcode(
        {width: 140,height: 140,correctLevel:0,text: "http://10.25.129.133:8080/front/generate/1526287253889"}
    );
})*/

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
         /*alert($(this).val()+$(this).text());*/

       var _qinfo="http://localhost:8080/front/generate/"+$(this).val()
       $( document.getElementById("external-frame").contentWindow.document.getElementsByClassName("_link")[0]).val(_qinfo);

        $( document.getElementById("external-frame").contentWindow.document.getElementById("qrcode")).html("");
        $( document.getElementById("external-frame").contentWindow.document.getElementById("qrcode")).qrcode(
            {width: 140,height: 140,correctLevel:0,text: _qinfo}
        );
        /* jQuery('#qrcode').qrcode(
            {width: 140,height: 140,correctLevel:0,text: "http://localhost:8080/front/generate/"+$(this).val()}
        );*/


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

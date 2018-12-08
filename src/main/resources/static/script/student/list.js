var student_base_url = "/api/student";

var localUrl = "http://localhost:1111";
//var localUrl = getCookie("localUrl");
//获取图片路径
var student_photo_url = student_base_url + "/beijing/photo";
var param = {};
var data = common.ajax(student_photo_url,param);

if (data) {
    data = data.data;
    var html = '';
    $.each(data, function (i, item) {
        if ((i + 1) % 10 == 0){
            html += '<p><img src=\"' + localUrl + data[i].realPath + '" width="120" height="160"/></p>';
        } else {
            html += '<img src=\"' + localUrl + data[i].realPath + '" width="120" height="160"/> &nbsp;&nbsp;&nbsp;&nbsp;';
        }
    });

    $("#data_photo").html(html);
}
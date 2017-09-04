<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title></title>
</head>
<body>
<script type="text/javascript">
    window.onload = function () {
        var path = "http://service.jh.kingyon.com/";
        var state = ${state};

        //预约保养
        if (state == 1) {
            path = path + "index/html/yuyue/index.html";
        }
        //优惠券
        else if (state == 2) {
            path = path + "index/html/center/youhui.html";
        }
        //我的订单
        else if (state == 3) {
            path = path + "index/html/order/myorder.html";
        }
        //我的车辆
        else if (state == 4) {
            path = path + "index/html/car/mycar.html";
        }
        //个人信息
        else if (state == 5) {
            path = path + "index/html/center/personal.html";
        }
        //打开二维码扫描
        else if (state == 6) {
            path = path + "index/html/scan/scanQRcode.html";
        }
        var token = "${token}";
        location.href = path + "?token=" + token;
    }
</script>
</body>
</html>
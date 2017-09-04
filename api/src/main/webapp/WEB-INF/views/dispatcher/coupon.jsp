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
<!--优惠券领取跳转页面-->
<script type="text/javascript">
    window.onload = function () {
        var path = "http://service.jh.kingyon.com:8080/index/html/scan/scanQRcode.html"
        var state = "${state}";

        var token = "${token}";
        location.href = path + "?token=" + token + "&code=" + state;
    }

</script>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="/">
    <meta charset="utf-8">
    <title>test</title>
    <script>
        less = {
            env: "development",
            async: false,
            fileAsync: false,
            poll: 1000,
            functions: {},
            dumpLineNumbers: "comments",
            relativeUrls: false,
            autoprefix:"browsers",
            rootpath: ":/a.com/"
        };
    </script>
    <link rel="stylesheet/less" type="text/css" href="less/test.less"/>
    <script src="lib/js/less-1.7.1.js" type="text/javascript"></script>
</head>
<body>
<div class="test-cls">侧哈哈</div>
</body>
</html>
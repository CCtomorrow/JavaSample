#### HMAC_SHA1加密

后端接kong网关，要求客户端在请求的时候加上一些请求头

必要的:
```
Date:Wed, 07 Mar 2018 13:58:48 GMT
Authorization:hmac username="test",algorithm="hmac-sha1",headers="date request-line",signature="axQeFPPQOMncsMKfxY4BhaAETrs="
```


signature生成规则:
```$xslt
// date: date\n method url httpVersion
date: Wed, 07 Mar 2018 10:34:51 GMT\nPOST /auth/sms/code HTTP/1.1
```

对上面的数据先hamc_sha1加密然后base64.

下面提供直接生成最终`Authorization`字符串的实现.
```
String user = "test";
String method = "GET";
String url = "/api/list";
String httpVersion = "HTTP/1.1";
String secret = "70e8f08ce07490d05d1252a17b1aa335";
String date = Hmac.getDateGMTString();
String auth = Hmac.getAuthHeaderStr(user, method, url, httpVersion, secret, date);
```
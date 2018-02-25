<h3>Aplikasi Spring Boot OAuth2 Demo</h3>
<hr/>
Aplikasi Terdiri dari :
<ul>
<li>1. demo-integrated-angular</li>
<li>2. Spring-Cloud-OAuth2-SSO</li>
</ul>
<br/>

# A1. demo-integrated-angular : Dependencies
 
<ul>
<li>Web</li>
<li>JPA (Java Persistence Api)</li>
<li>MySQL DB</li>
<li>Spring-security-Oauth2</li>
<li>Spring-boot-starter-security</li>
</ul>

# A2. Spring Cloud OAuth2 SSO : Run File

```

$ mvn clean spring-boot:run
```

<br/>
cara mendapatkan token
*NOTE*
client : clientGojekApp
secret : mysecret
client dan secret di ambil dari database 
<br/>


```

$ curl -X POST -vu clientGojekApp:mysecret 'http://localhost:10000/oauth/token?username=dickanirwansyah&password=rootroot&grant_type=password'
```

<br/>
mendapatkan token
<br/>


```
* Hostname was NOT found in DNS cache
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 10000 (#0)
* Server auth using Basic with user 'clientGojekApp'
> POST /oauth/token?username=dickanirwansyah&password=rootroot&grant_type=password HTTP/1.1
> Authorization: Basic Y2xpZW50R29qZWtBcHA6bXlzZWNyZXQ=
> User-Agent: curl/7.35.0
> Host: localhost:10000
> Accept: */*
> 
< HTTP/1.1 200 
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Cache-Control: no-store
< Pragma: no-cache
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 25 Feb 2018 01:49:26 GMT
< 
* Connection #0 to host localhost left intact
{"access_token":"bdbaddb6-56a8-45fc-9c9c-21df9eb5e30a","token_type":"bearer","refresh_token":"7dbf98ec-2977-4a64-995d-cf0305061c2e","expires_in":34828,"scope":"read write"}
```

<br/>
Mendapatkan Token baru Refresh Token
*Note*
ambil refresh token dari token yang di atas
<br/>


```
$ curl -X POST -vu clientGojekApp:mysecret 'http://localhost:10000/oauth/token?grant_type=refresh_token&refresh_token=7dbf98ec-2977-4a64-995d-cf0305061c2e'
```


<br/>
Dapat Token Baru dari refresh token
<br/>


```

* Hostname was NOT found in DNS cache
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 10000 (#0)
* Server auth using Basic with user 'clientGojekApp'
> POST /oauth/token?grant_type=refresh_token&refresh_token=7dbf98ec-2977-4a64-995d-cf0305061c2e HTTP/1.1
> Authorization: Basic Y2xpZW50R29qZWtBcHA6bXlzZWNyZXQ=
> User-Agent: curl/7.35.0
> Host: localhost:10000
> Accept: */*
> 
< HTTP/1.1 200 
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Cache-Control: no-store
< Pragma: no-cache
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 25 Feb 2018 01:59:32 GMT
< 
* Connection #0 to host localhost left intact
{"access_token":"ed7e8c30-8320-4f55-bea2-0f68f581129f","token_type":"bearer","refresh_token":"7dbf98ec-2977-4a64-995d-cf0305061c2e","expires_in":35999,"scope":"read write"}
```

<br/>
Access ke restcontroller menggunakan access_token yang baru
<br/>

```

$ curl -i -H 'Authorization: Bearer ed7e8c30-8320-4f55-bea2-0f68f581129f' http://localhost:10000/api/category/secure/list
```


<br/>
Response jika berhasil
<br/>


```

HTTP/1.1 200 
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sun, 25 Feb 2018 02:03:35 GMT

[{"idcategory":1,"name":"chocolate ","description":"chocolate ice cream","valid":true}]
```


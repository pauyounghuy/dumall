登录：localhost:8092/login
````json
请求：{"username":"byh","password":"123","ip": "123.1.2.3"}
响应：
````
注册：localhost:8092/register
````json
请求：{"username":"byh","password":"123","pwd":"123","name":"zxc","mobile":"123456","qq":"123","email":"qq@123.com"}
响应：
````
退出：localhost:8092/logout
````json
请求：{"username":"byh"}
响应：
````
获取用户信息：localhost:8092/user/getUserInfo
````json
{"userKey":"1"}
````
修改用户信息：localhost:8092/user/update
````json
请求：{"id":"1","username":"byh","password":"123","name":"zxc","mobile":"123456","qq":"123","email":"qq@123.com"}
响应：
````
根据用户主键获取地址：localhost:8092/address/get
````json
请求：{"userKey":"1"}
响应：
````
获取多条件地址分页：localhost:8092/address/getByPageCondition
````json
请求：{"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"pageSize": 10}
响应：
````
新增用户地址：localhost:8092/address/add
````json
请求：{"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"postcode": "12345","telephone": "123","isDefault":"1"}
响应：
````
修改用户地址：localhost:8092/address/update
````json
    请求：{"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"postcode": "12345","telephone": "123","isDefault":"1"}
    响应：
````
删除用户地址：localhost:8092/address/delete
````json
   请求： {"id":"1"}
   响应：
````
修改地址默认状态：localhost:8092/address/get/updateStatus
````json
    请求：{"userKey":"2","id":"1"}
    响应：
````
获取多条件商品分页：localhost:8092/goods/getByPageCondition
````json
    请求：{"name":"byh","pageNum": 1,"pageSize": 10}
    响应：
````

记录游客访问：localhost:8092/visitor/record
````json
    请求：{"ip":"123.123.1.1"}
    响应：
````


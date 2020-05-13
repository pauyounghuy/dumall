登录：localhost:8092/login
````json
{"username":"byh","password":"123","ip": "123.1.2.3"}
````
注册：localhost:8092/register
````json
{"username":"byh","password":"123","pwd":"123","name":"zxc","mobile":"123456","qq":"123","email":"qq@123.com"}
````
退出：localhost:8092/logout
````json
{"username":"byh"}
````
获取用户信息：localhost:8092/user/getUserInfo
````json
{"userKey":"1"}
````
修改用户信息：localhost:8092/user/update
````json
{"id":"1","username":"byh","password":"123","name":"zxc","mobile":"123456","qq":"123","email":"qq@123.com"}
````
根据用户主键获取地址：localhost:8092/address/get
````json
{"userKey":"1"}
````
获取多条件地址分页：localhost:8092/address/getByPageCondition
````json
    {"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"pageSize": 10}
````
新增用户地址：localhost:8092/address/add
````json
    {"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"postcode": "12345","telephone": "123","isDefault":"1"}
````
修改用户地址：localhost:8092/address/update
````json
    {"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"postcode": "12345","telephone": "123","isDefault":"1"}
````
删除用户地址：localhost:8092/address/delete
````json
    {"id":"1"}
````
修改地址默认状态：localhost:8092/address/get/updateStatus
````json
    {"userKey":"2","id":"1"}
````
获取多条件商品分页：localhost:8092/goods/getByPageCondition
````json
    {"name":"byh","pageNum": 1,"pageSize": 10}
````

记录游客访问：localhost:8092/visitor/record
````json
    {"ip":"123.123.1.1"}
````


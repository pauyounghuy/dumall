##### 1.登录：localhost:8092/login
````json
请求：{"username":"byh","password":"123","code":"123"}
响应：
````
##### 2.注册：localhost:8092/register
````json
请求：{"username":"byh","password":"123","pwd":"123","name":"zxc","mobile":"123456","qq":"123","email":"qq@123.com"}
响应：
````
##### 3.退出：localhost:8092/logout
````json
请求：{"username":"byh"}
响应：
````
##### 4.获取用户信息：localhost:8092/user/getUserInfo
````json
{"userKey":"1"}
````
##### 5.修改用户信息：localhost:8092/user/update
````json
请求：{"id":"1","username":"byh","password":"123","name":"zxc","mobile":"123456","qq":"123","email":"qq@123.com"}
响应：
````
##### 6.根据用户主键获取地址：localhost:8092/address/get
````json
请求：{"userKey":"1"}
响应：
````
##### 7.获取多条件地址分页：localhost:8092/address/getByPageCondition
````json
请求：{"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"pageSize": 10}
响应：
````
##### 8.新增用户地址：localhost:8092/address/add
````json
请求：{"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"postcode": "12345","telephone": "123","isDefault":"1"}
响应：
````
##### 9.修改用户地址：localhost:8092/address/update
````json
    请求：{"userKey":"1","name":"byh","streetName":"xxx","pageNum": 1,"postcode": "12345","telephone": "123","isDefault":"1"}
    响应：
````
##### 10.删除用户地址：localhost:8092/address/delete
````json
   请求： {"id":"1"}
   响应：
````
##### 11.修改地址默认状态：localhost:8092/address/get/updateStatus
````json
    请求：{"userKey":"2","id":"1"}
    响应：
````
##### 12.获取多条件商品分页：localhost:8092/goods/getByPageCondition
````json
    请求：{"name":"byh","pageNum": 1,"pageSize": 10}
    响应：
````

##### 13.记录游客访问：localhost:8092/visitor/record
````json
    请求：{"ip":"123.123.1.1"}
    响应：
````

##### 14.获取多条件订单分页：localhost:8092/order/getOrderByCondition
````json
    请求：{"status":"1","pageNum": 1,"pageSize": 10}
    响应：
````
##### 15.显示验证码图片：localhost:8092/code/get
````json
    请求：无需传参
    响应：
````
##### 16.发送邮件确认：localhost:8092/user/sendEmail
````json
    请求：{"userKey":"123"}
    响应：
````
##### 17.验证邮箱：localhost:8092/user/verifyEmail
````json
    请求：{"userKey":"123","code":"qwe213q"}
    响应：
````




````text
    @Description: 自定义响应数据结构
    这个类是提供给门户，ios，安卓，微信商城用的
    门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
    其他自行处理
    200：表示成功
    500：表示错误，错误信息在msg字段中
    501：bean验证错误，不管多少个错误都以map形式返回
    502：拦截器拦截到用户token出错
    555：异常抛出信息 
    
````
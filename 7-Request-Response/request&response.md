### Request & Response
  1. 客户端-服务器请求数据的流程简述
  2. Response
  3. Request
  4. 编码
  5. 路径

---

#### 1.请求响应流程
  - 服务器每次接收到请求时，都会为这个请求开辟一个新的线程。
  - 服务器会把客户端发送的请求都封装到request对象中，request就作为了请求的载体
  - 服务器还会创建response对象，这个对象与客户端连接在一起，可以用来向客户端发送响应

---

#### 2.Response
  - 其具体类型为HttpServletResponse
    - `ServletResponse`为与协议无关类型
    - `HttpServletResponse`为与Http协议相关类型
  - 响应的包含的内容
    1. 状态码
        - 200：表示成功
        - 302：表示重定向
        - 404：访问资源不存在
        - 500：服务器内部错误
        - 方法：
            - `sendError(int code)`：发送错误状态码
            - `sendError(int code,String msg)`：发送错误状态码+错误描述
            - `sendStatus(int code)`：发送成功的状态码
    2. 响应头
    3. 响应体
    4.
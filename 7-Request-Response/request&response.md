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
  - 使用具体类型为HttpServletResponse
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
        - 例如Content-Type、Content-Length、Refresh、Location等..
        - 方法：
            - `setHeader(String name,String value)`：单值响应头
            - `addHeader(String name,String value)`：多值响应头
            - `setIntHeader(String name,int value)`：单值int类型的响应头
            - `addIntHeader(String name,int value)`：多值int类型的响应头
            - `setDateHeader(String name,long value)`：单值毫秒响应头
            - `addDateHeader(String name,long value)`：多值毫秒响应头
        - 案例：
            - 重定向：设置`Location` - `URL`键值对响应头，`setStatus(302)`完成重定向
            - 定时刷新：设置`Refresh`-`时间:URL="地址"`键值对响应头，完成自动刷新
            - 浏览器缓存：设置`Cache-Control`,`pragma`,`expires`头
            - `<meta>`标签可以代替响应头
    3. 响应体
        - 通常是如html的文本，也可以是图片
        - response有两个流：
            - `ServletOutputStream`：通过`getOutputStream()`获取，用来向客户端发送字节数据
            - `PrintWrite`：通过`getPrintWriter()`获取，用来向客户端发送字符数据，通常需要设置字符编码
            - 上述两个流不能一起使用，否则会抛出`IllegalStateException`异常
        - 重定向方法：
            - `sendRedirect(String location)`：

---

#### 3.Request
* 由请求行、请求头、空行、请求体(Get请求没有请求体)
* 获取常用信息：
    1. 获取客户端IP地址：`getRemoteAddr()`
    2. 获取请求方式：`getMethod()`
* 获取HTTP请求头：
    1. `String getHeader(String name)` 获取单值请求头
    2. `int getIntHeader(String name)` 获取单值int类型请求头
    3. `long getLongHeader(String name)` 获取单值毫秒请求头
    4. `Enumeration<String> getHeaders(String name)` 返回多值请求头
* 获取请求URL：
    1. `getSchema()`：获取协议
    2. `getServletName()`：获取服务器名
    3. `getServletPort()`：获取端口号
    4. `getContextPath()`：获取项目名
    5. `getQueryString()`：获取参数部分，既问号后面的部分
    6. `getRequestURI()`：获取请求URI，既项目名+Servlet路径
    7. `getRequestURL()`：获取请求URL，既不包含参数的请求路径

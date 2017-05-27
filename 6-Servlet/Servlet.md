#### 1. 什么是Servlet
* Servlet是 JavaWeb三大组件之一，是一种动态资源。用于在服务器端接收和响应浏览器的请求。
    - 接收请求数据
    - 处理请求
    - 完成响应

---

#### 2. 实现Servlet的方式
* 实现Servlet有三种方式
    - 实现javax.servlet.Servlet接口
    - 继承javax.servlet.GenericServlet类
    - 继承javax.servlet.http.HttpServlet类
* Servlet接口
    - 此接口中有5个方法，是其余两个类的父接口
    - Servlet中的方法大多数不由自己调用，而是由Tomcat调用；而且Servlet对象也是由Tomcat创建的
* Servlet的生命周期
    - `init`：在Servlet创建之后马上执行，只调用一次
    - `service`：会被调用多次，用于每次处理请求
    - `destroy`：在Servlet被销毁之前调用，也只会执行一次
    
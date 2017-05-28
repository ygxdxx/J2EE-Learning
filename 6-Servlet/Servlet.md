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
* Servlet的特点
    - 一个Servlet类只存在一个单例，但是可以存在多个Servlet类，线程不安全
* Servlet接口
    - 此接口中有5个方法，是其余两个类的父接口
    - Servlet中的方法大多数不由自己调用，而是由Tomcat调用；而且Servlet对象也是由Tomcat创建的
* Servlet的生命周期
    - `init(ServletConfig)`：在Servlet创建之后马上执行，只调用一次
    - `service`：会被调用多次，用于每次处理请求
    - `destroy`：在Servlet被销毁之前调用，也只会执行一次
* ServletConfig的方法介绍
    - `getServletContext()`：获取Servlet上下文
    - `getInitParameter()`：获取初始化参数
    - `getInitParameterNames()`：获取初始化参数名称

---

#### 3. 继承GenericServlet类方式
* 此类是Servlet的子类，是一个抽象类。需要了解GenericServlet与Servlet的继承关系。重写`init()`方法...

#### 4. 继承HttpServlet类方式
* 此类是GenericServlet类的子类，是一个抽象类。会把`service(...)`方法中的`Request`和`Response`参数转换为`HttpRequest`和`HttpResponse`(父子接口关系)，根据`request`参数中的请求方式(get、post、put..)来调用相应的`doGet()`、`doPut()`...方法。
* 如果没有重写`doGet()`，`doPost()`..等方法则会报出405异常。
---
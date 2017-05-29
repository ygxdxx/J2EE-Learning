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

---

#### 4. 继承HttpServlet类方式
* 此类是GenericServlet类的子类，是一个抽象类。会把`service(...)`方法中的`Request`和`Response`参数转换为`HttpRequest`和`HttpResponse`(父子接口关系)，根据`request`参数中的请求方式(get、post、put..)来调用相应的`doGet()`、`doPut()`...方法。
* 如果没有重写`doGet()`，`doPost()`..等方法则会报出405异常。

---

#### 5. Servlet的一些补充细节
* 数据安全问题：Servlet不是线程安全，操作的数据最好是无状态的，或者是只提供访问不提供修改
* 服务器启动同时创建Servlet：`<Servlet>`中设置`<load-on-start>0</load-on-start>`
* 多个路径匹配同一个Servlet：
    - `<Servlet-mapping>`中的`<url-pattern>`可以同时存在多个
    - 通配符匹配
        1. `/path/*`：路径匹配
        2. `*.do`：后缀名匹配
        3. `/*`：匹配所有url

---

#### 6. Servlet的反射调用

---

#### 7. ServletContext相关
* 简介：一个项目只有ServletContext对象
    - ServletContext对象的创建是在服务器启动时完成的
    - ServletContext对象的销毁在服务器关闭时完成的
* ServletContext的作用
    - 可以把项目中的多个Servlet关联在一起，某个Servlet可以向ServletContext中保存一个数据，另一个Servlet则可以在Context中读取这个内容。降低了多个Servlet间的关联性
* ServletContext的获取
    1. 在`init()`方法中，通过`ServletConfig`类的`getServletContext()`方法进行获取对象
    2. GenericServlet或HttpServlet中提供的`getServletContext()`方法
* ServletContext的**域对象**功能
    - 所有域对象都具有存取数据的功能，内部维护了一个Map集合(键-值对)，用于在多个Servlet之间传递数据
    - ServletContext是JavaWeb四大域对象之一
        1. PageContext
        2. HttpSession
        3. ServletRequest
        4. ServletContext
    - 方法：
        - `void setAttribute(String key,Object value)`：存值，多次存入相同值会覆盖
        - `Object getAttribute(String key)`：通过键获取值
        - `void removeAttribute(String key)`：通过键删除键值对
        - `Enumeration getAttributeNames()`：获取所有域属性的名称
* ServletContext获取**全局应用**初始化参数

      <context-param>
            <param-name>context-param</param-name>
            <param-value>context-value</param-value>
      </context-param>

    - 由上述标签的键-值对设置，然后通过`getInitParameter(String key)`方法来获取对应的值

* 通过ServletContext获取文件真实路径
    - `getRealPath("文件名")`：获取文件在服务器上的真实路径
* 通过ServletContext获取文件资源流
    - `getResourceAsStream("文件名")`：获取对应文件的资源流


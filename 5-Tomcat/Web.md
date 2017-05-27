#### 1. 软件体系结构
* C/S 结构：
    - 即客户端/服务器结构
    - 两端都需要进行编写
    - 安全性比较好
* B/S 结构    
    - 即浏览器/服务器结构
    - 只需要编写服务器端
    - 安全性较差
    
---     
    
#### 2. Web资源
* 静态资源：如HTML页面
* 动态资源：JSP、PHP等，可以对操作进行相应
* 对资源的访问：在浏览器中输入URL  `协议://域名:端口/路径`

---
    
#### 3. Web服务器介绍
* Web服务器用于接收客户端请求，给客户端作出响应
* Web服务器也作为 JSP/Servlet 容器，一般指的是同一个东西
* 常见服务器种类
    - **Tomcat (Apache)**
    - JBoss (RedHat) 提供EJB的访问
    - GlassFish (Oracle)
     
---     

#### 4. Tomcat服务器
* 特点：开源、免费
* Tomcat的安装、启动、配置
    - 安装版只能在电脑中安装一份
    - 解压版可以直接解压到路径中，可以安装多个版本
    - Tomcat的目录结构 /bin /WEB-INF 
    - 启动服务器：startup.sh/.bat ***(OSX需要配置好环境变量)***
    - 关闭服务器：shutdown.sh/.bat
    - **startup.sh -> catalina.sh -> setclasspath.sh -> JAVA_HOME**
    - 访问Tomcat主页 `http://localhost:8080/` 验证是否配置成功
    - catalina.sh 与 startup.sh 区别在于一个在前台运行，一个在后台
    - 在conf下保存的都是配置文件，在server.xml下修改端口号，默认8080
    - webapps用于存放项目
    - WEB-INF下面存放的项目是无法访问的
--- 

#### 5. 通过 IDEA/MyEclipse 创建项目
* IDEA与MyEclipse对于Web应用的创建和访问机制不同，MyEclipse会把Web项目添加到webapps下面，而IDEA不会这样。

---

#### 6. 配置外部应用

---

#### 7. 虚拟主机的配置

---

#### 8. Http协议
* 什么是协议：双方的通信规则
* Http头
* 常用状态码


    

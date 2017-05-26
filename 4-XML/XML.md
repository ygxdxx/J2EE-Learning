#### 1. XML的简介
* eXtensible Markup Language：可拓展性标记语言
    - 标记语言：使用标签进行操作
    - 可拓展性：除了自身提供的标签之外，还允许自定义标签
* XML用途
    - XML可以用来存储数据（主要功能）
    - XML可以用来显示数据，类似HTML
* XML版本
    - W3C发布的标准，从1.0开始，高版本不能向下兼容
---     
#### 2. XML的应用   
* 不同系统间的数据传输
* 用于表示生活中有关系的数据
* 经常用于文件配置
    - 比如数据库的用户名和密码可以配置在XML文件中，在不修改源码的条件下可以，修改XML内数据就可以达到修改效果
---     
#### 3. XML的语法
* XML的文档声明
    - 创建一个文件，后缀名为.xml
    - 开头第一行必须要有一个文档声明
      <br>`<?xml version="1.0" encoding="gbk"?>`
        - version：xml版本
        - encoding：xml编码 gbk utf-8
        - standalone(很少使用)：是否需要依赖其他文件 yes/no
* 定义元素（标签）
    - 标签必须有开始标签和结束标签
    - 标签没有内容，可以在标签内结束
    - 标签如果嵌套必须要合理嵌套
    - 只有一个根标签
    - XML中空格和换行都当做内容进行解析
* 定义属性
    - 可以有多个属性
    - 命名规则与标签一致，不能以数字和下划线开头
    - 属性名称不能相同
* 注释
    - 格式 \<!-- 内容 -->
    - 注释必须放在第一行，不能
* 特殊字符
    - & -> \&amp;
    - \> -> \&gt;
    - < -> \&lt;
    - " -> \&quot;
    - ' -> \&apos;
* CDATA区(了解) 
    - 解决标签中多个字符都需要进行转义的情况，把内容放入CDATA区即可
    <br> `<![CDATA[ 内容 ]]`
* PI指令(了解)
    - 对中文元素不起作用
    - 用于在XML中引入样式
    <br>`<?xml-stylesheet type="text/css" href="文件路径"?>`
--- 
#### 4. XML的约束     
* 为什么需要XML约束？
    - 当一个XML文件只用于描述人的信息的时候，比如name，age等属性。
      但是当标签中定义其他种类标签的时候依然可以正常显示，这个时候就需要约束来进行限制。
* XML的约束种类
    - DTD约束
    - Schema约束
--- 
#### 5.创建DTD约束
* 使用DTD约束
    - 创建一个后缀名为.dtd的文件
    - 步骤：
        1. 观察XML文件中有几个元素，有几个元素就写几个 <!ELEMENT>
        2. 判断每个元素是复杂元素还是简单元素
             * 复杂元素：有子元素的元素
             <br>`<!ELEMENT 元素名 (子元素名1,子元素名2)>`
             * 简单元素：没有子元素
             <br>`<!ELEMENT 元素名 (#PCDATA)>`
        3. 在XML中引入DTD文件     
             `<!DOCTYPE 根元素名称 SYSTEM "DTD文件路径">`
    - 浏览器打开以后只负责校验XML语言，不负责约束    
    - DTD文件的引入方式
        1. 引入外部的dtd文件
        <br>`<!DOCTYPE 根元素名称 SYSTEM "DTD文件路径">`
        2. 使用内部dtd文件
        <br>`<!DOCTYPE 根元素名称 [<!ELEMENT 元素名 (子元素名1,子元素名2)> <!ELEMENT 元素名 (#PCDATA)> ..]>`
        3. 使用外部（例如网络）dtd文件
        <br>`<!DOCTYPE 根元素名称 PUBLIC "DTD名称" "DTD文件url">`
    - 使用DTD来定义元素
        * 语法 `<!ELEMENT 元素名 约束>`
        * 简单元素：没有子元素的元素
          <br>`<!ELEMENT name (#PCDATA)>`
          - (#PCDATA)：字符串类型
          - EMPTY： 元素为空（没有内容）
          - ANY：任意
        * 复杂元素：内部有子元素的元素
          <br>`<!ELEMENT 元素名 (子元素)>`
            - 表示子元素出现的次数
                1. +：表示一次或多次
                2. ？：表示零次或一次
                3. *：表示零次或者多次
            - 多个子元素使用 `,` 隔开：表示元素出现的顺序            
            - 多个子元素使用 `|` 隔开：表示这些子元素只能出现一个
---
#### 6. DTD定义属性
* 语法：`<!ATLIST 元素名称 属性名称 属性类型 属性的约束>`           
    - 属性类型
        1. `CDATA`：字符串
        2. `(值1|值2|值3)`：枚举，多个值中选择一个
        3. `ID`：值只能是字母、下划线开头
    - 属性的约束
        1. `#REQUIRED`：该属性值必须要出现
        2. `#IMPLIED`：该属性值可有可无
        3. `#FIXED`：该属性值为固定值，在后面给出
        4. 直接赋值： 
            - 给了属性约束，则使用约束
            - 没有给属性约束，则使用给定的直接值
---             
#### 7. DTD定义实体
* 语法：`<!ENTITY 实体名称 "实体的值">`
* 使用实体：`&实体名称;`  
* 注意事项：使用实体一般写在内部的DTD中，外部有时不能引用（高版本浏览器）
---
#### 8. XML的解析
1. DOM解析技术
    - 根据XML层级结构在内存中分配一个树形结构，把XML标签、属性、文本都封装成对象
    - 如果文件过大，则会造成内存溢出
    - 增删改查操作非常方便
2. SAX解析技术    
    - 采用事件驱动，一边读取一边解析
    - 不能实现增删改操作
    - 哪怕文件过大也不会造成内存溢出
3. XML解析器：不同公司提供了不同的解析器
    - sun公司提供了针对DOM和SAX两种方式的解析器 JAXP
    - dom4j组织针对DOM和SAX提供解析器 dom4j
    - jdom组织针对dom和sax解析器 jdom 
---
#### 9. JAXP的API
* JAXP是JavaSE的一部分
* JAXP解析器在`javax.xml.parsers`内    
    - DOM
        * `DocumentBuilder`：解析器类
            - 这是一个抽象类，不能实例化
            - `使用DocumentBuilderFactory.newDocumentBuilder()`进行获取
            - `parse("xml文件路径)` 返回的是整个Document文档(w3c)  
            - Document是一个接口，其父接口为Node
            - **方法**
                * `getElementsByTagName(String tagName)` 返回NodeList，一个节点集合
                * `createElement(String tagName)` 创建标签
                * `createTextNode()` 创建文本
                * `appendChild(Node newNode)` 把一个节点添加到另一个节点的下面
                * `removeChild(Node oldNode)` 删除节点，由父节点调用
                * `getParentNode()` 得到父节点
                * **NodeList()** 
                    - `getLength()`：得到节点的数量
                    - `item(int index)`：得到具体位置的节点
                    - `getTextContent()`：得到节点内的值            
        * 实现节点的增、删、改、查操 作        
            - ***代码实现***
        * `DocumentBuilderFactory`：解析器工厂   
            - 这是一个抽象类，不能实例化
            - `newInstance()` 获取 `DocumentBuilderFactory `的实例
#### 10. dom4j
* dom4j是一个组织，提供了XML解析器 dom4j
* 添加jar包...
* 得到document
    - `SAXReader reader = new SAXReader();`
    - `Document document = reader.read(url);`
* **Document**方法
    - `getRootElement()` 获取根节点，返回Element
* **Element**方法
    - `getParent()`：获取父节点
    - `addElement()`：添加节点   
    - `elements()`：获取当前元素下的所有子标签
    - `elements(qName)`：获取当前元素下的所有指定子标签
    - `element(qName)`：获取标签下的第一个子标签                                                                     
* ***Document和Element的父接口都是Node***

#### 11. dom4j 增、删、改、查操作
1. 创建解析器
2. 得到document
3. 得到根节点
4. 得到具体节点
5. 回写XML文件
* 创建新的元素 `DocumentHelper.createElement()`
* 对元素添加文本 `Element.setText("...")`

#### 12. 获取document、写回XML文件进行方法封装
* 略...

#### 13. XPath简介
* 通过路径访问的方式获取到XML文件中的元素
* Xpath的写法
    1. `/A/B/C`：表示A节点下面的 B下面的 C节点
    2. `//A`：表示和这个名称相同，表示质只要A，都会得到
    3. `/*`：表示所有元素都得到
    4. `A[1]`：表示第一个A元素
    5. `A[last()]`：表示最后一个A元素
    6. `//A[@id]`：表示只有A元素上有id属性就都获取
    7. `//A[@id='a']`：表示只有A元素上有id属性，且属性值为a则都获取
    8. ...
#### 14. 在dom4j中使用Xpath
* 默认情况下，dom4j本身不支持Xpath，所以需要引入额外的包 `jaxen.jar`
* dom4j使用xpath的两种方式
    1. `selectNodes("xpath..")`：获取多个节点
    2. `selectSingleNode("xpath...")`： 获取单个节点
* 使用Xpath实现对XML的增、删、改、查    
        
    
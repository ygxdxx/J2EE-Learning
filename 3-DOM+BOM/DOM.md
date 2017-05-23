#### 1.JS的DOM对象
* **DOM**：Document Object Model 文档对象模型
    - 文档：HTML XML
    - 对象：提供了属性和方法
    - 模型：使用属性和方法操作超文本标记型文档
* 在操作之前要把HTML里面的所有属性、标签、文本内容都封装撑对象
* **DOM解析过程**
    - 根据HTML的层次结构，在内存中分配一个树形结构，需要把HTML中的每部分都封装成对象
    - document对象：整个文档
    - element对象：标签对象
    - 属性对象
    - 文本对象
    <br>(Node对象是这些对象的父对象，提供一些上述对象不具备的方法)
* **DHTML**：多个技术的综合称呼
    - HTML：用于封装数据，提供网页结构
    - CSS：使用属性和属性值设置样式
    - DOM：操作标记性文档
    - JavaScript：专门指ECMAScript语法
* **document中的方法**
    - `write()`：向网页中输出内容
    - `getElementById()`：通过id获取元素 -> value可以用于取值和赋值
    - `getElementsByName()`：通过name属性值获取元素集合
    - `getElementsByTagName()`：通过tag标签名获取元素集合
* **Element对象中的方法**
    - `getAttribute("属性名")`：获取属性值
    - `setAttribute("属性名","属性值")`：设置属性值
    - `removeAttribute("属性名")`：删除属性 
* **Node中的属性**
    - `nodeType`：节点类型
    - `nodeName`：节点名
    - `nodeValue`：节点值
    - 不同Node对应方式
        * 标签节点
            - 1
            - 大写标签名
            - null
        * 属性节点
            - 2
            - 属性名
            - 属性值
        * 文本节点
            - 3
            - \#text
            - 文本内容
    - `parentNode`：获取父节点 li -> ul
    - `childNodes`：获取子节点 (不同浏览器数量不一致)
    - `firstChild`：获取第一个子节点
    - `lastChild`：获取最后一个子节点
    - `previousSibling`：获取上一个兄弟节点
    - `nextSibling`：获取下一个兄弟节点
* **DOM文档的操作**
    - `appendChild()`：插入子节点，剪切粘贴功能
    - `insertBefore(newNode,oldNode)`：在某个节点之前插入一个新的节点
    - `removeChild(child)`：删除节点，通过父节点删除，返回移除掉的节点
    - `replaceChild(newNode,oldNode)`：替换节点，通过父节点替换
* **innerHTML**
    - 获取标签内容
    - 向标签插入内容，可以是HTML标签
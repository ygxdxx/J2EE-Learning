#### CSS概述
* 什么是CSS：层叠样式表
    - 层叠：多层叠加
    - 样式表：有属性和属性值构成
* CSS的作用：可以让内容和样式进行分离
* HTML和CSS的结合方式
    1. 在标签中写style属性 <div style="background-color:red;color:green">
    2. <style>...</style>写在head中
    3. \<style>@import url(CSS文件路径)</style>
    4. head中引入link标签，<link rel="stylesheet" type="text/css" href="CSS文件路径">
* CSS的选择器
    - 要对哪个标签里面的数据进行操作
        1. 标签选择器
            - 直接使用标签名
        2. class选择器
            - .class名{ ... }
            - 不唯一
        3. id选择器
            - id名{ ... }
            - 唯一
        4. 关联选择器
            - 标签1 标签2 { ... }
        5. 分组选择器
            - 标签1，标签2{ ... }
        6. 伪元素选择器
            - :link {...}
            - :active{...}
            - :hover{...}
            - :visited{...}
        - 选择器优先级：
            id选择器 > class选择器 > 标签选择器
* CSS盒子模型
    1. 边框
        - border：粗细 样式 颜色；
        - border-top
        - border-bottom
        - border-left
        - border-right
    2. 内边距
        - padding:宽度；
        - padding-left:左侧宽度;
        - padding-right:右侧宽度;
        - padding-top:上边宽度;
        - padding-bottom:下边宽度;
    3. 外边距
        - margin:宽度；
        - margin-left:左侧宽度;
        - margin-right:右侧宽度;
        - margin-top:上边宽度;
        - margin-bottom:下边宽度;
* CSS的漂浮
    - float：
        * left 文本流向对象的右边
        * right 文本流向对象的左边
* CSS的定位
    - position
        * static：默认出现在正常流中，不受到too left right...z-index的影响
        * absolute ：会将对象从文档中拖出，使用top left...进行『绝对』定位，相对于第一个非static元素进行定位
        * relative ：不会将对象从文档拖出，使用top left...进行『相对』定位
        * fixed：相对于浏览器窗口定位，生成绝对元素

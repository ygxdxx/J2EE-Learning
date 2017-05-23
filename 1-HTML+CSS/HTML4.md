#### 1.HTML的简介
* 什么是HTML？
    - HyperText Markup Language：超文本标记语言
        * 超文本：超出文本的范畴，并不是文本自身的一些设置
        * 标记：标记就是网页的标签 -> <标签名称>
        * 标记语言
    - 创建一个HTML文件
        * 后缀名为 .html .htm
        * 浏览器直接解释运行
        * 代码都是一系列的标签
    - HTML标签规范
        1. 一个HTML标签拥有开始和结束标签 ` <html></html>`
        2. HTML标签包含两部分
            - ` <head>设置相关</head>`
            - ` <body>内容相关</body>`
        3. HTML标签要有开始标签和关闭标签
        4. 有些标签例如<br/> <hr/>不是成对存在的
        5. HTML标签不区分大小写，最好使用小写
    - HTML的操作思想
        * 每一个标签有点像是一个对象，标签中的属性值就好像对象的属性值修改了标签的样式
---        
#### 2. 常用的HTML标签
* 文字标签：用于设置修改文字的样式
    - ` <font></font>`
    - 属性：
        * size：1-7 逐渐变大
        * color：文字颜色
            - 可以通过颜色单词或者十六进制表示不同颜色
* 注释标签：用于注释掉内容
    - ` <!-- 注释内容 -->`
* 标题标签：用于设置文本标题
    - ` <h1></h1>...<h6></h6>` 逐渐增大，自动追加换行
* 水平线标签
    - ` <hr/>`
    - 属性：
        * size：线的粗细
        * color：线的颜色
* 特殊字符：需要对特殊字符进行转义
    - < ：\&lt;
    - \> ：\&gt;
    - 空格 ：\&nbsp;
    - & ：\&amp;
* 列表标签(3种)
    - 有序列表：
        * 属性：type 设置排序方式 1 a i
    - 无序列表：
        * 属性：type 空心圆circle、实心圆disc、实心方块square
    - 不规则列表：
* 图片标签：用于向网页添加图片
    - ` <img src="图片路径">`
    - 属性：
        * src：指定图片路径
        * width：图片宽度
        * height：图片高度
        * alt：图片加载失败的时候文字说明
    - 路径分类：
        * 绝对路径：全路径
        * 相对路径：一个文件相对另外一个文件的位置
* 超链接标签：
    - 链接资源：跳转到另一个页面
            * ` <a href="资源路径">页面上所显示的内容</a>`
            * 属性：
                * href：资源路径
                * target：页面打开方式
                    * _blank：新标签页打开
                    * _self：当前窗口打开（默认）
        - 定位资源：定一个位置
            * ` <a href="#top">`回到顶部</a>
* 表格标签：格式化资源，生成一个表格
    - ` <table></table>：`代表表格
    - ` <tr></tr>`：代表行
    - ` <td></td>`：代表单元格
    - ` <th></th>`：居住，加粗内容
    - ` <caption></caption>`：表格标题
    - 属性：
        * border：表示表格边框粗细
        * borderColor：表格边框的颜色
        * cellspacing：单元格之间的距离
        * width：表格的宽度
        * height：表格的高度
        * align：设置内容的摆放位置 center left right
        * colspan：` <td colspan="3"></td>` 跨列
        * rowspan：` <td rowspan="3"></td>` 跨行
* 表单标签：可以进行提交
    - \<form></form>：定义一个表单的范围
        * 属性：
            - action：提交的地址，默认提交到当前页面
            - method：提交方式
                * get、post请求两种方式
                    - get：提交的数据在地址栏中出现。携带数据大小有限制；
                    - post：提交的数据不在地址栏中出现，携带在请求体中。携带数据大小相当于没有限制；
                * enctype：文件上传的时候设置此属性
        - \<input type="类型">：输入项
            * 输入项中必须要有name属性，用于指定提交时的键值
            * 类型属性：
                - text：普通输入项
                - password：密码输入项
                - radio：单选输入项
                    * 需要设置name属性，提交时的键，确保多个radio属于一个组
                    * 需要设置value属性，提交时的值
                    * 默认选中状态 checked="checked"
                - checkbox：多选输入项
                    * 需要设置name属性，提交时的键，确保属于一个组
                    * 需要设置value属性，提交时的值
                    * 默认选中状态 checked="checked"
                - file：文件上传
                - submit：提交按钮
                - reset：重置
                - button：按钮 （与js配合）
            * 提交格式：
                - ?输入项name的值=输入项value的值&...&...
                - 键值对 key=value的形式

        - 下拉选择框：
            * 默认选择 selected="selected"
        - 文本域：
            \<textarea cols="列数" rows="行数"></textarea>
* 其他常用标签：
    - b：加粗
    - s：删除线
    - u：下划线
    - i：斜体
    - pre：原样输出
    - sub：下标
    - sup：上标
    - p：段落
    - div和span
* HTML头标签：head中的标签就是头标签
    - title：标签上显示的内容
    - meta：设置页面上的内容，比如优化网页排名
        * 属性：
            - `http-equiv="refresh"` 模拟网页请求
            - `content="时间;url=网页地址"` 固定时间后跳转
    - base：用于设置链接标签的统一打开方式
    - link：引入外部文件 CSS js...
* 框架标签：不能使用` <body>`标签
    - ` <frameset>`
        - rows：按照行进行划分 \<frameset rows="100,*">
        - cols：按照列进行划分 \<frameset cols="100,*">
    - ` <frame>`
        - name：页面名称
        - src：页面路径

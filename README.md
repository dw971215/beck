## 平台简介

源于若依，整合而成

* 前端采用Vue、Element UI。
* 后端采用Spring Boot、Spring Security、Redis & Jwt。
* 权限认证使用Jwt，支持多终端认证系统。
* 支持加载动态权限菜单，多方式轻松权限控制。
* 高效率开发，使用代码生成器可以一键生成前后端代码。
## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

- admin/admin123  


## Admin附加额外功能
1. 会员管理功能模块
2. 会员资产功能模块
3. 会员收货地址功能模块
4. 商品分类功能模块
5. 商品功能模块
6. 商品规格功能模块，包含商品规格类别和规格属性
7. 店铺管理

## Api功能
1. 会员地址信息接口，会员信息接口，店铺信息接口。
2. 钉钉接入获取用户信息
3. 连接串口信息

## WeChat功能
1. 获取微信公众号二维码
2. 微信小程序授权登录 以及H5授权登录。

## 公共类方法
1. 根据List 中对象某一个字段进行排序
2. 邮件发送
3. 文件上传
4. html转义与反转义
5. 请求ip地址获取
6. base64加密、MD5加密
7. 读取yml配置文件的工厂重新 因为springboot默认读取的是properties
8. 通过一个url地址下载文件
8. 关键词替换，评论脏话*号替换
# dmall商城
`dmall` 前后端分离仿电商项目。
本项目技术栈选型的第一要素是—— `潮`。

## 技术栈
- 后端：SpringBoot、MySQL、Redis、Shiro
- 前端：vue、Node.js

## Contact
如有错误欢迎批评指正！
wch853@163.com

## List<TODO>
- [] 基于 `SpringBoot` 全家桶搭建项目后端工程（`Mybatis`、`Redis`、`TestNG`）（[v2.0.1](doc/基于SpringBoot全家桶搭建项目后端工程.md)）
- [x] 集成验证授权框架 `Shiro`，完成用户登录模块功能
- [x] 基于 `vue-element-admin` 搭建管理后台
- [x] 实现产品管理功能（文案编辑、文件上传、ftp配置）
- [x] 实现订单管理功能（后台下单），接入[dubbo](https://github.com/apache/incubator-dubbo)，整合[nacos](https://github.com/alibaba/nacos)。
- [x] 集成[Spring Cloud Alibaba](https://github.com/spring-cloud-incubator/spring-cloud-alibaba)，所有对前端服务接入API网关。
- [x] 实现简单的配置中心（配置远程加载、热发布，类似[Apollo](https://github.com/ctripcorp/apollo)）
- [x] 实现支付功能（目前本猿对支付一无所知）。
- [x] 接入消息队列，对支付回调、库存变更等场景进行解耦。
- [x] 搜索一期：基于[solr](https://github.com/apache/lucene-solr)建立搜索模块。产品信息变更推送搜索（[kafka](https://github.com/apache/kafka)）建立索引，根据关键词搜索呈现相关产品列表。
- [x] 搜索二期：搜索推荐词、二次召回、支持配置词库自定义关键词解析。
- [x] 数据库配置主从、分库分表，集成[cobar](https://github.com/alibaba/cobar)或[MyCat](https://github.com/MyCATApache/Mycat-Server)或[shardingsphere](https://github.com/apache/incubator-shardingsphere)(sharding-jdbc)。
- [x] 搭建 `ELK` 环境，对生产日志进行收集、查询和可视化分析。
- [x] 各模块发布 `docker` 镜像，实现服务容器化。
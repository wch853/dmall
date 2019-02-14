# dmall商城
`dmall` 前后端分离仿电商项目。
本项目技术栈选型的第一要素是—— `潮`。

## 技术栈
- 后端：SpringBoot、MySQL、Redis、Shiro
- 前端：Vue、Node.js

## Contact
如有错误欢迎批评指正！
wch853@163.com

## TODO List
- [x] 基于 `SpringBoot` 全家桶搭建项目后端工程（`Mybatis`、`Redis`、`TestNG`）[v2.0.1](doc/基于SpringBoot全家桶搭建项目后端工程.md)
- [ ] 集成 `spring-cloud-gateway` 实现对前端接口统一网关，基于 `vue-element-admin` 搭建管理后台，完成用户管理功能。
- [ ] 集成 `spring security`、`oauth2` 实现对接口的统一鉴权。
- [ ] 实现产品管理功能（文案编辑、文件上传、ftp配置）
- [ ] 实现订单管理功能（后台下单），接入[dubbo](https://github.com/apache/incubator-dubbo)，整合[nacos](https://github.com/alibaba/nacos)
- [ ] 实现简单的配置中心（配置远程加载、热发布，类似[Apollo](https://github.com/ctripcorp/apollo)）
- [ ] 实现支付功能（目前本猿对支付一无所知）
- [ ] 接入消息队列，对支付回调、库存变更等场景进行解耦
- [ ] 实现分布式事务
- [ ] 搜索一期：基于[solr](https://github.com/apache/lucene-solr)建立搜索模块。产品信息变更推送搜索（[kafka](https://github.com/apache/kafka)）建立索引，根据关键词搜索呈现相关产品列表
- [ ] 搜索二期：搜索推荐词、二次召回、支持配置词库自定义关键词解析
- [ ] 数据库配置主从、分库分表，集成[cobar](https://github.com/alibaba/cobar)或[MyCat](https://github.com/MyCATApache/Mycat-Server)或[shardingsphere](https://github.com/apache/incubator-shardingsphere)(sharding-jdbc)
- [ ] 搭建 `ELK` 环境，对生产日志进行收集、查询和可视化分析
- [ ] 各模块发布 `docker` 镜像，实现服务容器化
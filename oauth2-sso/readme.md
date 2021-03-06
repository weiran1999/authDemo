# 文档
关于名为oauth2-sso的demo文档。

## 前言
```
Spring Cloud Security 为构建安全的SpringBoot应用提供了一系列解决方案，结合Oauth2可以实现单点登录功能
```

## 使用
- 这里jwtTokenStore与redisTokenStore在Bean注册上应该有bug，这里如果要使用JWT实现SSO，则要注释掉RedisTokenStoreConfig的注入
- oauth2-client可以添加权限校验
- SSO之下的client模块，在yml配置文件中需要添加对应的信息

## 理解
- Spring Security 的细节、底层换一处写；
在这个模块下，我知道了client模块必须要的是资源服务器注册类，否则受保护资源访问皆无效
- 在配置yml文件中的```user-info-uri```以及认证服务器配置类中关于redis+token与jwt配置令牌存储策略的相互转换
- 在配置文件中配置security属性，在SSO-Server里配置user-info-uri属性以及mvc具体的内容。然后其他SSO-client都添加上，就可以完成SSO的功能，这是网关统一鉴权登陆的类似方案。

## 底层
等待更新

---

[更多细节参考文章](http://www.macrozheng.com/#/cloud/oauth2_sso)
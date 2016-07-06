# wechat-framework

### 近日更新：

* 为方便查找与调用，``wechat-api``中的API类进行统一命名，以Wx字母开头，以API字母结尾，例如：``WxAccessTokenAPI``。
* ``wechat-framework-demo``示例工程，提供多公众号操作示例。
* ``wechat-framework-demo``提供新的token管理，目前已有单机版的token内存管理机制，以及分布式的redis管理机制。并提供可扩展的抽象类给用户自定义token管理方式。
* 微信公众平台后台管理系统开发提上日程。该系统用于替代官方的单一公众号管理方式，计划做成一个系统管理多个公众号。


#### [JS-SDK授权验证](https://github.com/vcdemon/wechat-framework/wiki/9-JS-SDK%E9%AA%8C%E8%AF%81%E4%BB%A3%E7%A0%81)
#### [微信本地开发环境搭建](https://github.com/vcdemon/wechat-framework/wiki/8-%E5%BE%AE%E4%BF%A1%E6%9C%AC%E5%9C%B0%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA)

BUG修复中。<br>
也欢迎各位将发现的BUG发送到我的邮箱中，或者提供对框架的改进建议。



``wechat-framework``简介
---

* ``wechat-framework``是一个``Java``开发的微信公众平台框架，目标在于替代官方的单一公众号管理方式，计划开发单一后台管理多公众号的后台管理系统。
* ``wechat-framework``是一个帮助开发者简化开发微信公众号的一套轻量级的``Java``应用框架，已将微信公众平台官方提供的API封装成直接调用的类，并且已经将应用与微信服务器之间的消息接收与返回完全封装完成：接收到的消息封装成``WechatRequest``对象，返回的消息封装成``WechatResponse``对象，微信公众号的消息加解密方式可以任选，安全模式的加解密同样不需要开发者操心，开发者完全不用关注太细节的问题，开发者只需要关注业务代码。


# [wechat-framework说明文档（1.0.2版本及以后）待定](https://github.com/vcdemon/wechat-framework/wiki)

# [wechat-framework说明文档（1.0.1版本及以前版本）](https://github.com/vcdemon/wechat-framework/wiki)

## 技术支持
* it技术交流QQ群 **286548895**
* 支持邮件 **345280563@qq.com**


## 贡献代码

1. 如果你觉得本项目不错，希望你能够点击一下右上角的star
2. 如果你希望参与改进本项目，那么请点击右上角的``fork``，修改之后``pull request``即可。如果你的贡献不错，你就会收到加入[wechat-framework](https://github.com/vcdemon/wechat-framework)开源社区的邀请。
3. 如果你发现了一个bug，请你创建一个issue来报告。
非常非常欢迎你能够参与本项目的建设，每人做出一点点贡献，对整个项目来说就是一个非常大的贡献，希望集合众人的力量，让项目走的更好，能够为更多的人服务。

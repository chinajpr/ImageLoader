# ImageLoader
图片加载框架

#### 实现功能
- 配置灵活
- 支持高并发
- 支持选择不同的加载策略(正序,倒序)
- 三级缓存,支持不同的缓存策略
- 加载过程中,显示默认加载图片
- 加载失败时,显示默认错误图片
- 图片显示自适应,图片经过压缩后显示,不能失真变形
- 支持请求转发,下载


#### 用到的设计模式
- 生产者消费者
- 建造者模式
- 单例模式
- 模板方法模式
- 策略模式

#### 其他知识点
- 内存缓存 LruCache
- 硬盘缓存 DiskLruCache
- 图片下载时请求转发
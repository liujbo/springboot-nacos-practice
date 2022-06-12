# （服务提供者）消息队列：Rocketmq练习

## 一、服务集成

### 1.项目集成nacos服务注册与发现

**所需依赖**

```xml
<!--服务注册与发现-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

**主启动类添加注解**

> **@EnableDiscoveryClient** 开启服务注册与发现功能

**主配置文件添加配置**

```yaml
spring:
  cloud:
    nacos:
      server-addr: localhost:8848 # nacos服务器地址
```

### 2.集成服务远程调用feign

**所需依赖**

```xml
<!--远程调用feign-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<!--负载均衡-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
    <version>3.1.2</version>
</dependency>
```

**主启动类添加注解**

> **@EnableFeignClients** 开启远程调用功能

**服务调用**
> 使用 **@FeignClient** 注解调用远程服务接口

示例：调用 nacos-rocketmq-provider 服务的 /consumer/query 接口

```java

@FeignClient(name = "nacos-rocketmq-provider", path = "/consumer")
public interface RocketmqProviderFeign {

    @PostMapping("/query")
    Object query(@RequestBody JSONObject jsonObject);
}
```

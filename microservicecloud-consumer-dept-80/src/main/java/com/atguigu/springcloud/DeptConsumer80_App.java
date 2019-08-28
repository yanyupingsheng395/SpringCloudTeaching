package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient

//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类(MySelfRule就是我们自定义的Ribbon的配置类)，从而使配置生效
//自定义的Ribbbon配置类,官网上提示不能跟@ComponentScan这个注解在同一包或者同一包下的子包里,
// 而这个注解就是@SpringBootApplication主启动类的注解下的注解,
// 所以自定义Ribbbon配置类就不能跟主启动类在一个包下
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}

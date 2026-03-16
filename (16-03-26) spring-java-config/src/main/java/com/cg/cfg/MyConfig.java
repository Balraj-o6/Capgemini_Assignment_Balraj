package com.cg.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.cg.bean.Address;
import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;

@Configuration("h")
@PropertySource("classpath:data.properties")
@ComponentScan("com")
public class MyConfig {
	
//	@Bean
//	//@Scope("prototype")
//	public HelloWorld getBean() {
//		return new HelloWorld();
//	}
//	
//	@Bean
//	public Employee getBean1() {
//		return new Employee(getBean3());
//	}
//
//	@Bean
//	public Address getBean2() {
//		return new Address();
//	}
//	
//	@Bean
//	public Address getBean3() {
//		Address add = new Address();
//		add.setCity("patna");
//		add.setCountry("india");
//		add.setZip(801503);
//		return add;
//	}
}

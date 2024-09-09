package com.chintanu01.service_a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ServiceAApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ServiceAApplication.class, args);
		System.out.println("=============>");
		CheckStuff stuff = context.getBean(CheckStuff.class);
		/*System.out.println(stuff);
		System.out.println(stuff.getValAnnotationCheck());
		System.out.println("=============>");
		System.out.println(context.getEnvironment());
		System.out.println(stuff.getEnvironment());
		System.out.println(stuff.getEnvironment().getProperty("valAnnotationCheck"));
		System.out.println("=============>");
		Props props = context.getBean(Props.class);
		System.out.println(props);
		System.out.println(props.getTest1());
		System.out.println(props.getTest2());
		System.out.println("=============> Config Server Prop Starts");*/
		System.out.println("Prop : " + stuff.getTestprop());
	}
	
}

@Component
class CheckStuff {

	@Value("${valAnnotationCheck}")
	private String valAnnotationCheck;

	@Autowired
	Environment environment;

	//@Value("${chintanu.testprop}")
	@Value("${gitrepo.testprop}")
	private String testprop;

	public String getTestprop() {
		return testprop;
	}

	public void setTestprop(String testprop) {
		this.testprop = testprop;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getValAnnotationCheck() {
		return valAnnotationCheck;
	}

	public void setValAnnotationCheck(String valAnnotationCheck) {
		this.valAnnotationCheck = valAnnotationCheck;
	}
}

@ConfigurationProperties(prefix = "config-annotation-check")
@Configuration
class Props {

	private String test1;
	private String test2;

	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}
}
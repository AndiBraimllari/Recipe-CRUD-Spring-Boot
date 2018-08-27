package com.project.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(new String[]{"com.project.config"});
		//Run tests here, probably will need to enable @EnableWebSecurity in the config folder
		context.close();
	}
}

package com.project.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.dao.RecipeDAO;
import com.project.dao.RecipeDAOAbst;
import com.project.dao.UserDAO;

//useless? @EnableTransactionManagement
//By using @EnableTransactionManagement and creating a bean of 
//type LocalSessionFactoryBean, spring will automatically create a 
//SessionFactory bean for you that you can inject/autowire anywhere.
@Configuration
public class HibernateConfig {

	@Bean(destroyMethod="close") // Automatically infers 'close' or 'shutdown' methods
	public BasicDataSource setDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/recipesdb");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean setLocalSessionFactoryBean(DataSource dataSource){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[]{"com.project.model"});
		Properties properties = new Properties();
		properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.id.new_generator_mappings","false");
		//Allows us to auto_increment from hibernate, Could use .IDENTITY instead of .AUTO and let DB handle it
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	@Bean //Injected(autowired) at ReceipeService intoRecipeDAOAbst recipedao  
	public RecipeDAO setPersonDAO(SessionFactory sessionFactory){ 
		RecipeDAO dao = new RecipeDAO();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	@Bean
	public UserDAO setUserDAO(SessionFactory sessionFactory){
		UserDAO dao = new UserDAO();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
}

package com.timposu.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.timposu.config")
@PropertySource("classpath:application.properties")
public class HibernateConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		driverManager.setDriverClassName(environment.getProperty("db.driver"));
		driverManager.setUrl(environment.getProperty("db.url"));
		driverManager.setUsername(environment.getProperty("db.username"));
		driverManager.setPassword(environment.getProperty("db.password"));
		return driverManager;
	}
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", 
				environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", 
				environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", 
				environment.getProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", 
				environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.timposu.model"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Autowired
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sf) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sf);
		return transactionManager;
	}
}

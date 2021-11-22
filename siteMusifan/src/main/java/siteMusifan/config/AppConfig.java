package siteMusifan.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan({"siteMusifan.services"})
@EnableTransactionManagement
@PropertySource("classpath:infos.properties")
@EnableJpaRepositories("siteMusifan.repositories")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public BasicDataSource dataSource () {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("dataSource.driverClassName"));	//env.getProperty("dataSource.driverClassName")
		dataSource.setUrl (env.getProperty("dataSource.url"));    //env.getProperty("dataSource.url")
		dataSource.setUsername(env.getProperty("dataSource.username"));      //env.getProperty("dataSource.username")
		dataSource.setPassword(env.getProperty("dataSource.password"));	//env.getProperty("dataSource.password")
		dataSource.setMaxTotal(5);
		return dataSource;
	}
	
	private Properties hibernateProperties () {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));		//env.getProperty("hibernate.dialect")
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.show_sql"));    //env.getProperty("hibernate.show_sql")
		properties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
		properties.setProperty("hibernate.cache.region.factory_class", env.getProperty("hibernate.cache.region.factory_class")); 
		return properties;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("siteMusifan.entity");
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(this.hibernateProperties());
		return emf;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation () {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public Validator validator() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		return validator;
	}
}

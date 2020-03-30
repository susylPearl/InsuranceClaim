package com.javra.medical.insurance.security;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.javra.medical.insurance.upload.FileValidator;
import com.javra.medical.insurance.validation.ClaimStatementValidator;
import com.javra.medical.insurance.validation.InsuranceClaimValidator;

@Configuration
@EnableWebSecurity
@PropertySource(value = { "classpath:configuration.properties" })
// @ComponentScan({ "com.javra.medical.insurance"
// ,"com.sample.reference.model","com.sample.reference.service","com.sample.reference.dao"})
@ComponentScan({ "com" })

@EnableTransactionManagement
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	// This configuration is for in memory
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}

	// This configuration will customize login page from default behavior
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/pages/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();
//		http
//		.csrf().disable();
	}

	@Resource
	public Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("<<<configuring for hibernate>>> ");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory
				.setPackagesToScan(new String[] { "com.javra.medical.insurance.model", "com.sample.reference.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("printing for env value" + environment);
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		
		return properties;
	}
	
	private Properties sendMailProperties() {
		Properties properties = new Properties();
		properties.put("mail.host", environment.getRequiredProperty("mail.host"));
		properties.put("mail.port", environment.getRequiredProperty("mail.port"));
		properties.put("mail.username", environment.getRequiredProperty("mail.username"));
		properties.put("mail.password", environment.getRequiredProperty("mail.password"));
		
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
	
	/**
	 * This method is used for configuring the MAIL SERVER to send the mail.
	 * @return
	 */
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl(){
		  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		  mailSender.setHost(environment.getRequiredProperty("mail.host"));
		  mailSender.setPort(587);
		  //Set gmail email id
		  mailSender.setUsername(environment.getRequiredProperty("mail.username"));
		  //Set gmail email password
		  mailSender.setPassword(environment.getRequiredProperty("mail.password"));
		  Properties prop = mailSender.getJavaMailProperties();
		  prop.put("mail.transport.protocol", "smtp");
		  prop.put("mail.smtp.auth", "true");
		  prop.put("mail.smtp.starttls.enable", "true");
		  prop.put("mail.debug", "true");
		  return mailSender;
		 }
	
	@Bean 
    public CommonsMultipartResolver getResolver() throws IOException{
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
         
        //Set the maximum allowed size (in bytes) for each individual file.
        resolver.setMaxUploadSizePerFile(5242880);//5MB
         
        //You may also set other available properties.
         
        return resolver;
    }
	
	 @Bean
	   public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        return messageSource;
	   }

	
	@Bean
	@Qualifier("insuranceClaimValidator")
	public InsuranceClaimValidator insuranceClaimValidator(){
		InsuranceClaimValidator mailSender = new InsuranceClaimValidator();
		  
		  return mailSender;
		 }
	
	
	
	@Bean
	@Qualifier("claimStatementValidator")
	public ClaimStatementValidator claimStatementValidator(){
		ClaimStatementValidator mailSender = new ClaimStatementValidator();
		  
		  return mailSender;
		 }
	
	@Bean
	@Qualifier("uploadValidator")
	public FileValidator uploadValidator(){
		FileValidator validator = new FileValidator();
		  
		  return validator;
		 }

}
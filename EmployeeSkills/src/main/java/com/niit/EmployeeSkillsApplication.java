package com.niit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication(scanBasePackages = "com.niit")
public class EmployeeSkillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSkillsApplication.class, args);
	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory()
	{
		return new HibernateJpaSessionFactoryBean();
	}

}

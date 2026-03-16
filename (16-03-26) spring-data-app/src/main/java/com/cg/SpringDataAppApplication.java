package com.cg;

import com.cg.repo.IEmployeeRepo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.entity.Employee;

@SpringBootApplication
public class SpringDataAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDataAppApplication.class, args);
		IEmployeeRepo erepo = ctx.getBean(IEmployeeRepo.class);
		erepo.save(new Employee("Romi",LocalDate.of(2003, 6, 25),40000));
		System.out.println("Employee Created....");
	}

}

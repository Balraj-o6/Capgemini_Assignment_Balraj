package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cg.collection.Employee3;
import com.cg.collection.EmployeeService;
import com.cg.employee.Employee;
import com.cg.sbu.Employee1;
import com.cg.sbu.SBU;
import com.cg.sbuList.Employee2;
import com.cg.sbuList.SBUList;

@SpringBootApplication
public class SpringAssignment160326Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringAssignment160326Application.class, args);
//		first question
		Employee e = ctx.getBean(Employee.class);
		e.firstQuestion();
//		second question
		Employee1 e1 = ctx.getBean(Employee1.class);
		e1.secondQuestion();
//		third question
		SBUList s = ctx.getBean(SBUList.class);
		s.thirdQuestion();
//		fourth question
		EmployeeService es = ctx.getBean(EmployeeService.class);
		es.fourthQuestion(101);

	}

	@Bean()
	Employee getBean1() {
		Employee e = new Employee();
		e.setEmpid(101);
		e.setName("Balraj");
		e.setSal(55000);
		e.setSbu("BU-PES");
		e.setAge(23);
		return e;
	}

	@Bean
	Employee1 getBean2() {
		Employee1 e = new Employee1();
		e.setEmpId(101);
		e.setEmpName("Balraj");
		e.setSalary(550000);
		e.setAge(23);
		return e;
	}
	
	@Bean
	SBU getBean3() {
		SBU s = new SBU();
		s.setSbuCode("BU-PES");
		s.setSbuName("Engineering");
		s.setSbuHead("Kiran rao");
		return s;
	}
	
	@Bean
	Employee2 getBean4() {
		Employee2 e = new Employee2(101,"Balraj",550000);
		return e;
	}
	
	@Bean
	Employee2 getBean5() {
		Employee2 e = new Employee2(102,"Golden",30000);
		return e;
	}
	
	@Bean
	SBUList getBean6() {
		SBUList s = new SBUList();
		s.setSbuCode("BU-PES");
		s.setSbuName("Engineering");
		s.setSbuHead("Kiran rao");
		return s;
	}
	
	@Bean
	Employee3 getBean7() {
		Employee3 e = new Employee3(101,"Balraj",550000);
		return e;
	}
	
	@Bean
	Employee3 getBean8() {
		Employee3 e = new Employee3(102,"Golden",30000);
		return e;
	}
	
	@Bean
	EmployeeService getBean9() {
		EmployeeService es = new EmployeeService();
		return es;
	}
}

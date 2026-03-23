package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringRestDemoApplicationTests {
	
	@Mock  // makes a mock repo object
	private IEmployeeRepo repo;
	@InjectMocks  // injects mock object
	private EmployeeService service;
	
//	@Test
//	void testEmployeeById() {
//		assertNotNull(service.getEmployee(1));
//		assertThrows(EmployeeNotFoundException.class, ()->service.getEmployee(222));
//		assertEquals("Ram", service.getEmployee(1).getFullName());
//	}
	
	
	@Test
	void testEmployeeById() {
		EmployeeDTO edto = new EmployeeDTO("Rama",LocalDate.of(2002, 10, 12),34000.00);
		edto.setEmployeeId(1001);
		Employee emp = EntityMapper.convertObjectToEntity(edto);
		Optional<Employee> op = Optional.of(emp);
		when(repo.findById(1001)).thenReturn(op);
		assertNotNull(service.getEmployee(1001));
		assertEquals("Rama", service.getEmployee(1001).getFullName());
	}
	
	@Test
	void testEmployeeAll() {
		List<Employee> li = new ArrayList<Employee>();
		EmployeeDTO edto = new EmployeeDTO("Rama",LocalDate.of(2002, 10, 12),34000.00);
		edto.setEmployeeId(1001);
		
		li.add(EntityMapper.convertObjectToEntity(edto));
		when(repo.findAll()).thenReturn(li);
		assertNotNull(service.getAllEmployee());
		
	}
	
	@Test
	void testEmployeeCreate() {
	    EmployeeDTO edto = new EmployeeDTO("Rama", LocalDate.of(2002, 10, 12), 34000.00);
	    //edto.setEmployeeId(1001);

	    Employee e = EntityMapper.convertObjectToEntity(edto);

	    when(repo.saveAndFlush(any(Employee.class))).thenReturn(e);

	    EmployeeDTO result = service.createEmployee(edto);

	    assertEquals(edto.getEmployeeId(), result.getEmployeeId());
	    assertEquals(edto.getFullName(), result.getFullName());
	}
	
	@Test
	void testEmployeeRemove() {
		EmployeeDTO edto = new EmployeeDTO("Rama",LocalDate.of(2002, 10, 12),34000.00);
		edto.setEmployeeId(1001);
		Employee emp = EntityMapper.convertObjectToEntity(edto);
		Optional<Employee> op = Optional.of(emp);
		when(repo.findById(1001)).thenReturn(op);
		
		String r = service.removeEmployee(1001);
		assertEquals("Employee Deleted....", r);
		when(repo.findById(1002)).thenThrow(EmployeeNotFoundException.class);
		assertThrows(EmployeeNotFoundException.class, ()->service.removeEmployee(1002));
		verify(repo,times(1)).deleteById(1001);;
		}
		
	  
	
	@Test
	void testEmployeeUpdate() {
		EmployeeDTO edto = new EmployeeDTO("Rama", LocalDate.of(2002, 10, 12), 34000.00);
	   // edto.setEmployeeId(1001);
	   
	    Employee e = new Employee("Rama", LocalDate.of(2002, 10, 12), 34000.00);
	    edto.setEmployeeId(1001);
	    Optional<Employee> op = Optional.of(e);
	    when(repo.findById(1001)).thenReturn(op);
	    
	    when(repo.saveAndFlush(any(Employee.class))).thenReturn(e);

	    EmployeeDTO result = service.updateEmployee(edto);
	    result.setEmployeeId(1001);
	    assertEquals(edto.getEmployeeId(), result.getEmployeeId());
	    assertEquals(edto.getFullName(), result.getFullName());
		
	}
	
	
	@Test
	void testEmployeeByName() {
		List<Employee> li = new ArrayList<Employee>();
		EmployeeDTO edto = new EmployeeDTO("Rama",LocalDate.of(2002, 10, 12),34000.00);
		edto.setEmployeeId(1001);
		
		li.add(EntityMapper.convertObjectToEntity(edto));
		when(repo.findByName("Rama")).thenReturn(li);
		assertNotNull(service.getEmpByName("Rama"));
		
	}
	
	
	@Test
	void testEmployeeByIdWithException() {
		
		when(repo.findById(1002)).thenThrow(EmployeeNotFoundException.class);
		assertThrows(EmployeeNotFoundException.class, ()->service.getEmployee(1002));
		
	}
	
}

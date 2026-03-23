package com.cg;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import com.cg.controller.EmployeeController;
import com.cg.dto.EmployeeDTO;
import com.cg.service.IEmployeeService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private IEmployeeService service;

	@Test
	void testGetAll() throws Exception {
		List<EmployeeDTO> li = new ArrayList<EmployeeDTO>();
		EmployeeDTO edto = new EmployeeDTO("Rama", LocalDate.of(2002, 10, 12), 34000.00);
		edto.setEmployeeId(1001);
		EmployeeDTO edto1 = new EmployeeDTO("Ram", LocalDate.of(2001, 11, 11), 31000.00);
		edto.setEmployeeId(1002);
		li.add(edto);
		li.add(edto1);
		when(service.getAllEmployee()).thenReturn(li);
		mockMvc.perform(get("/employees")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].fullName").value("Rama"));

	}

	@Test
	void testGetEmpById() throws Exception {
		EmployeeDTO edto = new EmployeeDTO("Rama", LocalDate.of(2002, 10, 12), 34000.00);
		edto.setEmployeeId(1001);
		when(service.getEmployee(1001)).thenReturn(edto);

		mockMvc.perform(get("/employees/1001")).andExpect(status().isOk())
				.andExpect(jsonPath("$.fullName").value("Rama"));

	}

	@Test
	void testCreateEmp() throws Exception {
		EmployeeDTO edto = new EmployeeDTO("Ram", LocalDate.of(2002, 10, 12), 34000.00);
		when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(edto);
		mockMvc.perform(post("/employees").contentType(String.valueOf(MediaType.APPLICATION_JSON))
				.content(new ObjectMapper().writeValueAsString(edto))).andExpect(status().isOk())
				.andExpect(jsonPath("$.fullName").value("Ram"));
	}

	@Test
	void testUpdateEmp() throws Exception {
		EmployeeDTO edto = new EmployeeDTO("Ram", LocalDate.of(2002, 10, 12), 34000.00);
		when(service.updateEmployee(any(EmployeeDTO.class))).thenReturn(edto);
		mockMvc.perform(put("/employees").contentType(String.valueOf(MediaType.APPLICATION_JSON))
				.content(new ObjectMapper().writeValueAsString(edto))).andExpect(status().isOk())
				.andExpect(jsonPath("$.fullName").value("Ram"));
	}

	@Test
	void testGetEmpByName() throws Exception {
		List<EmployeeDTO> li = new ArrayList<EmployeeDTO>();
		EmployeeDTO edto = new EmployeeDTO("Rama", LocalDate.of(2002, 10, 12), 34000.00);
		li.add(edto);
		when(service.getEmpByName("Rama")).thenReturn(li);

		mockMvc.perform(get("/employees/name/Rama")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].fullName").value("Rama"));

	}

	@Test
	void testDeleteById() throws Exception {
		when(service.removeEmployee(1001)).thenReturn("Employee Deleted...");
		mockMvc.perform(delete("/employees/1001")).andExpect(status().isOk())
				.andExpect(content().string("Employee Deleted..."));
	}
}

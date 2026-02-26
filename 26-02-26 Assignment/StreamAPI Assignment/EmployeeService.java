package com.labs;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeService {
	public double sumOfSalary() {
		double totalSalary = EmployeeRepository.getEmployees().stream().map(e -> e.getSalary())
				.collect(Collectors.summingDouble(n -> n));
		return totalSalary;
	}

	public Map<String, Long> getCountNoOfEEmployeeByDept() {
		Map<String, Long> m = EmployeeRepository.getEmployees().stream().filter(e -> e.getDepartment() != null)
				.map(e -> e.getDepartment().getDepartmentName())
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		return m;
	}

	public String getSeniorMostEmployee() {
		Employee name = EmployeeRepository.getEmployees().stream()
				.min((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate())).get();
		return name.getFirstName() + " " + name.getLastName();
	}

	public List<String> getEmployeeDuration() {
		List<String> li = EmployeeRepository.getEmployees().stream().map(e -> {
			Period p = Period.between(e.getHireDate(), LocalDate.now());
			int totalMonth = p.getYears() * 12 + p.getMonths();
			return e.getFirstName() + " " + e.getLastName() + " | " + "Total Months: " + totalMonth + " | Days: "
					+ p.getDays();
		}).toList();
		return li;
	}

	public List<Employee> getEmployeeWithoutDept() {
		List<Employee> li = EmployeeRepository.getEmployees().stream().filter(e -> (e.getDepartment() == null))
				.collect(Collectors.toList());
		return li;
	}

	public List<Department> getDeptWithoutEmployee() {
		Set<Department> st = EmployeeRepository.getEmployees().stream().filter(e -> e.getDepartment() != null)
				.map(e -> e.getDepartment()).collect(Collectors.toSet());
		List<Department> li = EmployeeRepository.getDepartments().stream().filter(e -> !st.contains(e))
				.collect(Collectors.toList());
		return li;
	}

	public String getDeptWithHighestCountEmployee() {
		Map<String, Long> empCount = EmployeeRepository.getEmployees().stream().filter(e -> e.getDepartment() != null)
				.map(e -> e.getDepartment().getDepartmentName())
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		Map.Entry<String, Long> maxCount = empCount.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
		return maxCount.getKey() + " = " + maxCount.getValue();
	}

}

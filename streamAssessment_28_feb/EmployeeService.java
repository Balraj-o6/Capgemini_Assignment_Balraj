package streamAssessment_28_feb;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
	public double getAverageSalary() {
		double avgSalary = EmployeeRepository.getEmployees().stream().map(e -> e.getSalary())
				.collect(Collectors.averagingDouble(n -> n));
		return avgSalary;
	}

	public Map<String, String> getMaxSalaryEachDept() {
		Map<String, String> maxSalary = EmployeeRepository.getEmployees().stream()
				.filter(e -> e.getDepartment() != null)
				.collect(Collectors.groupingBy(e -> e.getDepartment().getDepartmentName(),
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
								e -> e.map(e1 -> e1.getFirstName() + " " + e1.getLastName()).orElse(null))));
		return maxSalary;
	}

	public Map<String, Double> getTotalSalaryEachDept() {
		Map<String, Double> tatalSalEachDept = EmployeeRepository.getEmployees().stream()
				.filter(e -> e.getDepartment() != null).collect(Collectors.groupingBy(
						e -> e.getDepartment().getDepartmentName(), Collectors.summingDouble(Employee::getSalary)));
		return tatalSalEachDept;
	}

	public List<String> getEmpNameEmpSal() {
		List<String> empNameSal = EmployeeRepository.getEmployees().stream().map(e -> e.getFirstName()+" "+e.getLastName() + "-" + e.getSalary())
			        .collect(Collectors.toList());
		return empNameSal;
	}
	
	public List<Employee> getSortEmpBySal() {
		List<Employee> sortedBySalaryDesc =
			    EmployeeRepository.getEmployees().stream()
			        .sorted(Comparator.comparing(Employee::getSalary).reversed())
			        .collect(Collectors.toList());
		return sortedBySalaryDesc;
	}
}

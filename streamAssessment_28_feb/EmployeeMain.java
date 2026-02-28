package streamAssessment_28_feb;

public class EmployeeMain {
	public static void main(String[] args) {
		EmployeeService es = new EmployeeService();
		System.out.println(es.getAverageSalary());
		System.out.println(es.getMaxSalaryEachDept());
		System.out.println(es.getTotalSalaryEachDept());
		System.out.println(es.getEmpNameEmpSal());
		System.out.println(es.getSortEmpBySal());
	}
}

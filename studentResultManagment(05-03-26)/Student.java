package studentResultManagment;

public class Student {

	private int studentId;
	private String studentName;
	private String course;
	private int marks;

	// Constructor
	public Student(int studentId, String studentName, String course, int marks) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.course = course;
		this.marks = marks;
	}

	// Getters
	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getCourse() {
		return course;
	}

	public int getMarks() {
		return marks;
	}

	// toString()
	@Override
	public String toString() {
		return "Student Id: " + studentId + ", Student Name: " + studentName + ", Course: " + course + ", Marks: "
				+ marks;
	}
}
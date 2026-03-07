package studentResultManagment;

import java.util.*;
import java.io.*;

public class StudentManagment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int id = 0;
        String name = "";
        String course = "";
        int marks = 0;

        // TODO: Create ArrayList to store students
        List<Student> students = new ArrayList<>();

        // TODO: Loop to take input for 5 students

        for(int i = 0; i < 5; i++) {

            try {

                // TODO: Read studentId
            	System.out.println("Enter student id: ");
            	id = sc.nextInt();
            	sc.nextLine();

                // TODO: Read studentName
            	System.out.println("Enter student name: ");
            	name = sc.nextLine();

                // TODO: Validate name using matches()
            	// throw InvalidNameException if invalid
            	if(name.isEmpty()) {
            		throw new InvalidNameException("Only letters allowed in name");
            	}


                // TODO: Read course
            	System.out.println("Enter student course: ");
            	course = sc.nextLine();
            	

                // TODO: Read marks
            	System.out.println("Enter student marks: ");
            	marks = sc.nextInt();

                // TODO: Validate marks (0–100)
                // throw IllegalArgumentException if invalid
            	if(marks>=0 && marks<=100) {
            		students.add(new Student(id, name, course, marks));
            	}else {
            		throw new IllegalArgumentException("Invalid marks.");
            	}

                // TODO: Create Student object

                // TODO: Add student to ArrayList

            }
            catch(InvalidNameException e) {
                e.getMessage();
            }
            catch(IllegalArgumentException e) {
            	e.getMessage();
            }
        }

        // TODO: Write student data to file (students.txt)

        // Use FileWriter and BufferedWriter
        try (FileWriter fl = new FileWriter("Student.txt",true)) {
        	for(int i = 0;i < students.size();i++) {
			fl.write(students.get(i).getStudentId()+",");
			fl.write(students.get(i).getStudentName()+",");
			fl.write(students.get(i).getCourse()+",");
			fl.write(students.get(i).getMarks()+"\n");
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        


        // TODO: Read data from file and display

        // Use FileReader and BufferedReader
        try {
			BufferedReader fr = new BufferedReader(new FileReader("student.txt"));
			String line;
			while((line = fr.readLine()) != null) {
				System.out.println(line);
			}
			fr.close();	
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}

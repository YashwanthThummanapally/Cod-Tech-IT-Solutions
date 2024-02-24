package com.java.StudentManagementSystem;

public class StudentPortal 
{
	private Student[] students;
	private int studentCount;
	
	public StudentPortal(int size)
	{
		super();
		this.students = new Student[size];
	}
	
	public void validateMarks(int marks) throws InvalidMarksException
	{
		if(marks<0 || marks>100)
		{
			throw new InvalidMarksException("Marks cannot be negative or greater than zero");
		}
	}
	
	public boolean addStudent(String studentName, String rollNumber, int marks1, int marks2, int marks3)
	{
		if(this.isFull())
		{
			return false;
		}
		else
		{
			this.students[this.studentCount++] = new Student(studentName, rollNumber, marks1, marks2, marks3);
			return true;
		}
	}

	public boolean isFull()
	{
		if(this.studentCount==this.students.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean updateStudent(String rollNumber, String studentName)
	{
		if(this.isStudentPresent(rollNumber))
		{
			for(Student student : this.students)
			{
				if(student.getRollNumber().equals(rollNumber))
				{
					student.setStudentName(studentName);
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateStudent(String rollNumber, int marks1, int marks2, int marks3)
	{
		if(this.isStudentPresent(rollNumber))
		{
			int marks[] = new int[] {marks1, marks2, marks3};
			
			for(Student student : this.students)
			{
				if(student.getRollNumber().equals(rollNumber))
				{
					student.setMarks(marks);
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean isStudentPresent(String rollNumber)
	{
		if(!this.isEmpty())
		{
			for(Student student : this.students)
			{
				if(student.getRollNumber().equals(rollNumber))
				{
					return true;
				}
			}			
		}
		return false;
	}
	
	public boolean deleteStudent(String rollNumber)
	{
		if(this.isStudentPresent(rollNumber))
		{
			Student newStudents[] = new Student[this.students.length-1];
			
			int index = 0;
			for(Student student : this.students)
			{
				if(!student.getRollNumber().equals(rollNumber))
				{
					newStudents[index++] = student;
				}
			}
			this.students = newStudents;
			this.studentCount--; // one student record deleted 
			return true;
		}
		return false;
	}
	
	public boolean isEmpty()
	{
		if(this.studentCount==0)
		{
			return true;
		}
		return false;
	}
	
	public void displayStudents()
	{
		if(!this.isEmpty())
		{
			System.out.println("Student records :");
			
			for(Student student : this.students)
			{
				System.out.println(student);
			}
		}
		else
		{
			System.err.println("No student records inserted");
		}
	}
}

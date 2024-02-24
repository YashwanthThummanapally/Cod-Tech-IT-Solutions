package com.java.StudentManagementSystem;

import java.text.DecimalFormat;

public class Student 
{
	private String studentName;
	private String rollNumber;
	private int[] marks;
	private double percentage;
	private String grade;
	private String percentageString; // percentage in String format
	
	public Student(String studentName, String rollNumber, int mathsMarks, int physicsMarks, int chemistryMarks)
	{
		super();
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		this.marks = new int[] {mathsMarks, physicsMarks, chemistryMarks};
		this.calculatePercentage();
		this.assignGrade();
	}
	
	public void setStudentName(String name)
	{
		this.studentName = name;
	}

	public String getStudentName()
	{
		return this.studentName;
	}
	
	public void setRollNumber(String rollNumber)
	{
		this.rollNumber = rollNumber;
	}
	
	public String getRollNumber()
	{
		return this.rollNumber;
	}
	
	public void setMarks(int[] marks)
	{
		this.marks = marks;
		this.calculatePercentage();
		this.assignGrade();
	}
	
	public int[] getMarks()
	{
		return this.marks;
	}
		
	public double getPercentage()
	{
		return this.percentage;
	}
		
	public String getGrade()
	{
		return this.grade;
	}
	
	@Override
	public String toString()
	{
		return "Student [name = "+this.studentName+", rollNumber = "+this.rollNumber+
", mathsMarks = "+this.marks[0]+", physicsMarks ="+this.marks[1]+", chemistryMarks = " +this.marks[2]+", percentage = "+this.percentageString+"%, grade = "+this.grade+"]";
	}
	
	public void calculatePercentage()
	{
		int totalMarks = 0;
		
		for(int score : this.marks)
		{
			totalMarks += score;
		}
		
		this.percentage = totalMarks/(double)this.marks.length;
		
		DecimalFormat df = new DecimalFormat("00.0");
		this.percentageString = df.format(this.percentage);
	}
	
	public void assignGrade()
	{
		if(this.percentage>=90)
		{
			this.grade = "A+";
		}
		else if(this.percentage>=80 && this.percentage<90)
		{
			this.grade = "A";
		}
		else if(this.percentage>=70 && this.percentage<80)
		{
			this.grade = "B+";
		}
		else if(this.percentage>=60 && this.percentage<70)
		{
			this.grade = "B";
		}
		else if(this.percentage>=55 && this.percentage<60)
		{
			this.grade = "C+";
		}
		else if(this.percentage>=45 && this.percentage<55)
		{
			this.grade = "C";
		}
		else if(this.percentage>=40 && this.percentage<45)
		{
			this.grade = "D";
		}
		else
		{
			this.grade = "F";
		}
	}
}
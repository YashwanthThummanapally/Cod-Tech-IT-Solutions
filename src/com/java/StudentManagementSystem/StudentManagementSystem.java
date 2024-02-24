package com.java.StudentManagementSystem;

import java.util.Scanner;

public class StudentManagementSystem 
{
	static
	{
		System.out.println("Student Management System");
		System.out.println("-------------------------");
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of student records you want to store :");// record size
		int size = 0;
		
		try
		{
			size = Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e)
		{
			System.err.println("Error : Only integers are allowed here");
			sc.close();
			return;
		}

		StudentPortal portal = new StudentPortal(size); 

		while(true)
		{
			System.out.println("Menu");
			System.out.println("1. Add student record");
			System.out.println("2. Update student record");
			System.out.println("3. Delete student record");
			System.out.println("4. Display student records");
			System.out.println("5. Quit");
			
			System.out.println("Enter your choice :");
			try
			{			
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice)
				{
					case 1 : System.out.println("Enter student name :"); // user input
					 		 String name = sc.nextLine();
					 		 System.out.println("Enter student roll number :");
					 		 String rollNumber = sc.nextLine();
					 		 System.out.println("Enter 1st subject marks :");
					 		 int marks1 = Integer.parseInt(sc.nextLine());
					 		 portal.validateMarks(marks1); // validates marks
					 		 System.out.println("Enter 2nd subject marks :");
					 		 int marks2 = Integer.parseInt(sc.nextLine());
					 		 portal.validateMarks(marks2);
					 		 System.out.println("Enter 3rd subject marks :");
					 		 int marks3 = Integer.parseInt(sc.nextLine());
					 		 portal.validateMarks(marks3);
					 		 
					 		 boolean result = portal.addStudent(name, rollNumber, marks1, marks2, marks3);
					 		 if(result)
					 		 {
					 			 System.out.println("Student record inserted successfully");
					 		 }
					 		 else
					 		 {
					 			 System.err.println("Sorry! Student file is full. Cannot insert new student.");
					 		 }
					 		 break;
					 		 
					case 2 : System.out.println("What do you want to update ?");
					 		 System.out.println("a. Name of the student");
					 		 System.out.println("b. Marks");
					 		 
					 		 System.out.println("Enter your choice :");
					 		 String choiceChar = sc.nextLine();
					 		 
					 		 switch(choiceChar)
					 		 {
					 		 	case "a" : System.out.println("Enter roll number of the student :");
					 		 	 		   rollNumber = sc.nextLine();
					 		 	 		   System.out.println("Enter updated student name :");
					 		 	 		   name = sc.nextLine();
					 		 	 		   
					 		 	 		   result = portal.updateStudent(rollNumber, name);
					 		 	 		   if(result)
					 		 	 		   {
					 		 	 			   System.out.println("Record updated successfully");
					 		 	 		   }
					 		 	 		   else
					 		 	 		   {
					 		 	 			   if(portal.isEmpty())
					 		 	 			   {
					 		 	 				   System.err.println("Sorry! Nothing to update. Student file is empty");
					 		 	 			   }
					 		 	 			   else if(!portal.isStudentPresent(rollNumber))
					 		 	 			   {
					 		 	 				   System.err.println("Sorry! Student record is not available in the file");
					 		 	 			   }
					 		 	 		   }
					 		 	 		   break;
					 		 	 		   
					 		 	case "b" : System.out.println("Enter roll number of the student :");
					 		 	 		   rollNumber = sc.nextLine();
					 		 	 		   System.out.println("Enter updated 1st subject marks :");
					 		 	 		   marks1 = Integer.parseInt(sc.nextLine());
					 		 	 		   portal.validateMarks(marks1);
					 		 	 		   System.out.println("Enter updated 2nd subject marks :");
					 		 	 		   marks2 = Integer.parseInt(sc.nextLine());
					 		 	 		   portal.validateMarks(marks2);
					 		 	 		   System.out.println("Enter updated 3rd subject marks :");
					 		 	 		   marks3 = Integer.parseInt(sc.nextLine());
					 		 	 		   portal.validateMarks(marks3);
					 		 	 		   
					 		 	 		   result = portal.updateStudent(rollNumber, marks1, marks2, marks3);
					 		 	 		   if(result)
					 		 	 		   {
					 		 	 			   System.out.println("Student record updated");
					 		 	 		   }
					 		 	 		   else
					 		 	 		   {
					 		 	 			   if(portal.isEmpty())
					 		 	 			   {
					 		 	 				   System.err.println("Sorry! Nothing to update. Student file is empty");
					 		 	 			   }
					 		 	 			   else if(!portal.isStudentPresent(rollNumber))
					 		 	 			   {
					 		 	 				   System.err.println("Sorry! Student record is not available in the file");
					 		 	 			   }
					 		 	 		   }
					 		 	 		   break;
					 		 	 		   
					 		 	 default : System.err.println("Invalid choice");
					 		 }
					 		 break;
					 		 
					case 3 : System.out.println("Enter roll number of student you want to delete :");
							 rollNumber = sc.nextLine();
							 result = portal.deleteStudent(rollNumber);
							 if(result)
							 {
								 System.out.println("Student record deleted successfully");
							 }
							 else
							 {
		 		 	 			   if(portal.isEmpty())
		 		 	 			   {
		 		 	 				   System.err.println("Sorry! Nothing to delete. Student file is empty");
		 		 	 			   }
		 		 	 			   else if(!portal.isStudentPresent(rollNumber))
		 		 	 			   {
		 		 	 				   System.err.println("Sorry! Student record is not available in the file");
		 		 	 			   }							 
		 		 	 		}
							 break;
							 
					case 4 : portal.displayStudents(); 
							 break;
					
					case 5 : System.out.println("Thankyou!!! visit again");
					 		 sc.close();
					 		 System.exit(0);
					 
					default : System.err.println("Invalid choice");
				}			
			}
			catch(NumberFormatException e)
			{
				System.err.println("Error : Only integers are allowed here");
			}
			catch(InvalidMarksException e)
			{
				System.err.println("Error : "+e.getMessage());
			}	
			System.out.println();
		}
	}
}

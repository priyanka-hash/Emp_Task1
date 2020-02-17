/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.sql.*;
import java.util.Scanner;


/**
 *
 * @author MRuser
 */
public class Employee
{
  Connection con;
  Statement st;
  ResultSet rs;
  int choice;
  
  public Employee()
  {
      try
      {
      Class.forName("com.mysql.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
      st=con.createStatement();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      
      
      
  }
  
  public void addEmployee()
  {
      try
      {
      
      
      String query="insert into Emp values(101,'Sachin',23000)";
      
      int count=st.executeUpdate(query);
      
      System.out.println("No of Employee affected"+count);
          
      
       }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      
  }


  public void updateEmp()
  {
      try
      {
         String query="update Emp set empname='Tejas' where empid=101";  
    
        int count=st.executeUpdate(query);
      
        System.out.println("No of Employee affected"+count);
          
      
       }
      catch(Exception e)
      {
          e.printStackTrace();
      }   
      
     
      
  }
  public void viewEmp()
  {
      try
      {
         String query="Select * from Emp";  
    
          rs=st.executeQuery(query);
      
          while(rs.next())
          {
              System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
          }
          
      
       }
      catch(Exception e)
      {
          e.printStackTrace();
      }   
      
     
  }
  public void deleteEmp()
  {
      try
      {
      String query="delete from Emp where empid=101";  
       int count=st.executeUpdate(query);
      
        System.out.println("No of Employee affected"+count);
          
      
       }
      catch(Exception e)
      {
          e.printStackTrace();
      }   
  }
  public static  void main(String args[])
  {
      Employee e=new Employee();
      int choice;
      
    Scanner sc=new Scanner(System.in);
      
      System.out.println("Employee Task App");
      System.out.println("--------------------");
      
      System.out.println("Enter the Choice");
      choice=sc.nextInt();
      
      System.out.println("1.Add Employee data");
      System.out.println("2.Modify Employee Data");
      System.out.println("3.Delete Employee Data");
      System.out.println("4.View All Employees");
      System.out.println("5.View single Employee");
      System.out.println("6.Exit");
      
      if(choice==1)
      {
          e.addEmployee();
      }
      else if(choice==2)
      {
          e.updateEmp();
      }
      else if(choice==3)
      {
          e.deleteEmp();
      }
      else if(choice==4)
      {
          e.viewEmp();
      }
      else
      {
          System.out.println("Ur choice is Wrong");
      }
      
  }
    
}

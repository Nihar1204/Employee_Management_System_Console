package mains;
import java.util.Scanner;
import entity.Employee;
import logic.EmployeeLogic;
public class MethodCall {
	Scanner sc= new Scanner(System.in);
	Employee emp=new Employee();
	EmployeeLogic el=new EmployeeLogic();
	
	public boolean empAdd()
	{
		System.out.println("Enter Employee Id!");
		int Id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Employee Name!");
		String Name=sc.nextLine();
		System.out.println("Enter Employee Uname!");
		String Uname=sc.next();
		System.out.println("Enter Employee Salary!");
		double Salary =sc.nextDouble();
		System.out.println("Enter Employee Pass!");
		String Pass=sc.next();
		emp.setId(Id);
		emp.setName(Name);
		emp.setUname(Uname);
		emp.setSalary(Salary);
		emp.setPass(Pass);
		
		boolean r=el.addEmp(emp);
		
		return r;
	}
	
	public boolean empUpd()
	{
		
		System.out.println("Enter Employee Uname!");
		String Uname=sc.next();
		System.out.println("Enter Employee Salary!");
		double Salary =sc.nextDouble();
		
	
		
		emp.setSalary(Salary);
		emp.setUname(Uname);
		
		boolean r=el.updateEmp(emp);
		
		return r;
	}
	
	public boolean empDelt()
	{
		
		System.out.println("Enter Employee Uname!");
		String Uname=sc.next();
		
		emp.setUname(Uname);

		boolean r=el.deleteEmp(Uname);
		
		return r;
	}
	
}

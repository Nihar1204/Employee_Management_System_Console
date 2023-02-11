package mains;
import java.util.*;
import entity.Employee;
import logic.EmployeeLogic;
//import connector.Connector;
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Employee emp=new Employee();
		EmployeeLogic el=new EmployeeLogic();
		MethodCall mc=new MethodCall();
		
		System.out.println("Login!");
		for(int i=1;i<=3;i++)
		{
		System.out.println("Enter your Uname!");
		String Uname =sc.next();
		System.out.println("Enter your Pass!");
		String Pass =sc.next();
		boolean r=el.login(Uname,Pass);
		if(r==true)
		{
			while(true)
			{
				System.out.println("1: For Add Employee...");
				System.out.println("2: For Update Employee...");
				System.out.println("3: For Delete Employee...");
				System.out.println("4: For Show By UserName of Employee...");
				System.out.println("5: For Show All The Employee...");
				System.out.println("6: For Show All The Employee Order By Salary Descending...");
				System.out.println("7: For Logout...");
				System.out.println("Enter Your Choice...");
				int choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:
					boolean r1=mc.empAdd();
					if(r1==true)
						System.out.println("Inserted Successfully.....");
					break;
				case 2:
					boolean r2=mc.empUpd();
					if(r2==true)
						System.out.println("Updated Successfully.....");
					break;
				case 3:
					boolean r3=mc.empDelt();
					if(r3==true)
						System.out.println("Deleted Successfully.....");
					break;
				case 4:
					System.out.println("Enter The Uname of the Employee!");
					String UName=sc.next();
					Employee emp1=el.showByUname(UName);
					System.out.println("Id: "+emp1.getId());
					System.out.println("Name: "+emp1.getName());
					System.out.println("Uname: "+emp1.getUname());
					System.out.println("Salary: "+emp1.getSalary());
					System.out.println("Pass: "+emp1.getPass());
					System.out.println("------------------------------------");
					break;
					
				case 5:
					List<Employee> empsss=el.showAll();
					for(Employee ems:empsss)
					{
						System.out.println("ID: "+ems.getId());
						System.out.println("Name: "+ems.getName());
						System.out.println("Uname: "+ems.getUname());
						System.out.println("Salary: "+ems.getSalary());
						System.out.println("Pass: "+ems.getPass());
						System.out.println("------------------------------------");
						
					}
					break;
				case 6:
					List<Employee> empss=el.showAllOrderBySal();
					for(Employee ems:empss)
					{
						System.out.println("ID: "+ems.getId());
						System.out.println("Name: "+ems.getName());
						System.out.println("Uname: "+ems.getUname());
						System.out.println("Salary: "+ems.getSalary());
						System.out.println("Pass: "+ems.getPass());
						System.out.println("------------------------------------");
						
					}
					break;
				case 7:
					System.exit(0);
				}
			}
		}
		else
		{
			System.out.println("You have only "+(3-i)+" chances left!");
			if(3-i==0)
				System.out.println("Try after 30min...");
		}
		
		}
	}

}

package logic;
import java.util.*;
import connector.Connector;
import java.sql.*;
import entity.Employee;
public class EmployeeLogic {
static Connection con;
PreparedStatement ps;
ResultSet rs;

public boolean addEmp(Employee emp)
{
	con=Connector.getCon();
	boolean b=false;
	try
	{
		ps=con.prepareStatement("insert into Employee values(?,?,?,?,?)");
		ps.setInt(1, emp.getId());
		ps.setString(2, emp.getName());
		ps.setString(3, emp.getUname());
		ps.setDouble(4, emp.getSalary());
		ps.setString(5, emp.getPass());
		int r=ps.executeUpdate();
		if(r==1)
			b=true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	return b;
}



public boolean updateEmp(Employee emp)
{
	con=Connector.getCon();
	boolean b=false;
	try
	{
		ps=con.prepareStatement("update Employee set Salary=? where Uname=?");
		ps.setDouble(1, emp.getSalary());
		ps.setString(2, emp.getUname());
		
		
		int r=ps.executeUpdate();
		if(r==1)
			b=true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	return b;
}


public boolean deleteEmp(String x)
{
	con=Connector.getCon();
	boolean b=false;
	try
	{
		ps=con.prepareStatement("delete from Employee where Uname=?");
		
		ps.setString(1, x);
		
		
		int r=ps.executeUpdate();
		if(r==1)
			b=true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	return b;
}


public Employee showByUname(String x)
{
	con=Connector.getCon();
	Employee emp=new Employee();
	try
	{
		ps=con.prepareStatement("select * from Employee where Uname=?");
		ps.setString(1, x);
		rs=ps.executeQuery();
		while(rs.next())
		{
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setUname(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			emp.setPass(rs.getString(5));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	return emp;
}


public List<Employee> showAll()
{
	List<Employee> emps=new ArrayList<Employee>();
	Employee emp;
	con=Connector.getCon();
	try
	{
	ps=con.prepareStatement("select * from Employee");
	rs=ps.executeQuery();
	while(rs.next())
	{
		emp=new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setUname(rs.getString(3));
		emp.setSalary(rs.getDouble(4));
		emp.setPass(rs.getString(5));
		emps.add(emp);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	return emps;
}


public List<Employee> showAllOrderBySal()
{
	List<Employee> emps=new ArrayList<Employee>();
	Employee emp;
	con=Connector.getCon();
	try
	{
	ps=con.prepareStatement("select * from Employee order by Salary desc");
	rs=ps.executeQuery();
	while(rs.next())
	{
		emp=new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setUname(rs.getString(3));
		emp.setSalary(rs.getDouble(4));
		emp.setPass(rs.getString(5));
		emps.add(emp);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	return emps;
}


public boolean login(String Uname,String Pass)
{
	con=Connector.getCon();
	Employee emp=new Employee();
	boolean b=false;
	try
	{
		ps=con.prepareStatement("select * from Employee");
		
		rs=ps.executeQuery();
		while(rs.next())
		{
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setUname(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			emp.setPass(rs.getString(5));
			if(Uname.equalsIgnoreCase(emp.getUname())&& Pass.equalsIgnoreCase(emp.getPass()))
					b=true;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	return b;
}


}
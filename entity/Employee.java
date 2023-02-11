package entity;

public class Employee {
	private int Id;
	private String Name;
	private String Uname;
	private double Salary;
	private String Pass;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		this.Uname = uname;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		this.Salary = salary;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		this.Pass = pass;
	}
}

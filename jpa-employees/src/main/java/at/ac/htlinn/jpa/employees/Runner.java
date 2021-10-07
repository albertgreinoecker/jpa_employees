package at.ac.htlinn.jpa.employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws ParseException {
		DBManager db = new DBManager();
		
		List<Employee> employees = db.getEmployees();
		System.out.println("List all Employees:");
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		
		Employee e = db.getEmployee(10001);
		System.out.println("Get a single employee");
		System.out.println(e);
		
		System.out.println();
		List<Salary> sals = e.getSalaries();
		System.out.println("All salary entries for this employee:");
		for (Salary s : sals)
		{
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("This is the actual salary:");
		Salary actual = db.getActualSalary(e);
		System.out.println(actual);
		
		System.out.println();
		System.out.println("What is the title of the employee:");
		for (Title t : e.getTitles())
		{
			System.out.printf("%s (%s)\n", t.getTitle(), t.getFromDate());
		}
		
		Date d = new SimpleDateFormat( "yyyyMMdd" ).parse( "19870626" );
		Salary s = db.getSalary(e, d); 
		System.out.println();
		System.out.printf("the salary earned until %s\n",d);
		System.out.println(s);
		
		System.out.println();	
		System.out.println("Get Departments of the Employee:");
		for (DeptEmp de : e.getDeptEmp())
		{
			System.out.println(de.getDepartment().getName());
		}		

		System.out.println();
		System.out.println("Who is the boss of the employee");		
		for (DeptEmp de : e.getDeptEmp())
		{
			Department dept = de.getDepartment();
			for (DeptManager dm : dept.getDeptManager())
			{
				Employee boss = dm.getEmployee();
				Date from = dm.getFromDate();
				System.out.printf("%s %s (%s)\n", boss.getFirstname(), boss.getLastname(), from);
			}
		}	

		System.out.println("Now we change the employee");
		Employee e2 = db.getEmployee(10004);
		System.out.println(e2);
		e2.setLastname("ein neuer Name");
		db.changeEmployee(e2);
		
		System.out.println();
		System.out.println("Objects can also be removed");
		db.removeEmployee(10003);
		
		db.close();
	}
}

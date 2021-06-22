package at.ac.htlinn.jpa.employees;

public class Runner {
	public static void main(String[] args) {
		DBManager db = new DBManager();
		
//		List<Employee> employees = db.getEmployees();
//		System.out.println("Liste von Studenten:");
//		for (Employee student : employees) {
//			System.out.println(student);
//		}
//		
//		System.out.println();
//		System.out.println();
//		
//		Employee e = db.getEmployee(10001);
//		System.out.println(e);
//		
//		e.setEmp_no(10000);
//		System.out.println(e);
		
		Employee e = db.getEmployee(10001);
		System.out.println(e);
//		for (Salary s : e.getSalaries())
//		{
//			System.out.println(s);
//		}
		
		for (DeptEmp de : e.getDeptEmp())
		{
			System.out.println(de);
			System.out.println(de.getDepartment());
		}
		
		for (DeptManager de : e.getDeptManager())
		{
			System.out.println(de.getEmployee());
			System.out.println(de.getDepartment());
		}
		
		Department d = db.getDepartment("d005");
		for (DeptManager dm : d.getDeptManager())
		{
			Employee emp = dm.getEmployee();
			System.out.println(emp);
		}
		
		db.close();
	}
}

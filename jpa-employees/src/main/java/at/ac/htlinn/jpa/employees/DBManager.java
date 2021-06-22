package at.ac.htlinn.jpa.employees;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DBManager {
	//Ist ein wenig wie die Connection/Connection Pool bei JDBC
	private EntityManagerFactory emf;

	public DBManager() {
		emf = Persistence.createEntityManagerFactory("employees");
		
	}

	public Department getDepartment(String persNr)
	{
		EntityManager em = emf.createEntityManager();
		Department professor = em.find(Department.class, persNr);
		em.close();
		return professor;
	}
	
	
	public List<Employee> getEmployees() {
		EntityManager em = emf.createEntityManager();
		// JPQL - Java Persistence Query Language - nicht SQL
		String sql = "SELECT e From Employee e";
		Query query = em.createQuery(sql, Employee.class);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Employee> employee = query.getResultList();
		em.close();
		return employee;
	}
	
	public List<Salary> getSalaries(){
		EntityManager em = emf.createEntityManager();
		// JPQL - Java Persistence Query Language - nicht SQL
		String sql = "SELECT s From Salary s";
		Query query = em.createQuery(sql, Employee.class);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Salary> salaries = query.getResultList();
		em.close();
		return salaries;
	}
	
	public Employee getEmployee(long empno) {
		EntityManager em = emf.createEntityManager();
		// JPQL - Java Persistence Query Language - nicht SQL
		String sql = "SELECT e FROM Employee e  WHERE e.emp_no = :empNo";
		Query query = em.createQuery(sql, Employee.class);
		query.setParameter("empNo", empno);
		Employee employee = null;
		try
		{
			employee = (Employee)query.getSingleResult();
		} catch (NoResultException e)
		{
			e.printStackTrace();
		}
		em.close();
		return employee;
	}
	
	public Salary getSalary(long empno) {
		EntityManager em = emf.createEntityManager();
		// JPQL - Java Persistence Query Language - nicht SQL
		String sql = "SELECT s FROM Salary s WHERE s.emp_no = :empNo";
		Query query = em.createQuery(sql, Employee.class);
		query.setParameter("empNo", empno);
		Salary salary = null;
		try
		{
			salary = (Salary)query.getSingleResult();
		} catch (NoResultException e)
		{
			e.printStackTrace();
		}
		em.close();
		return salary;
	}
	
	public void loescheEmployee(int matrNr)
	{
		EntityManager em = emf.createEntityManager(); 
		Employee employee = getEmployee(matrNr); 
		em.remove(employee);
		em.close();
	}
	
	public void aendereEmployee(Employee s)
	{
		EntityManager em = emf.createEntityManager(); 	
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public void close() {
		emf.close();
	}
}

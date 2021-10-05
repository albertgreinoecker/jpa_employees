package at.ac.htlinn.jpa.employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DBManager {
	// Ist ein wenig wie die Connection/Connection Pool bei JDBC
	private EntityManagerFactory emf;

	public DBManager() {
		emf = Persistence.createEntityManagerFactory("employees");

	}

	public Department getDepartment(String deptNo) {
		EntityManager em = emf.createEntityManager();
		Department professor = em.find(Department.class, deptNo);
		em.close();
		return professor;
	}

	/**
	 * List all employees (limit set to 20)
	 */
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

	/**
	 * Get all Salary entries. Does not make sense, just for demonstration purposes
	 */
	public List<Salary> getSalaries() {
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT s From Salary s";
		Query query = em.createQuery(sql, Employee.class);
		query.setMaxResults(20);
		@SuppressWarnings("unchecked")
		List<Salary> salaries = query.getResultList();
		em.close();
		return salaries;
	}

	public Title getTitle(long empno) {
		EntityManager em = emf.createEntityManager();
		Title title = em.find(Title.class, empno);
		em.close();
		return title;
	}

	public Employee getEmployee(int empno) {
		EntityManager em = emf.createEntityManager();
		Employee employee = em.find(Employee.class, empno);
		em.close();
		return employee;
	}

	public Salary getActualSalary(long empno) {
		Date d9999 = null;
		try {
			d9999 = new SimpleDateFormat("yyyyMMdd").parse("99990101");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return getSalary(empno, d9999);
	}

	public Salary getSalary(long empno, Date d) {

		EntityManager em = emf.createEntityManager();
		String sql = "SELECT s FROM Salary s WHERE s.emp_no = :empNo AND s.toDate = :date";
		Query query = em.createQuery(sql, Employee.class);
		query.setParameter("empNo", empno);
		query.setParameter("date", d);
		Salary salary = null;
		try {
			salary = (Salary) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		em.close();
		return salary;
	}

	public void removeEmployee(int persNr) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee employee = getEmployee(persNr);
		if (employee != null) {
			employee = em.merge(employee);
			em.remove(employee);
			em.getTransaction().commit();
		}
		em.close();
	}

	public void changeEmployee(Employee s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
		em.close();
	}

	/* Get all salary entries of an employee */
	@SuppressWarnings("unchecked")
	public List<Salary> getSalary(int empNo) {

		EntityManager em = emf.createEntityManager();
		String sql = "SELECT s FROM Salary s WHERE s.empNo = :empNo";
		Query query = em.createQuery(sql, Salary.class);
		query.setParameter("empNo", empNo);
		List<Salary> salary = null;
		try {
			salary = (List<Salary>) query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		em.close();
		return salary;

	}

	public void close() {
		emf.close();
	}
}

package at.ac.htlinn.jpa.employees;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salaries")
public class Salary {

	@Id
	private int emp_no;
	private int salary;
	@Id
	@Column(name = "from_date")
	private Date fromDate;
	@Column(name = "to_date")
	private Date toDate;

	@ManyToOne
	@JoinColumn(name = "emp_no", nullable = false, insertable=false, updatable=false)
	private Employee employee;

	public Salary() {
	}

	public Salary(int emp_no, int salary, Date fromDate, Date toDate, Employee employee) {
		super();
		this.emp_no = emp_no;
		this.salary = salary;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.employee = employee;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [empNo=" + emp_no + ", salary=" + salary + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", employee=" + employee + "]";
	}
}
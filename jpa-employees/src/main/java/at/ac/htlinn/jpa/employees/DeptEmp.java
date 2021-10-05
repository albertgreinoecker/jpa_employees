package at.ac.htlinn.jpa.employees;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "dept_emp")
public class DeptEmp {
	@Id
	@JoinColumn(name="emp_no")
	private Employee employee;
	
	@Id
	@JoinColumn(name="dept_no")
	private Department department;
	
	@Column(name="from_date")
	private Date fromDate;
	@Column(name="to_date")
	private Date toDate;
	
	public DeptEmp() {
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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




	@Override
	public String toString() {
		return "DeptEmp [employee=" + employee + ", department=" + department + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}

	
	
}

package at.ac.htlinn.jpa.employees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "titles")
public class Title {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long emp_no;
	
	
	@Column(name = "from_date")
	private String fromDate;
	@Column(name = "to_date")
	private String toDate;

	@ManyToOne
	@JoinColumn(name = "emp_no", nullable = false, insertable=false, updatable=false)
	private Employee employee;
	
	public Title() {
	}

	public long getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(long emp_no) {
		this.emp_no = emp_no;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
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
		return "Title [emp_no=" + emp_no + ", fromDate=" + fromDate + ", toDate=" + toDate + ", employee=" + employee
				+ "]";
	}
	
	
}

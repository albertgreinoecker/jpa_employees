package at.ac.htlinn.jpa.employees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "titles")
public class Title {

	@Id
	@Column(name = "from_date")
	private String fromDate;
	@Column(name = "to_date")
	private String toDate;

	@Id
	@ManyToOne
	@JoinColumn(name = "emp_no")
	private Employee employee;

	private String title;
	
	public Title() {
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

	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Title [fromDate=" + fromDate + ", toDate=" + toDate + ", employee=" + employee + ", title=" + title
				+ "]";
	}

}

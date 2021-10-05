package at.ac.htlinn.jpa.employees;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_no;
	private String birth_date;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	private char gender;
	private String hire_date;
	private int pw;
	
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinColumn(name="emp_no", nullable=false)
	private List<Salary> salaries;
	
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinColumn(name="emp_no", nullable=false)
	private List<Title> titles;
	
	@OneToMany(mappedBy = "employee",cascade=CascadeType.REMOVE)
	private List<DeptEmp> deptEmp;

	@OneToMany(mappedBy = "employee",cascade=CascadeType.REMOVE)
	private List<DeptManager> deptManager;
	
	public Employee() {
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	
	
	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	
	
	
	public List<DeptEmp> getDeptEmp() {
		return deptEmp;
	}

	public void setDeptEmp(List<DeptEmp> deptEmp) {
		this.deptEmp = deptEmp;
	}
	
	

	public List<DeptManager> getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(List<DeptManager> deptManager) {
		this.deptManager = deptManager;
	}

	@Override
	public String toString() {
		return "Employees [emp_no=" + emp_no + ", birth_date=" + birth_date + ", firstname=" + firstname + ", lastname="
				+ lastname + ", gender=" + gender + ", hire_date=" + hire_date + ", pw=" + pw + "]";
	}
	
}

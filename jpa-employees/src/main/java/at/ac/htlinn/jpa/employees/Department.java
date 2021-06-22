package at.ac.htlinn.jpa.employees;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_no")
	private String deptNo;
	@Column(name = "dept_name")
	private String name;

	@OneToMany(mappedBy = "department")
	private List<DeptEmp> deptEmp;
	
	@OneToMany(mappedBy = "department")
	private List<DeptManager> deptManager;
	
	public Department() {
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Department [deptNo=" + deptNo + ", name=" + name + "]";
	}

}

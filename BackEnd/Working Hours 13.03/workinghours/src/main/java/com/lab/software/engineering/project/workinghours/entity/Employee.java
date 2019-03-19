package com.lab.software.engineering.project.workinghours.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EMPLOYEE_EMPLOYEEID_GENERATOR", sequenceName = "EMPLOYEE_EMPLOYEEID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_EMPLOYEEID_GENERATOR")
	private long employeeid;

	private boolean active;

	private String email;

	private String firstname;

	@Temporal(TemporalType.DATE)
	private Date hiredate;

	private String lastname;

	private String password;

	private BigDecimal salary;

	private String username;
	@Transient
	private double averageWork;
	
	@Transient
	private double overtime;

	
	// bi-directional many-to-one association to Job
	@ManyToOne
	@JsonIgnoreProperties("employees")
	@JoinColumn(name = "JOBID")
	private Job job;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employee_roles", joinColumns = @JoinColumn(name = "employee_employeeid"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private Set<Role> roles = new HashSet<>();

//////bi-directional many-to-one association to Holidayperemployee
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties("employee")
	private List<Holidayperemployee> holidayperemployees;
////
//////bi-directional many-to-one association to Jobhistory
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties("employee")
	private List<Jobhistory> jobhistories;
//
//////bi-directional many-to-one association to Payment
//@OneToMany(mappedBy="employee")
//@JsonIgnoreProperties("employee")
//private List<Payment> payments;
////
//////bi-directional many-to-one association to Vacation
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties("employee")
	private List<Vacation> vacations;
////
//////bi-directional many-to-one association to Workingday
	@OneToMany(mappedBy = "employee")
	@JsonIgnoreProperties("employee")
	private List<Workingday> workingdays;

	

	public Employee() {
		
	}
	public Employee(String email, String firstname, String lastname, String password, String username) {
		
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}
	public long getEmployeeid() {
		return this.employeeid;
	}
	public double getOvertime() {
		return overtime;
	}

	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}

	public double getAverageWork() {
		int numberOfDays=workingdays.size();
		double sum=0;
		for (Workingday workingday : workingdays) {
			sum+=workingday.getWorkDuration();
		}
		this.averageWork=sum/numberOfDays;
		return averageWork;
	}

	public void setAverageWork() {
		int numberOfDays=workingdays.size();
		int sum=0;
		for (Workingday workingday : workingdays) {
			sum+=workingday.getWorkDuration();
		}
		 this.averageWork=sum/numberOfDays;
	
	}
	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Holidayperemployee> getHolidayperemployees() {
		return this.holidayperemployees;
	}

//	public void setHolidayperemployees(List<Holidayperemployee> holidayperemployees) {
//		this.holidayperemployees = holidayperemployees;
//	}

//	public Holidayperemployee addHolidayperemployee(Holidayperemployee holidayperemployee) {
//		getHolidayperemployees().add(holidayperemployee);
//		holidayperemployee.setEmployee(this);
//
//		return holidayperemployee;
//	}
//
//	public Holidayperemployee removeHolidayperemployee(Holidayperemployee holidayperemployee) {
//		getHolidayperemployees().remove(holidayperemployee);
//		holidayperemployee.setEmployee(null);
//
//		return holidayperemployee;
//	}

	public List<Jobhistory> getJobhistories() {
		return this.jobhistories;
	}

	public void setJobhistories(List<Jobhistory> jobhistories) {
		this.jobhistories = jobhistories;
	}

	public Jobhistory addJobhistory(Jobhistory jobhistory) {
		getJobhistories().add(jobhistory);
		jobhistory.setEmployee(this);

		return jobhistory;
	}

	public Jobhistory removeJobhistory(Jobhistory jobhistory) {
		getJobhistories().remove(jobhistory);
		jobhistory.setEmployee(null);

		return jobhistory;
	}

//	public List<Payment> getPayments() {
//		return this.payments;
//	}
//
//	public void setPayments(List<Payment> payments) {
//		this.payments = payments;
//	}
//
//	public Payment addPayment(Payment payment) {
//		getPayments().add(payment);
//		payment.setEmployee(this);
//
//		return payment;
//	}
//
//	public Payment removePayment(Payment payment) {
//		getPayments().remove(payment);
//		payment.setEmployee(null);
//
//		return payment;
//	}

	public List<Vacation> getVacations() {
		return this.vacations;
	}

	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}

	public Vacation addVacation(Vacation vacation) {
		getVacations().add(vacation);
		vacation.setEmployee(this);

		return vacation;
	}

	public Vacation removeVacation(Vacation vacation) {
		getVacations().remove(vacation);
		vacation.setEmployee(null);

		return vacation;
	}

	public List<Workingday> getWorkingdays() {
		return this.workingdays;
	}

	public void setWorkingdays(List<Workingday> workingdays) {
		this.workingdays = workingdays;
	}

	public Workingday addWorkingday(Workingday workingday) {
		getWorkingdays().add(workingday);
		workingday.setEmployee(this);

		return workingday;
	}

	public Workingday removeWorkingday(Workingday workingday) {
		getWorkingdays().remove(workingday);
		workingday.setEmployee(null);

		return workingday;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", active=" + active + ", email=" + email + ", firstname="
				+ firstname + ", hiredate=" + hiredate + ", lastname=" + lastname + ", password=" + password
				+ ", salary=" + salary + ", username=" + username + ", job=" + job + ", jobhistories=" + jobhistories
				+ ", workingdays=" + workingdays + "]";
	}

}
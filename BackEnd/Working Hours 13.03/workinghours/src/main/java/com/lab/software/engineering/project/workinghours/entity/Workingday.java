package com.lab.software.engineering.project.workinghours.entity;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the WORKINGDAY database table.
 * 
 */
@Entity
@Table(name="workingday")
public class Workingday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKINGDAY_WORKINGDAYID_GENERATOR", sequenceName="WORKINGDAY_WORKINGDAYID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKINGDAY_WORKINGDAYID_GENERATOR")
	private long workingdayid;
//
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime checkin;

//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime checkout;
	@Transient
	private long workDuration;
	//bi-directional many-to-one association to Break
	@OneToMany(mappedBy="workingday")
	@JsonIgnoreProperties("workingday")
	private List<Break> breaks;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JsonIgnoreProperties("workingdays")
	@JoinColumn(name="EMPLOYEEID")
	private Employee employee;

	//bi-directional many-to-one association to Weekday
	@ManyToOne
	@JsonIgnoreProperties("workingdays")
	@JoinColumn(name="WEEKDAYID")
	private Weekday weekday;

	public Workingday() {
	}

	public long getWorkingdayid() {
		return this.workingdayid;
	}

	public void setWorkingdayid(long workingdayid) {
		this.workingdayid = workingdayid;
	}

	public LocalDateTime getCheckin() {
		return this.checkin;
	}

	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}

	public LocalDateTime getCheckout() {
		return this.checkout;
	}

	public void setCheckout(LocalDateTime checkout) {
		this.checkout = checkout;
	}

	public List<Break> getBreaks() {
		return this.breaks;
	}
	public long getWorkDuration() {
		Duration duration = Duration.between(this.checkin, this.checkout);
		System.out.println(duration);
		long diff = Math.abs(duration.toMinutes());
		this.workDuration = diff;
		return this.workDuration;
	}

	public void setWorkDuration() {
		Duration duration = Duration.between(this.checkin, this.checkout);
		System.out.println(duration);
		long diff = Math.abs(duration.toMinutes());
		this.workDuration = diff;
	}
	public void setBreaks(List<Break> breaks) {
		this.breaks = breaks;
	}

	public Break addBreak(Break br) {
		getBreaks().add(br);
		br.setWorkingday(this);

		return br;
	}

	public Break removeBreak(Break br) {
		getBreaks().remove(br);
		br.setWorkingday(null);

		return br;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Weekday getWeekday() {
		return this.weekday;
	}

	public void setWeekday(Weekday weekday) {
		this.weekday = weekday;
	}

	@Override
	public String toString() {
		return "Workingday [workingdayid=" + workingdayid + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", breaks=" + breaks + ", employee=" + employee + ", weekday=" + weekday + "]";
	}
	

}
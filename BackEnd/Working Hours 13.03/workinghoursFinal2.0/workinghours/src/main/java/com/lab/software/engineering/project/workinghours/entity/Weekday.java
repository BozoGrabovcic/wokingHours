package com.lab.software.engineering.project.workinghours.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the WEEKDAY database table.
 * 
 */
@Entity
@Table(name="weekday")
public class Weekday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WEEKDAY_WEEKDAYID_GENERATOR", sequenceName="WEEKDAY_WEEKDAYID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WEEKDAY_WEEKDAYID_GENERATOR")
	private long weekdayid;

	private String name;

//	//bi-directional many-to-one association to Holiday
//	@OneToMany(mappedBy="weekday")
//	@JsonIgnoreProperties("weekday")
//	private List<Holiday> holidays;
////
////	//bi-directional many-to-one association to Holidayperemployee
//	@OneToMany(mappedBy="weekday")
//	@JsonIgnoreProperties("weekday")
//	private List<Holidayperemployee> holidayperemployees;

	//bi-directional many-to-one association to Workingday
//	@OneToMany(mappedBy="weekday")
//	@JsonIgnoreProperties("weekday")
//	private List<Workingday> workingdays;

	public Weekday() {
	}

	public long getWeekdayid() {
		return this.weekdayid;
	}

	public void setWeekdayid(long weekdayid) {
		this.weekdayid = weekdayid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Holiday> getHolidays() {
//		return this.holidays;
//	}

//	public void setHolidays(List<Holiday> holidays) {
//		this.holidays = holidays;
//	}
//
//	public Holiday addHoliday(Holiday holiday) {
//		getHolidays().add(holiday);
//		holiday.setWeekday(this);
//
//		return holiday;
//	}
//
//	public Holiday removeHoliday(Holiday holiday) {
//		getHolidays().remove(holiday);
//		holiday.setWeekday(null);
//
//		return holiday;
//	}

//	public List<Holidayperemployee> getHolidayperemployees() {
//		return this.holidayperemployees;
//	}
//
//	public void setHolidayperemployees(List<Holidayperemployee> holidayperemployees) {
//		this.holidayperemployees = holidayperemployees;
//	}
//
//	public Holidayperemployee addHolidayperemployee(Holidayperemployee holidayperemployee) {
//		getHolidayperemployees().add(holidayperemployee);
//		holidayperemployee.setWeekday(this);
//
//		return holidayperemployee;
//	}
//
//	public Holidayperemployee removeHolidayperemployee(Holidayperemployee holidayperemployee) {
//		getHolidayperemployees().remove(holidayperemployee);
//		holidayperemployee.setWeekday(null);
//
//		return holidayperemployee;
//	}

//	public List<Workingday> getWorkingdays() {
//		return this.workingdays;
//	}
//
//	public void setWorkingdays(List<Workingday> workingdays) {
//		this.workingdays = workingdays;
//	}
//
//	public Workingday addWorkingday(Workingday workingday) {
//		getWorkingdays().add(workingday);
//		workingday.setWeekday(this);
//
//		return workingday;
//	}
//
//	public Workingday removeWorkingday(Workingday workingday) {
//		getWorkingdays().remove(workingday);
//		workingday.setWeekday(null);
//
//		return workingday;
//	}

}
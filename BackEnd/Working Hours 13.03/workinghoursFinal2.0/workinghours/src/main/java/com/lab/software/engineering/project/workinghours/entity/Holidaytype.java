package com.lab.software.engineering.project.workinghours.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the HOLIDAYTYPE database table.
 * 
 */
@Entity
@Table(name="holidaytype")
public class Holidaytype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HOLIDAYTYPE_HOLIDAYTYPEID_GENERATOR", sequenceName="HOLIDAYTYPE_HOLIDAYTYPEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOLIDAYTYPE_HOLIDAYTYPEID_GENERATOR")
	private long holidaytypeid;
	@JoinColumn(name="NAME")
	private String name;

	//bi-directional many-to-one association to Holiday
//	@OneToMany(mappedBy="holidaytype")
//	@JsonIgnoreProperties("holidaytype")
//	private List<Holiday> holidays;

	//bi-directional many-to-one association to Holidayperemployee
//	@OneToMany(mappedBy="holidaytype")
//	@JsonIgnoreProperties("holidaytype")
//	private List<Holidayperemployee> holidayperemployees;

	public Holidaytype() {
	}

	public long getHolidaytypeid() {
		return this.holidaytypeid;
	}

	public void setHolidaytypeid(long holidaytypeid) {
		this.holidaytypeid = holidaytypeid;
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
//		holiday.setHolidaytype(this);
//
//		return holiday;
//	}
//
//	public Holiday removeHoliday(Holiday holiday) {
//		getHolidays().remove(holiday);
//		holiday.setHolidaytype(null);
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
//		holidayperemployee.setHolidaytype(this);
//
//		return holidayperemployee;
//	}
//
//	public Holidayperemployee removeHolidayperemployee(Holidayperemployee holidayperemployee) {
//		getHolidayperemployees().remove(holidayperemployee);
//		holidayperemployee.setHolidaytype(null);
//
//		return holidayperemployee;
//	}

}
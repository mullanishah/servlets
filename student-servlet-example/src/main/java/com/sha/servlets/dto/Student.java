package com.sha.servlets.dto;

import java.util.Date;

public class Student {
	private String rollNum;
	private String fullName;
	private String course;
	private String semester;
	private String address;
	private Date bdate;
	private long contactNum;
	private long emergencyContact;
	private String registrationNum;
	
	public Student() {
		
	}

	public Student(String rollNum, String fullName, String course, String semester, String address, Date bdate,
			long contactNum, long emergencyContact, String registrationNum) {
		super();
		this.rollNum = rollNum;
		this.fullName = fullName;
		this.course = course;
		this.semester = semester;
		this.address = address;
		this.bdate = bdate;
		this.contactNum = contactNum;
		this.emergencyContact = emergencyContact;
		this.registrationNum = registrationNum;
	}

	public String getRollNum() {
		return rollNum;
	}

	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public long getContactNum() {
		return contactNum;
	}

	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}

	public long getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(long emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", fullName=" + fullName + ", course=" + course + ", semester="
				+ semester + ", address=" + address + ", bdate=" + bdate + ", contactNum=" + contactNum
				+ ", emergencyContact=" + emergencyContact + ", registrationNum=" + registrationNum + "]";
	}
}

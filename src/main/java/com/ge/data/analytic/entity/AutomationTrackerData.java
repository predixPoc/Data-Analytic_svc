package com.ge.data.analytic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the AUTOMATION_TRACKER database table.
 * 
 */

@Entity
@Table(name="AUTOMATION_TRACKER")
@NamedQuery(name="AutomationTrackerData.findAll", query="SELECT a FROM AutomationTrackerData a")
public class AutomationTrackerData {
	@Id
	@SequenceGenerator(name="AUTOMATION_TRACKER_AUTOMATIONID_GENERATOR", sequenceName="AUTOMATION_SEQ1")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTOMATION_TRACKER_AUTOMATIONID_GENERATOR")
	@Column(name="AUTOMATION_ID")
	private long automationId;
	
	@Column(name="SERIAL_NO")
	private int serialNum;
	
	@Column(name="BUSINESS_NAME")
	private String businessName;
	
	@Column(name="IBU_NAME")
	private String ibuName;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@Column(name="COMPONENET_NAME")
	private String componenetName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TECHNOLOGY")
	private String technology;
	
	@Column(name="VERSION")
	private String version;
	
	@Column(name="EFFORT_SAVING")
	private String effortSaving;
	
	@Column(name="SAVING_TO_GE")
	private String savingToGE;
	
	@Column(name="RESUED")
	private String reused;
	
	@Column(name="SUMMARY")
	private String summary;
	
	@Column(name="UPLOADED_FILE_NAME")
	private String uploadedFileName;

	public String getUploadedFileName() {
		return uploadedFileName;
	}

	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	public long getAutomationId() {
		return automationId;
	}

	public void setAutomationId(long automationId) {
		this.automationId = automationId;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getIbuName() {
		return ibuName;
	}

	public void setIbuName(String ibuName) {
		this.ibuName = ibuName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getComponenetName() {
		return componenetName;
	}

	public void setComponenetName(String componenetName) {
		this.componenetName = componenetName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEffortSaving() {
		return effortSaving;
	}

	public void setEffortSaving(String effortSaving) {
		this.effortSaving = effortSaving;
	}

	public String getSavingToGE() {
		return savingToGE;
	}

	public void setSavingToGE(String savingToGE) {
		this.savingToGE = savingToGE;
	}

	public String getReused() {
		return reused;
	}

	public void setReused(String reused) {
		this.reused = reused;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	

}

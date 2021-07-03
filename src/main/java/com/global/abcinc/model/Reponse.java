package com.global.abcinc.model;

public class Reponse {

	private String name;
	private int records_processed;
	private int  records_failed;
	private String records_status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecords_processed() {
		return records_processed;
	}
	public void setRecords_processed(int records_processed) {
		this.records_processed = records_processed;
	}
	public int getRecords_failed() {
		return records_failed;
	}
	public void setRecords_failed(int records_failed) {
		this.records_failed = records_failed;
	}
	public String getRecords_status() {
		return records_status;
	}
	public void setRecords_status(String records_status) {
		this.records_status = records_status;
	}

	
}

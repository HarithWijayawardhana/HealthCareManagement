package s1142_5.appointment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TimeSlot {
	
	private String timeSlotID ;
	private int docID;
	private String startTime ;
	private String endTime;
	private int wardID;
	private int patientLinit;
	private String date;
	public String getTimeSlotID() {
		return timeSlotID;
	}
	public void setTimeSlotID(String timeSlotID) {
		this.timeSlotID = timeSlotID;
	}
	public int getDocID() {
		return docID;
	}
	public void setDocID(int docID) {
		this.docID = docID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getWardID() {
		return wardID;
	}
	public void setWardID(int wardID) {
		this.wardID = wardID;
	}
	public int getPatientLinit() {
		return patientLinit;
	}
	public void setPatientLinit(int patientLinit) {
		this.patientLinit = patientLinit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	public TimeSlot() {
		super();
	}
	
	public TimeSlot(String timeSlotID, int docID, String startTime, String endTime, int wardID, int patientLinit,
			String date) {
		super();
		this.timeSlotID = timeSlotID;
		this.docID = docID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.wardID = wardID;
		this.patientLinit = patientLinit;
		this.date = date;
	}
	public TimeSlot(int docID, String startTime, String endTime, int wardID, int patientLinit, String date) {
		super();
		this.docID = docID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.wardID = wardID;
		this.patientLinit = patientLinit;
		this.date = date;
	}
	
	
	
	
	

}

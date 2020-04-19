package s1142_5.appointment.model;

public class Apointment {
	
	
	private int number;
	private int timeSlot;
	private int patientID;
	
	
	
	public Apointment() {
		super();
	}

	public Apointment(int number, int timeSlot, int patientID) {
		super();
		this.number = number;
		this.timeSlot = timeSlot;
		this.patientID = patientID;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	
	
	
	

}

package bean;

public class docBean {

		
		private int docId;
		private String FirstName;
		private String LastName;
		private String Specialization;
		private String Gender;
		private String Email;
		private String ContactNo;
		private String StandardFees;
		private String Password;
		
		public docBean() {
			super();
		}

		public docBean(int docId, String firstName, String lastName, String specialization, String gender, String email,
				String contactNo, String standardFees, String password) {
			super();
			this.docId = docId;
			FirstName = firstName;
			LastName = lastName;
			Specialization = specialization;
			Gender = gender;
			Email = email;
			ContactNo = contactNo;
			StandardFees = standardFees;
			Password = password;
		}

		public int getDocId() {
			return docId;
		}

		public void setDocId(int docId) {
			this.docId = docId;
		}

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public String getSpecialization() {
			return Specialization;
		}

		public void setSpecialization(String specialization) {
			Specialization = specialization;
		}

		public String getGender() {
			return Gender;
		}

		public void setGender(String gender) {
			Gender = gender;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getContactNo() {
			return ContactNo;
		}

		public void setContactNo(String contactNo) {
			ContactNo = contactNo;
		}

		public String getStandardFees() {
			return StandardFees;
		}

		public void setStandardFees(String standardFees) {
			StandardFees = standardFees;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}
			

}

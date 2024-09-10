package vo;


public class UserVO {


	private int studentId;
	private String studentName;
	private int studentAge;
	private String departmentId;
	private String addressId;
	private String addressPostalCode;
	private String addressLine1;
	private String addressLine2;
	private String departmentName;
	
	public UserVO() {;}
	
   public UserVO(int studentId, String studentName, int studentAge, String departmentId, String addressId, String addressPostalCode, String addressLine1, String addressLine2,
	         String departmentName) {
	      this.studentId = studentId;
	      this.studentName = studentName;
	      this.studentAge = studentAge;
	      this.departmentId = departmentId;
	      this.addressId = addressId;
	      this.addressPostalCode = addressPostalCode;
	      this.addressLine1 = addressLine1;
	      this.addressLine2 = addressLine2;
	      this.departmentName = departmentName;
	   }

	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
package Banking_management;

public class User {
	 String acc;
	 String name;
	 String dob;
	 String acc_type;
	 String nationality;
	 String caste;
	 int micr_no;
	 String gender;
	 int mobile;
	 String address;
	 int balance;
	 
	User(String acc, String name, String dob, String acc_type, String nationality, String caste, int micr_no,
			String gender, int mobile, String address, int balance) {
		super();
		this.acc = acc;
		this.name = name;
		this.dob = dob;
		this.acc_type = acc_type;
		this.nationality = nationality;
		this.caste = caste;
		this.micr_no = micr_no;
		this.gender = gender;
		this.mobile = mobile;
		this.address = address;
		this.balance = balance;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public int getMicr_no() {
		return micr_no;
	}
	public void setMicr_no(int micr_no) {
		this.micr_no = micr_no;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [acc=" + acc + ", name=" + name + ", dob=" + dob + ", acc_type=" + acc_type + ", nationality="
				+ nationality + ", caste=" + caste + ", micr_no=" + micr_no + ", gender=" + gender + ", mobile="
				+ mobile + ", address=" + address + ", balance=" + balance + "]";
	}
	

}

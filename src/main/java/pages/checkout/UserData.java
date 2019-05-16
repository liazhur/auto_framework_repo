package pages.checkout;

import java.util.Random;

public class UserData {

	private String firstName = "Iuliia";
	private String lastName = "S";
	private String email = "email" + randomNum() + "@gmail.com";
	private String passw = generateMyPass();
	private String address = "12, Nice Address";
	private String city = "Ottawa";
	private String state = "Colorado";
	private String zip = "12345";
	private String country = "United States";
	private String mobile = "1234567892";
	private String alias = "testAddress";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	private int randomNum() {
		Random rand = new Random();
		int n = rand.nextInt(1000);
		n += 1;
		return n;
	}

	private String generateMyPass() {
		int aNumber = 0;
		aNumber = (int) ((Math.random() * 9000000) + 1000000);
		return String.valueOf(aNumber);
	}
}

package pages.checkout;

import java.util.Random;

public class UserData {

	String firstName = "a";
	String lastName = "d";
	String email = "email" + randomNum() + "aa@gmail.com";
	String passw = generateMyPass();
	String address = "sdfsggbfb";
	String city = "Ottawa";
	String state = "Colorado";
	String zip = "12345";
	String country = "United States";
	String mobile = "1234567892";
	String alias = "testAddress";

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

	public String generateMyPass() {
		int aNumber = 0;
		aNumber = (int) ((Math.random() * 90000) + 10000);
		return String.valueOf(aNumber);
	}
}

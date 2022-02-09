package vcs.lt.exam.accounts;

import java.util.Locale;

public class Bank {
	
	private String name;
	private String address;
	private String bicCode;
	private Locale locale;
	
	public Bank(String locale, String bicCode, String name, String address) {
		this.name = name;
		this.address = address;
		this.bicCode = bicCode;
		this.locale = new Locale("", locale);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getBicCode() {
		return bicCode;
	}

	public Locale getLocale() {
		return locale;
	}

	@Override
	public String toString() {
		String bankNr = bicCode.substring(bicCode.length() - 5, bicCode.length());
		
		return "Bank#" + bankNr + ", " + locale.getDisplayCountry(locale) + ", " + name + ", " + address; 
	}		
	
	

}

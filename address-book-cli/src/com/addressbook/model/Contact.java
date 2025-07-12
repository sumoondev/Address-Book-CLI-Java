package com.addressbook.model;
public class Contact {
    private String firstname;
    private String lastname;
    private long mobile;
    private String address;
    private String email;
    private String github;

    @Override
	public String toString() {
        return "Person [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", mobile=" + mobile + ", email=" + email + ", github=" + github + "]";
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
}

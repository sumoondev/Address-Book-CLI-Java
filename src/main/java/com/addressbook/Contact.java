package com.addressbook;

public class Contact implements Comparable<Contact>{
	private String name;
    private long mobile;
    private String address;
    private String email;
	Contact left;
	Contact right;

	public Contact(String name, long mobile, String address, String email) {
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.left = null;
		this.right = null;
	}

    @Override
	public String toString() {
        return "Person [name=" + name + ", address=" + address + ", mobile=" + mobile + ", email=" + email + "]";
    }

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setMobile(Long mb) {
		this.mobile = mb;
	}

	public Long getMobile() {
		return this.mobile;
	}

	public void setAddress(String add) {
		this.address = add;
	}

	public String getAddress() {
		return this.address;
	}

	public void setEmail(String em) {
		this.email = em;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public int compareTo(Contact c2) {
		return this.name.compareToIgnoreCase(c2.name);
	}

	public int compareTo(String cname) {
		return this.name.compareToIgnoreCase(cname);
	}
}

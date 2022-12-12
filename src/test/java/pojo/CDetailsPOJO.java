package pojo;

import java.util.List;

public class CDetailsPOJO {

	private String name;
	private String lastname;
	private List<Integer> mobiles;
	CAddressPOJO address;
	List<COrgPOJO> org;
	public List<COrgPOJO> getOrg() {
		return org;
	}
	public void setOrg(List<COrgPOJO> org) {
		this.org = org;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Integer> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<Integer> mobiles) {
		this.mobiles = mobiles;
	}
	public CAddressPOJO getAddress() {
		return address;
	}
	public void setAddress(CAddressPOJO address) {
		this.address = address;
	} 
}

package census.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import census.exceptions.LengthExcedeException;
import census.exceptions.WrongInfoException;

public class Member1 extends CensusApplication{
	private String familyid;
	
	private boolean ishead;
	private String memberid;
	private String firstname;
	private String lastname;
	private String gender;
	private Date dob;
	public Member1() {
		super();
	}
	public Member1(String familyid,boolean ishead,String memberid, String firstname, String lastname, String gender, String dob) throws WrongInfoException, ParseException {
		super(familyid);
		this.familyid = familyid;
		this.ishead = ishead;
		this.memberid = memberid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.setDob(dob);
	}
	public void setFamilyid(String familyid) {
		this.familyid = familyid;
	}
	public boolean isIshead() {
		return ishead;
	}
	public void setIshead(boolean ishead) {
		this.ishead = ishead;
	}
	public String getMemberid() {
		return memberid;
	}
	public int getLength() {
		return this.firstname.length();
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) throws WrongInfoException, LengthExcedeException{
		if(firstname==null) throw new WrongInfoException();
		if(firstname.length()>40) throw new LengthExcedeException();
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) throws WrongInfoException, LengthExcedeException {
		if(lastname==null) throw new WrongInfoException();
		if(lastname.length()>40) throw new LengthExcedeException();
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) throws WrongInfoException {
		if(!gender.equals("male") && !gender.equals("female")) throw new WrongInfoException();
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(String dob) throws WrongInfoException, ParseException {
		if(dob==null) throw new WrongInfoException();
		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dob);
		this.dob = date;
	}
	public String getFamilyid() {
		return familyid;
	}
	
	
	
}
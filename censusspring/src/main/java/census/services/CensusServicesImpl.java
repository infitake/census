package census.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import census.entity.Member1;
import census.exceptions.LengthExcedeException;
import census.exceptions.WrongInfoException;

public class CensusServicesImpl implements CensusServices {
	private static List<Member1> memberlist = new ArrayList<Member1>();
	private String pattern = "dd/mm/yyyy";
	private DateFormat dateformat = new SimpleDateFormat(pattern);
	private boolean ispresent=false;
	private Member1 currMember=null;
	@Override
	public boolean addMember(Member1 member) {
		System.out.println("value !!!!");
		this.memberlist.add(member);
		System.out.println("~~~~~~~~~~~~~~~value !!!!");
		return true;
	}

	@Override
	public boolean editMember(Member1 member, String familyid,String memberid) {
		this.memberlist.forEach((mem) -> {
			System.out.println(mem.getFamilyid() + member.getFamilyid() + familyid + mem.getMemberid()+member.getMemberid()+memberid);
			if(mem.getFamilyid().equals(familyid) && mem.getMemberid().equals(member.getMemberid())) {
			isSet(true);
			setCurrMember(mem);
			}
		});
		if(this.ispresent) {
			isSet(false);
			this.memberlist.remove(this.currMember);
			setCurrMember(null);
			addMember(member);
			System.out.print("This is memberlist afer edit"+this.memberlist);
			return true;
		}
		return false;
	}

	@Override
	public List<Member1> getMembers(String familyid) {
		System.out.println("cheking for values");
//		System.out.println("This is the current list"+memberlist);
//		List<Member> resultlist = new ArrayList<Member>();
		System.out.println("New"+memberlist.isEmpty());
		this.memberlist.forEach((mem) -> {
			if(mem.getFamilyid().equals(familyid)) {
				System.out.println("Inside the file"+mem.getFirstname()+mem.getLastname());
//				resultlist.add(mem);
			}
		});
		return this.memberlist;
	}
	
	@Override
	public void printDetails(Member1 member) {
		System.out.println("FamilyId: "+member.getFamilyid());
		System.out.println("MemberId:  "+member.getMemberid());
		System.out.println("FirstName: "+member.getFirstname());
		System.out.println("LastName:  "+member.getLastname());
		System.out.println("Gender:  "+member.getGender());
		System.out.println("DOB: "+member.getDob());
	}

	@Override
	public boolean deleteMember(String familyid,String memberid) {
		this.memberlist.forEach((mem) -> {
			if (mem.getFamilyid().equals(familyid) && mem.getMemberid().equals(memberid)) 
				isSet(true);
				setCurrMember(mem);
		});
		
		if(this.ispresent) {
			isSet(false);
			this.memberlist.remove(this.currMember);
			setCurrMember(null);
			return true;
		}
		return false;
	}
	
	public void isSet(boolean value) {
		this.ispresent = value;
	}
	public void setCurrMember(Member1 mem) {
		this.currMember = mem;
	}

}

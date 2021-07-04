package census.services;

import java.util.List;

import census.entity.Member1;

public interface CensusServices {
	public boolean addMember(Member1 member);
	public boolean editMember(Member1 member,String familyid,String memberid);
	public List<Member1> getMembers(String familyid);
	public boolean deleteMember(String familyid,String memberid);
	public void printDetails(Member1 member);
}

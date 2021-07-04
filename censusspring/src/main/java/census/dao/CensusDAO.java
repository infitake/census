package census.dao;

import java.sql.Statement;
import java.util.List;

import census.entity.Member;
import census.exceptions.AddEntryException;
import census.exceptions.CreateTableException;
import census.exceptions.UpdateEntryException;

public interface CensusDAO {
	public boolean addMember(Member member) throws AddEntryException, CreateTableException;
	public boolean editMember(Member member,String familyid,String memberid) throws UpdateEntryException;
	public boolean deleteMember(String familyid,String memberid);
//	public List<Member> getMembers(String familyid);
	public List<Member> getMembers(String familyid);
	public void printDetails(Member member);
}

package census.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import census.entity.Member;
import census.entity.Member1;
import census.exceptions.AddEntryException;
import census.exceptions.CreateTableException;
import census.exceptions.UpdateEntryException;
import census.utilities.EntityManagerUtility;

public class CensusDaoJpaImpl implements CensusDAO{

	public CensusDaoJpaImpl() {
	}

	@Override
	public boolean addMember(Member member) throws AddEntryException, CreateTableException {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(member);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public boolean editMember(Member member, String familyid, String memberid) throws UpdateEntryException {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		int result = entityManager.createQuery("Update Member set firstname=:firstname  where memberid=:memberid")
				.setParameter("firstname", member.getFirstname())
				.setParameter("memberid",member.getMemberid()).executeUpdate();
		System.out.println(result);
		entityManager.getTransaction().commit();
		entityManager.close(); 
		return false;
	}

	@Override
	public boolean deleteMember(String familyid, String memberid) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Member member = entityManager.find(Member.class, memberid);
		if (member != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(member);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		}
		return false;
	}

	@Override
	public List<Member> getMembers(String familyid) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Member> query = entityManager.createQuery("Select e from Member e", Member.class);
		List<Member> members = query.getResultList();
		entityManager.close();
		return members;
		
	}

	@Override
	public void printDetails(Member member) {
		System.out.println("FamilyId: "+member.getFamilyid());
		System.out.println("MemberId:  "+member.getMemberid());
		System.out.println("FirstName: "+member.getFirstname());
		System.out.println("LastName:  "+member.getLastname());
		System.out.println("Gender:  "+member.getGender());
		System.out.println("DOB: "+member.getDob().toString());
		
	}

}

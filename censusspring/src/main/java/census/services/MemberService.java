package census.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import census.entity.Member;
import census.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberrepository;

	public List<Member> findAllMembers() {
		// TODO Auto-generated method stub
		
		return memberrepository.findAll();
	}

	public Member saveNewMember(Member newMember) {
		// TODO Auto-generated method stub
		
		return newMember;
	}

	public Optional<Member> getMembersById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("here is the id"+id);
		Optional<Member> member =memberrepository.findById(id);
		return member;
	}
	
	
}



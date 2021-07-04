package census.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import census.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {



}


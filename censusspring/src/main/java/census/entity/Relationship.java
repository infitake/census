package census.entity;

import census.exceptions.LengthExcedeException;
import census.exceptions.WrongInfoException;

public class Relationship {
	private String person1;
	private String person2;
	private String relationship;
	public Relationship(String person1, String person2, String relationship) {
		super();
		this.person1 = person1;
		this.person2 = person2;
		this.relationship = relationship;
	}
	public String getPerson1() {
		return person1;
	}
	public void setPerson1(String person1) throws WrongInfoException, LengthExcedeException {
		if(person1==null) throw new WrongInfoException();
		if(person1.length()>40) throw new LengthExcedeException();
		this.person1 = person1;
	}
	public String getPerson2() {
		return person2;
	}
	public void setPerson2(String person2) throws WrongInfoException, LengthExcedeException {
		if(person2==null) throw new WrongInfoException();
		if(person2.length()>40) throw new LengthExcedeException();
		this.person2 = person2;
	}
	public String getRelationship() {
		return relationship;
	}
	public boolean getRelationStatus(String relation) {
		relation = relation.toLowerCase();
		if (relation.equals("father") || relation.equals("mother") || relation.equals("sister")
				|| relation.equals("brother") || relation.equals("grandmother") || relation.equals("grandfather"))
			return true;
		return false;
		
	}
	public void setRelationship(String relationship) throws WrongInfoException {
		if(relationship ==null || !(getRelationStatus(relationship))) throw new WrongInfoException();
		this.relationship = relationship;
	}
	

}
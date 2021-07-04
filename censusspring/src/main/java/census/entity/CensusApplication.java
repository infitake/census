package census.entity;

public class CensusApplication {
	private  String familyid;
	public CensusApplication(String familyid) {
		super();
		this.familyid = familyid;
	}
	public CensusApplication() {
		
	}
	public String getFamilyid() {
		return this.familyid;
	}

}
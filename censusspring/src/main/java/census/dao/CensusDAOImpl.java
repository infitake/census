//package census.dao;
//
//import java.sql.Connection;
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import census.entity.Member;
//import census.exceptions.AddEntryException;
//import census.exceptions.CreateTableException;
//import census.exceptions.DbConnectionErrorException;
//import census.exceptions.UpdateEntryException;
//
//public class CensusDAOImpl implements CensusDAO {
//	private static Statement dbconnection;
//	public static String statement;
//	public static String sqlStatement;
//	public CensusDAOImpl() throws DbConnectionErrorException, ClassNotFoundException, SQLException {
////		CensusConnectDAO connectdao = new CensusConnectDAO();
////		try {
////			this.dbconnection = connectdao.ConnectToDB();
////		} catch (ClassNotFoundException | SQLException e) {
////			throw new DbConnectionErrorException();
////		}
//		String url = "jdbc:postgresql://localhost/censusdb";
//		String user = "census";
//		String password = "root";
//		Class.forName("org.postgresql.Driver");
//		Connection connection = DriverManager.getConnection(url, user, password);
//		this.dbconnection = connection.createStatement();
//	}
//
//	@Override
//	public boolean addMember(Member member) throws AddEntryException, CreateTableException {
//		
//		statement = "create table if not exists member("
//				+ " memberid varchar(40) NOT NULL primary key,"
//				+ " familyid varchar(40) NOT NULL,"
//				+ " ishead boolean NOT NULL,"
//				+ " firstname varchar(40) NOT NULL,"
//				+ " lastname varchar(40) NOT NULL,"
//				+ " gender varchar(20) NOT NULL,"
//				+ " dob DATE NOT NULL DEFAULT CURRENT_DATE"
//				+ ")";
//		
//		try {
//			this.dbconnection.executeUpdate(statement);
//		} catch (SQLException e) {
//			throw new CreateTableException();
//		}
//		
//		statement = "insert into member(memberid,familyid,ishead,firstname,lastname,dob,gender) "
//				+ "values ("+"'"+ member.getMemberid() + "','" + member.getFamilyid() + "','" 
//				+ member.isIshead() + "','" + member.getFirstname() + "','" 
//				+ member.getLastname() +  "','" + member.getDob().toString() + "','" 
//				+ member.getGender() +"')";
//		
//		try {
//			this.dbconnection.executeUpdate(statement);
//		} catch (SQLException e) {
//			System.out.print(e);
//			throw new AddEntryException();
//		}
//		
//		return true;
//	}
//
//	@Override
//	public boolean editMember(Member member, String familyid, String memberid) throws UpdateEntryException {
//		statement = "update member set "
//					+"firstname='" + member.getFirstname() + "'," 
//					+"lastname='" + member.getLastname() + "',"
//					+"dob='" + member.getDob().toString() + "',"
//					+"gender='" + member.getGender() + "'" + " where "+
//					"familyid='" + familyid + "' and " + "memberid='" + memberid + "';";
//				
//		try {
//			this.dbconnection.executeUpdate(statement);
//		} catch (SQLException e) {
//			throw new UpdateEntryException();
//		}
//		
//		return true;
//	}
//
//	@Override
//	public boolean deleteMember(String familyid, String memberid) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Member> getMembers(String familyid) {
//		List<Member> membersList = new ArrayList<Member>();
//		ResultSet resultset;
//		
//		try {
//			statement  = "select * from member where familyid='" + familyid +  "'";
//			resultset = this.dbconnection.executeQuery(statement);	
//			while(resultset.next()) {
//				Member member = new Member();
//				try {
//					member.setFamilyid(resultset.getString("familyid"));
//					member.setMemberid(resultset.getString("memberid"));
//					member.setFirstname(resultset.getString("firstname"));
//					member.setLastname(resultset.getString("lastname"));
//					member.setDob(resultset.getString("dob"));
//					member.setGender(resultset.getString("gender"));
//					member.setIshead(resultset.getBoolean("ishead"));
//					membersList.add(member);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
//			
//			this.dbconnection.close();
//			resultset.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
////		membersList.forEach((mem) -> {
////			printDetails(mem);
////		});
//		return membersList;
//		
//	}
//
//	@Override
//	public void printDetails(Member member) {
//		System.out.println("FamilyId: "+member.getFamilyid());
//		System.out.println("MemberId:  "+member.getMemberid());
//		System.out.println("FirstName: "+member.getFirstname());
//		System.out.println("LastName:  "+member.getLastname());
//		System.out.println("Gender:  "+member.getGender());
//		System.out.println("DOB: "+member.getDob().toString());
//		
//	}
//
//}

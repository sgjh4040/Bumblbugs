import java.util.*;

public class RegisterMgr {
	
	private final String JDBC_DRIVER = "rg.mariadb.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mariadb://localhost:3306/website";
	private final String USER = "root";
	private final String PASS = "1234";
	
	public RegisterMgr(){
		try {
			Class.forName(JDBC_DRIVER);  //JDBC 드라이버에 로딩
		}catch(Exception e) {
			System.out.println("드라이브 로딩 실패");
		}
	}
	
	//등록 메소드
	
	

}

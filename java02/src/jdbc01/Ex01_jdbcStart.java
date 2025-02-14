package jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Ex01_jdbcStart {
	
	//Connection cn = DBConnection.getConection(); // noneStatic으로 메인 메서드에서 인스턴스 생성 없이는 못쓰게 됨
	static Connection cn = DBConnection.getConection();
	static Statement st;
	static PreparedStatement pst;
	static ResultSet rs;
	static String sql;
	
	// 학생 리스트 출력
	public static void selectList() {
		// 1.커넥션 사용.
		// 2.SQL 구문 처리
		sql = "select * from student";
		try {
			st =cn.createStatement();
			rs =st.executeQuery(sql);
			
			if(rs.next()) { // rs 가 있으면 , 
				System.out.println();
				System.out.println("selectList");
				do {
					
					System.out.print(rs.getInt(1)+" ");
                    System.out.print(rs.getString("name")+" ");
                    System.out.print(rs.getInt("age")+" ");
                    System.out.print(rs.getInt(4)+" ");
                    System.out.print(rs.getString(5)+" ");
                    System.out.print(rs.getFloat(6)+" ");
                    System.out.print(rs.getString(7)+" ");
                    System.out.print(rs.getString(8)+"\n");
				} while (rs.next()); // 다음이 있으면 반복.
			}else {
				System.out.println("데이터 없음");
			}
		} catch (Exception e) {
			System.out.println("selectList Exception "+e.toString());
		}
		
	}
	
	// 조별 리스트 출력
	public static void joList(int jno) {
		sql="select * from student where jno= "+jno;		
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				System.out.println();
				System.out.println("joList");
				do {
					System.out.print(rs.getInt(1)+" ");
                    System.out.print(rs.getString("name")+" ");
                    System.out.print(rs.getInt("age")+" ");
                    System.out.print(rs.getInt(4)+" ");
                    System.out.print(rs.getString(5)+" ");
                    System.out.print(rs.getFloat(6)+" ");
                    System.out.print(rs.getString(7)+" ");
                    System.out.print(rs.getString(8)+"\n");
				} while (rs.next());
			}else {
				System.out.println("데이터 없음");
			}
			
		} catch (Exception e) {
			System.out.println("joList Exception "+e.toString());
		}
	}
	//PreparedStatement  insert 구문 작성
	//  "insert into student values(100,'홍길동',22,7,'info',50.5,'1989-08-08',Current_stampdate)"
	
	// ** SQL 실행메서드
    //=> executeQuery() : select 구문실행, ResultSet 을 return 함.
    //=> executeUpdate()
    //    - insert, update, delete 구문실행
    //    - 실행된 Row 의 갯수를 return
    //    - 그러므로 "0" return 하면 실행되지 않았음 을 의미함.  
	
	
//  "insert into student values(100,'홍길동',22,7,'info','1989-08-08',Current_stampdate)"
	public static void insert(String name , int age , int jno , 
											String info , double point ,String birthday ) {
		sql ="insert into student(name , age , jno, info , point , birthday)"
				+"values (?,?,?,?,?,?)";
		try {
			pst =cn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setInt(3, jno);
			pst.setString(4, info);
			pst.setDouble(5, point);
			pst.setString(6, birthday);
			
			if (pst.executeUpdate()>0) {
				System.out.println("업데이트 성공");
			}else System.out.println("업데이트 실패");
			
			
		} catch (Exception e) {
			System.out.println("insert Exception "+e.toString());
		}
		
		
	}
	
	
	
	
	
	public static void updatename(int sno , String name) {
		sql = "update student set name=? where sno=?";
		
		try {
		pst=cn.prepareStatement(sql ); // 생성하면서 sql문을 먼저 전달함.
		pst.setString(1, name);
		pst.setInt(2, sno); // 물음표 순서대로 넣을것
		if(pst.executeUpdate() >0) {
			System.out.println("업데이트 성공");
		}else System.out.println("업데이트 실패");
		
		} catch (Exception e) {
			System.out.println("updatename "+e.toString());
		}
	}
	
	
	public static void deleteList (int sno) {
		sql="delete from student where sno = ?";
		try {
			pst= cn.prepareStatement(sql);
			pst.setInt(1, sno);
			
			if(pst.executeUpdate() >0) {
				System.out.println("deleteList 성공");
			}else System.out.println("deleteList 실패");
			
		} catch (Exception e) {
			System.out.println("deleteList "+e.toString());
		}
	}
	
	
	public static void main(String[] args) {
		// connection 확인하기
		//System.out.println("DB연결 확인해보기 : "+cn);
		
		// student 출력하기
		//selectList();
		//joList(3);
		
		//업데이트 해보기
		//updatename(90, "이순신");
		//selectList();
		
		//입력 넣어보기
		//String name , int age , int jno , String info , double point ,String birthday
		//insert("강감찬", 88, 7, "insert test", 99.88, "1988-08-08");
		//selectList();
		deleteList(98);
		deleteList(99);
		deleteList(100);
		deleteList(101);
		selectList();
	}

}

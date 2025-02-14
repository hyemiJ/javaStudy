package mvcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// 	Create(Insert), Read(selectList, selectOne), Update, Delete

//=> 첫번째 예제 Ex01_~~~ 와 DAO 와 다른점
//	- 요청 처리 결과를 제공
//	- 즉, 메서드의 역할별로 처리결과를 return 해야함
//	- 그러므로 특히 select 결과를 전달하기위해 결과를 담는 작업이 필요함

public class StudentDAO {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConection();
	private static PreparedStatement pst; // Sql구문처리 단일화
	private static ResultSet rs; // 결과 담당
	private String sql;

	// ** selectList
	// => 결과를 담을 객체를 정의하고
	// 결과를 담아서 return 해줌
	public List<StudentDTO> selectList() {
		sql = "select * from student";
		List<StudentDTO> list = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			// => 결과List 존재 확인
			// => 결과를 List 에 담기
			// - list = rs; -> 불가능, 1Row 단위로 add 해야함.
			// - 1Row 는 StudentDTO Type
			// - 순서: 1Row -> DTO -> List 에 add
			if (rs.next()) {
				do {
					StudentDTO dto = new StudentDTO();
					dto.setSno(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setAge(rs.getInt(3));
					dto.setJno(rs.getInt(4));
					dto.setInfo(rs.getString(5));
					dto.setPoint(rs.getDouble(6));
					dto.setBirthday(rs.getString(7));
					dto.setNow(rs.getString(8));
					list.add(dto);
				} while (rs.next());
			} else {
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			list = null;
		}
		return list;
	}// selectList

	// ** selectOne
	public StudentDTO selectOne(int sno) {
		sql = "select * from student where sno=?";
		StudentDTO dto = new StudentDTO();
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, sno);
			rs = pst.executeQuery();
			if (rs.next()) {
				// => Data 존재: rs(결과값) 을 dto에 담아서 return
				dto.setSno(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setJno(rs.getInt(4));
				dto.setInfo(rs.getString(5));
				dto.setPoint(rs.getDouble(6));
				dto.setBirthday(rs.getString(7));
				dto.setNow(rs.getString(8));
				return dto;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	} // selectOne

	// ** Insert
	// 1) auto_Increment 적용: name, age, jno, info, point, birthday
	// 2) 모든 컬럼
	public int insert(StudentDTO dto) {
		// sql="insert into student(name,age,jno,info,point,birthday) "
		// + "values(?,?,?,?,?,?)";

		sql = "insert into student values(?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());
			pst.setString(2, dto.getName());
			pst.setInt(3, dto.getAge());
			pst.setInt(4, dto.getJno());
			pst.setString(5, dto.getInfo());
			pst.setDouble(6, dto.getPoint());
			pst.setString(7, dto.getBirthday());

			// int count = pst.executeUpdate();
			// return count; // 재사용성있다면 , 변수로 보관.
			// => 비교
			return pst.executeUpdate(); // 처리갯수
		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	} // insert

	// ** Update
	// => name, info, point, birthday 수정
	public int update(StudentDTO dto) {
		sql = "update student set name=?, info=?, point=?, birthday=? where sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getInfo());
			pst.setDouble(3, dto.getPoint());
			pst.setString(4, dto.getBirthday());
			pst.setInt(5, dto.getSno());

			return pst.executeUpdate(); // 처리갯수
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	} // update

	// ** Delete
	// => sno 로 삭제
	public int delete(StudentDTO dto) {
		sql = "delete from student where sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());

			return pst.executeUpdate(); // 처리갯수
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete
	
	//transaction test 
	
//     ** Transaction Test
//     => Connection 객체가 관리
//     => 기본값은 AutoCommit  true 임.
//     => setAutoCommit(false) -> commit 또는 rollback 
//     => Test 사항
//        - 동일자료를 2번 입력 -> 2번째 입력에서 p.key 중복 오류발생 

//     1) Transaction 적용전
//     => 동일자료를 2번 입력
//        - 1번째는 입력완료 되고, 2번째 입력에서 p.key 중복 오류발생 
//        - Rollback 불가능
//        - MySql Command 로 1번째 입력 확인 가능 
        
//     2) Transaction 적용후 
//     => 동일자료를 2번 입력 
//        - 1번째는 입력완료 되고, 2번째 입력에서 p.key 중복 오류발생
//        - Rollback 가능 -> 둘다 취소됨
	
	public void transactionTest() {
		 sql="insert into student "
		 		+ "values(77,'홍길동',22,7,'my Info',77.77,'1977-07-07',Current_timestamp)";
		 
		//1) Transaction 적용전
//		try {
//			pst=cn.prepareStatement(sql);
//			pst.executeUpdate(); // 1번째 sql문 입력됨.
//			pst.executeUpdate(); // 2번째 sql문 입력됨.-> primary key 중복 오류가 발생 ->exception 발생
//		} catch (Exception e) {
//			System.out.println("** Transaction 적용전 Exception => " + e.toString());
//		}
		 
		//2) Transaction 적용후 
		 try {
			 	cn.setAutoCommit(false);
				pst=cn.prepareStatement(sql);
				pst.executeUpdate(); // 1번째 sql문 입력됨. : buffer에 저장됨.
				pst.executeUpdate(); // 2번째 sql문 입력됨. : p.k 중복 오류 exception 발생 -> rollback
				cn.commit();
		 } catch (Exception e) {
			System.out.println("** Transaction 적용후 Exception => " + e.toString());
			try {
				cn.rollback();
				System.out.println("** rollback 성공");
			} catch (SQLException e1) {
				System.out.println("** rollback Exception => " + e1.toString());
			}
		 }
		 
	}

} // class
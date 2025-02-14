package com.example.demo03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo03.domain.MemberDTO;




//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// 	Create(Insert), Read(selectList, selectOne), Update, Delete

//=> 첫번째 예제 Ex01_~~~ 와 DAO 와 다른점
//	- 요청 처리 결과를 제공
//	- 즉, 메서드의 역할별로 처리결과를 return 해야함
//	- 그러므로 특히 select 결과를 전달하기위해 결과를 담는 작업이 필요함

@Repository
public class MemberDAO {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConection();
	private static PreparedStatement pst; // Sql구문처리 단일화
	private static ResultSet rs; // 결과 담당
	private String sql;

	// ** selectList
	// => 결과를 담을 객체를 정의하고
	// 결과를 담아서 return 해줌
	public List<MemberDTO> selectList() {
		sql = "select * from member";
		List<MemberDTO> list = new ArrayList<>();
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
					MemberDTO dto = new MemberDTO();
					dto.setId(rs.getString(1));
					dto.setPassword(rs.getString(2));
					dto.setName(rs.getString(3));
					dto.setAge(rs.getInt(4));
					dto.setJno(rs.getInt(5));
					dto.setInfo(rs.getString(6));
					dto.setPoint(rs.getDouble(7));
					dto.setBirthday(rs.getString(8));
					dto.setRid(rs.getString(9));
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
	public MemberDTO selectOne(String id) {
		sql = "select * from member where id=?";
		MemberDTO dto = new MemberDTO();
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				// => Data 존재: rs(결과값) 을 dto에 담아서 return
				dto.setId(rs.getString(1));
				dto.setPassword(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setJno(rs.getInt(5));
				dto.setInfo(rs.getString(6));
				dto.setPoint(rs.getDouble(7));
				dto.setBirthday(rs.getString(8));
				dto.setRid(rs.getString(9));
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
	public int insert(MemberDTO dto) {
		// sql="insert into student(name,age,jno,info,point,birthday) "
		// + "values(?,?,?,?,?,?)";

		sql = "insert into member values(?,?,?,?,?,?,?,?,?)";

		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPassword());
			pst.setString(3, dto.getName());
			pst.setInt(4, dto.getAge());
			pst.setInt(5, dto.getJno());
			pst.setString(6, dto.getInfo());
			pst.setDouble(7, dto.getPoint());
			pst.setString(8, dto.getBirthday());
			pst.setString(9, dto.getRid());

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
	// =>id는 pk임으로 수정불가 ,
	// => password 는 단독 수정 해야함.
	// 이외 전부 한꺼번에 수정 가능
	public int update(MemberDTO dto) {
		sql = "update member set name=?, age=? ,jno= ?, info=?, point=?, birthday=? , rid = ? where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getAge());
			pst.setInt(3, dto.getJno());
			pst.setString(4, dto.getInfo());
			pst.setDouble(5, dto.getPoint());
			pst.setString(6, dto.getBirthday());
			pst.setString(7, dto.getRid());
			pst.setString(8, dto.getId());

			return pst.executeUpdate(); // 처리갯수
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	} // update

	// ** Delete
	// => id 로 삭제
	public int delete(MemberDTO dto) {
		sql = "delete from member where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());

			return pst.executeUpdate(); // 처리갯수
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete
	
	

} // class
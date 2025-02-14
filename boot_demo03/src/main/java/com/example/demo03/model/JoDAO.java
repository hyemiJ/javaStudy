package com.example.demo03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo03.domain.JoDTO;




public class JoDAO {
	
	private static Connection cn=DBConnection.getConection();
	private static PreparedStatement pst; //Sql구문처리 단일화
	private static ResultSet rs; //결과 담당
	private String sql;
	
	//select * from jo;
	public List<JoDTO> selectJOList(){
		sql = "select * from jo";
		List<JoDTO> joList = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				do {
					JoDTO joDto = new JoDTO();
					joDto.setJno(rs.getInt(1));
					joDto.setJname(rs.getString(2));
					joDto.setCaptain(rs.getString(3));
					joDto.setProject(rs.getString(4));
					joDto.setSlogan(rs.getString(5));
					
					joList.add(joDto);
				} while (rs.next());
			}else joList = null;
			
		} catch (Exception e) {
			System.out.println("**DAO ) selectJOList Exception => "+e.toString());
			joList = null;
		}
		return joList;
	}
	
	// select * from jo where jno=?;
	public JoDTO selectJoListOne(int jno) {
		sql = "select * from jo where jno = ? ";
		JoDTO joDto = new JoDTO();
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, jno);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				joDto.setJno(rs.getInt(1));
				joDto.setJname(rs.getString(2));
				joDto.setCaptain(rs.getString(3));
				joDto.setProject(rs.getString(4));
				joDto.setSlogan(rs.getString(5));
			} else {
				System.out.println("DAO ) 찾지 못함.");
				joDto = null;
			}
			
		} catch (Exception e) {
			System.out.println("**DAO ) selectJoListOne Exception => "+e.toString());
			joDto = null;
		}
		
		return joDto;
	}
	
	
	//insert 
	//insert into jo values(? , ? , ? , ? );
	public int insertJo(JoDTO joDto) {
		sql = "insert into jo values (? , ? , ? , ? , ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, joDto.getJno());
			pst.setString(2, joDto.getJname());
			pst.setString(3,joDto.getCaptain());
			pst.setString(4, joDto.getProject());
			pst.setString(5, joDto.getSlogan());
			
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("**DAO ) insertJo Exception => "+e.toString());
			return 0;
		}
	}
	
	public int updateJo(JoDTO joDto) {
		sql = "update jo set jname = ? , captain = ? , project = ? , slogan = ? where jno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, joDto.getJname());
			pst.setString(2,joDto.getCaptain());
			pst.setString(3, joDto.getProject());
			pst.setString(4, joDto.getSlogan());
			pst.setInt(5, joDto.getJno());
			
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("**DAO ) updateJo Exception => "+e.toString());
			return 0;
		}
	}
	
	public int deleteJo(JoDTO joDto) {
		sql = "delete from jo where jno = ?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, joDto.getJno());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("**DAO ) deleteJo Exception => "+e.toString());
			return 0;
		}
	}
	
	//조인 테스트
	
	public List<JoDTO> joinTest(){
		sql = "SELECT j.jno , j.jname , captain , m.name , m.age , project , slogan "
				+"FROM jo j JOIN member m ON j.captain = m.id";
		List<JoDTO> joinList = new ArrayList<>();
		
		try {
			pst= cn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				do {
					JoDTO joinDto = new JoDTO();
					joinDto.setJno(rs.getInt(1));
					joinDto.setJname(rs.getString(2));
					joinDto.setCaptain(rs.getString(3));
					joinDto.setName(rs.getString(4));
					joinDto.setAge(rs.getInt(5));
					joinDto.setProject(rs.getString(6));
					joinDto.setSlogan(rs.getString(7));
					
					joinList.add(joinDto);
				} while (rs.next());
			}else joinList = null;
			
		} catch (Exception e) {
			System.out.println("**DAO ) joinTest Exception => "+e.toString());
			joinList = null;
		}
		return joinList;
	}
	
	
}

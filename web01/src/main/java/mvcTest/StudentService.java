package mvcTest;

import java.util.List;

public class StudentService {
// ** 전역변수 정의
	StudentDAO dao = new StudentDAO();

// ** selectList
	public List<StudentDTO> selectList() {
		return dao.selectList();
	}

// ** selectOne
	public StudentDTO selectOne(int sno) {
		return dao.selectOne(sno);
	}

// ** insert
	public int insert(StudentDTO dto) {
		return dao.insert(dto);
	}

// ** update
	public int update(StudentDTO dto) {
		return dao.update(dto);
	}

// ** delete
	public int delete(StudentDTO dto) {
		return dao.delete(dto);
	}
	
	//transactiontest
	public void transactionTest() {
		dao.transactionTest();
	}

}// class
package jdbc02;

import java.util.List;

//** Controller
//=> 요청 : 요청분석 -> 담당 Service -> Service 는 DAO 
//=> 결과 : DAO -> Service -> Controller
//=> View : Controller -> View 담당 (Java:Console // Web:JSP, Html.., React) 

public class StudentController {
// ** 전역변수정의
	StudentService service = new StudentService();

// ** View 역할메서드 정의
//=> selectList
	public void viewList(List<StudentDTO> list) {
		System.out.println("*********************************");
		System.out.println("        Student List");
		System.out.println("*********************************");
		if (list != null) {
//=> List 출력: 반복문
			for (StudentDTO s : list) {
				System.out.println(s);
			} // for
		} else {
			System.out.println("** selectList: 출력 자료가 1건도 없습니다. **");
		}
	} // viewList

	public void viewDetail(StudentDTO dto) {
		System.out.println("*********************************");
		System.out.println("        Student Detail");
		System.out.println("*********************************");
		if (dto != null) {
			System.out.println(dto);
		} else {
			System.out.println("** selectOne: 출력 자료가 없습니다. **");
		}
	} // viewDetail

	public static void main(String[] args) {
// ** StudentController 인스턴스 생성
		StudentController sc = new StudentController();
/*==============================================
// 1) selectList
// => service의 selectList 의 결과를 인자로 전달
		List<StudentDTO> list = sc.service.selectList();
		sc.viewList(list);
//sc.viewList(sc.service.selectList());

// 2) selectOne
//sc.viewDetail(sc.service.selectOne(90));

// 3) insert
//=> 99번 으로 insert, update, delete 
		StudentDTO dto = new StudentDTO(99, "을지문덕", 35, 7, "MVC insert", 77.77, "1789-08-08", null);
		if (sc.service.insert(dto) > 0) {
			System.out.println("\n** insert 성공 **");
			sc.viewDetail(sc.service.selectOne(99));
		} else
			System.out.println("\n** insert 실패 **");

// 4) update // 7/14~8/13
//=>name, info, point, birthday 수정
		dto.setName("안세영");
		dto.setInfo("Update Test 중");
		dto.setPoint(555.66);
		dto.setBirthday("1999-09-09");
		if (sc.service.update(dto) > 0) {
			System.out.println("\n** update 성공 **");
			sc.viewDetail(sc.service.selectOne(99));
		} else
			System.out.println("\n** update 실패 **");

// 5) delete
		if (sc.service.delete(dto) > 0) {
			System.out.println("\n** delete 성공 **");
			sc.viewDetail(sc.service.selectOne(99));
		} else
			System.out.println("\n** delete 실패 **");

//6) transaction test : start transaction , commit ,rollback , savepoint
		//JDBC 에서 적용 전 , 후
		// JDBC에서는 connection 이 관리
		 * ============================================
		 */
		sc.service.transactionTest();
		sc.viewList(sc.service.selectList());
		
		
		
		
	} // main

} // class
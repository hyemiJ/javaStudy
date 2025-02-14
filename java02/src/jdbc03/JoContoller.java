package jdbc03;

import java.util.ArrayList;
import java.util.List;

public class JoContoller {
	
	JoService joService = new JoService();
	
	public void selectJoListContolloer(List<JoDTO> joList){
		if(joList != null) {
			for (JoDTO joDTO : joList) {
				System.out.println(joDTO);
			}
		}else {
			System.out.println("출력 결과가 없습니다.");
		}
	}
	
	public void selectJoListOneContolloer(int jno) {
		//joService.selectJoListOneService(jno);
		System.out.println(joService.selectJoListOneService(jno));
	}
	
	public void insertJoContoller(JoDTO joDto) {
		//joService.insertJoService(joDto);
		if (joService.insertJoService(joDto)>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
	}
	public void updateJoContoller(JoDTO joDto) {
		if (joService.updateJoService(joDto)>0) {
			System.out.println("update 성공");
		}else {
			System.out.println("update 실패");
		}
	}
	
	public void deleteJoContoller(JoDTO joDto) {
		if (joService.deleteJoService(joDto)>0) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
	}
	public void joinTestContoller(List<JoDTO> joinList) {
		if(joinList !=null) {
			for (JoDTO joDTO : joinList) {
				System.out.println(joDTO);
			}
		}else {
			System.out.println("리스트 없음");
		}
	}

	
	public static void main(String[] args) {
		JoContoller joC = new JoContoller();
//		List<JoDTO> joList = joC.joService.selectJoListService(); 
		//joC.selectJoListOneContolloer(10);
//		JoDTO testDto = new JoDTO(9, "insert", 10, "insert", "insert");
//		joC.insertJoContoller(testDto);
//		joC.selectJoListContolloer(joC.joService.selectJoListService());
//		testDto.setJname("update");
//		testDto.setProject("update");
//		testDto.setSlogan("update");
//		testDto.setCaptain(3);
//		joC.updateJoContoller(testDto);
//		joC.selectJoListContolloer(joC.joService.selectJoListService());
//		joC.deleteJoContoller(testDto);
//		joC.selectJoListContolloer(joC.joService.selectJoListService());
		
		// 조인하기(jo 의 목록 + 조장의 이름과 age 출력하기)
		List<JoDTO> joinList = joC.joService.joinTestService();
		joC.joinTestContoller(joinList);
		
	}

}

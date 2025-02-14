package j05_classMethod;


import java.util.Scanner;

//** MyClass
//=> 맴버변수 3개, 메서드 2개 정의 
//=> MyClass 를 정의하고
// Ex02_MyClassTest 에서 인스턴스 2개 만들어 출력하기


//** 전역변수 와 지역변수 Test

class MyClass {
	String  name;
	int strNumber;
	int kor , eng , math ;
	char grade;
	String minresult="" ,maxresult="";
	int min, max ;
	double avg () {
		double result= (double)(kor+eng+math)/3;
		return result;
	}
	

	char grade() {
		double result = (kor+eng+math)/3;
		char gradeResult ;
		switch ((int)(result/10)) {
		case 10:
		case 9:
			gradeResult ='A';
			break;
		case 8:
		case 7:
			gradeResult ='B';
			break;
		case 6:
			gradeResult ='C';
			break;
		default:
			gradeResult ='D';
			break;
		}
		return gradeResult;
	}
	String cheerUp() {
		String cheerString ;
		double result = (double)(kor+eng+math)/3;
		if (result>80) {
			cheerString = "참 잘했어요";
		}else if (result>60) {
			cheerString ="조금 더 노력하세요";
		}else {
			cheerString="이러면 큰일 나!!";
		}
	
		return cheerString;
	}
	
	String tosString() {
		return "이름 : "+name+", 학생번호 : "+strNumber+", 평균 :"+avg()+", 등급 : "+grade() ;
	}
	void max() {
		max = kor;
		max = Math.max(max,eng);
		max = Math.max(max,math);
		if (max ==kor) {
			maxresult += "국어, ";
		}
		if (max==eng) {
			maxresult += "영어, ";
		}
		if (max==math){
			maxresult +="수학";
		}

	}
	void min () {
		min = kor;
		min = Math.min(min,eng);
		min = Math.min(min,math);
		
		if (min ==kor) {
			minresult += "국어";
		}
		if (min==eng) {
			minresult += "영어";
		}
		if (min==math){
			minresult+="수학";
		}

	}
}




public class Ex02_MyClassTest {
	public static void main(String[] args) { //출력을 위한 메서드
		MyClass strListClass = new MyClass();
		strListClass.name = "정혜미";
		strListClass.strNumber=1;
		strListClass.kor = 100;
		strListClass.eng =12;
		strListClass.math=70;
		strListClass.min();
		strListClass.max();
		
		Scanner scanner = new Scanner(System.in);
		MyClass scannerStu = new MyClass();
		System.out.println("학생 이름");
		scannerStu.name = scanner.nextLine();
		System.out.println("학생 번호");
		scannerStu.strNumber = Integer.parseInt(scanner.nextLine());
		System.out.println("영어 점수");
		scannerStu.eng = Integer.parseInt(scanner.nextLine());
		System.out.println("수학 점수");
		scannerStu.math = Integer.parseInt(scanner.nextLine());
		System.out.println("국어 점수");
		scannerStu.kor = Integer.parseInt(scanner.nextLine());
		scannerStu.min();
		scannerStu.max();
		
		
		System.out.println("학생 "+scannerStu.name+"의 성적표");
		System.out.printf("국어점수: %d , 영어점수: %d , 수학점수: %d , 평균점수: %f , 등급: %c %n" ,
				scannerStu.kor,scannerStu.eng , scannerStu.math ,  scannerStu.avg() , scannerStu.grade());
		System.out.println(scannerStu.tosString());
		System.out.println(scannerStu.cheerUp());
		System.out.println("최고점 : "+scannerStu.max+ ",과목 :"+scannerStu.maxresult);
		System.out.println("최저점 : "+scannerStu.min+ ",과목 :"+scannerStu.minresult);
		
		System.out.println();
		System.out.println();
		
//		System.out.println("학생 "+strListClass.name+"의 성적표");
//		System.out.printf("국어점수: %d , 영어점수: %d , 수학점수: %d , 평균점수: %f , 등급: %c %n" ,
//				strListClass.kor,strListClass.eng , strListClass.math ,  strListClass.avg() , strListClass.grade());
//		System.out.println(strListClass.tosString());
//		System.out.println(strListClass.cheerUp());
//		System.out.println("최고점 : "+strListClass.max+ ",과목 :"+strListClass.maxresult);
//		System.out.println("최저점 : "+strListClass.min+ ",과목 :"+strListClass.minresult);
		scanner.close();
	}
}

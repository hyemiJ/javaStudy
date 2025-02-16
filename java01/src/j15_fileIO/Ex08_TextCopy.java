package j15_fileIO;
import java.io.*;

// ** 문자 Stream, FileReader & FileWriter 적용 
// => 텍스트 파일 복사하기
public class Ex08_TextCopy {
	public static void main(String[] args){
		File src = new File("C:\\MTest\\IDESet\\eclipse\\eclipse.ini"); // 원본 파일 경로명
		File dest = new File("eclipseIni.txt"); // 복사 파일 경로명

		int c;
		try {
			FileReader fr = new FileReader(src); // 파일 입력 문자 스트림 생성
			FileWriter fw = new FileWriter(dest); // 파일 출력 문자 스트림 생성
			while((c = fr.read()) != -1) { // 문자 하나 읽고
				fw.write((char)c); // 문자 하나 쓰고
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath()+ "를 " + dest.getPath()+ "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 복사 오류 => "+e.toString());
		} // try
	} //main
} // class
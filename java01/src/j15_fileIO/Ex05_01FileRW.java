package j15_fileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

//** 문자 스트림
//=> 완성된 화일을 메모장 또는 이클립스에서 열어보면
//   Byte Stream 과는 다르게 운영체제에 맞게 인코딩 되어있음을 알 수 있다.  

//=> 실습: OS 상에서 확인할 수 있는 형태로 알파벳 저장 & 출력 하기
public class Ex05_01FileRW {

	public static void main(String[] args) throws IOException {
		// ** 문자 스트림 생성
		// => 없는 화일로 Test -> 생성 순서 중요
		Writer out = new FileWriter("alphabet.txt", true);
		// => new FileWriter("alphabet.txt"); -> 무조건 새로 생성되고 추가되지 않음
		// => new FileWriter("alphabet.txt", true); -> 기존의 파일에 추가됨
		//                  (없는 파일은 생성되며 true 속성을 가짐 즉, 오류 발생하지 않음) 
		Reader in = new FileReader("alphabet.txt");
		try {
			// ** write
			for (int ch=(int)'A'; ch<(int)('Z'+1); ch++) {
				out.write(ch);
			} //for
			out.flush();
			// 또는 out.close(); 
			// flush() 또는 close() 시 화일에 write 됨
			// => write 되어야 아래에서 read 가능함
			// ** read	
			char[] cbuff = new char[28] ;
			int readCnt;
			readCnt=in.read(cbuff, 0, cbuff.length) ;
			// length 만큼 읽어, cbuff 의 0 위치 부터 저장하고, 읽은 바이트수를 반환
			System.out.println("** readCnt (읽은 바이트수) => "+readCnt);
			for (int i=0; i<readCnt; i++) {
				System.out.print(cbuff[i]+" ");
			}
		} finally {
			// ** 스트림 소멸
			if (in!=null) in.close();
			if (out!=null) out.close();
		}
		System.out.println("\n** FileReader / FileWriter Test1 종료 **");
	} //main
} //class

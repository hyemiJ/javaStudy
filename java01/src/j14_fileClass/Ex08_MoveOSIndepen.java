package j14_fileClass;

import java.io.File;

// ** OS 에 독립적으로 처리하기
// => OS 의 separator 를 가져와서 경로를 완성함
public class Ex08_MoveOSIndepen {
	
	public static void main(String[] args) {
		File myFile=
			new File("C:"+File.separator+"MyJava"+File.separator+"my.bin");
		if(myFile.exists()==false) {
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			return;
		}
		
		File reDir=new File("C:"+File.separator+"YourJava");
		reDir.mkdir();
		File reFile=new File(reDir, "my.bin");
		myFile.renameTo(reFile);
		if(reFile.exists()==true)
			System.out.println("파일 이동에 성공하였습니다.");
		else
			System.out.println("파일 이동에 실패하였습니다.");
	} // main

} //class

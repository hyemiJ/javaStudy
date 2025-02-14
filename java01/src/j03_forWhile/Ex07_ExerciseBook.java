package j03_forWhile;

public class Ex07_ExerciseBook {

	public static void main(String[] args) {
		//문자를 각 자리수만큼 더해서 값을 도출하라.
		 String str="12345";
		 int sum=0;
		 for (int i=0; i<str.length(); i++){
		 sum+=Integer.parseInt(str.substring(i,i+1));
		 //String->int
		 //sum+=Integer.parseInt(String.valueOf(str.charAt(i)));
		 //char -> String->int
		 //sum+=Integer.parseInt(Character.toString(str.charAt(i)));
		 //char -> String->int
		 //sum+=str.charAt(i)-'0';
		 //유니코드 값의 차를 활용
		 }
		 System.out.println("sum="+sum);
		 }

	

}

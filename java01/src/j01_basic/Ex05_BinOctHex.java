package j01_basic;
//** 2진수(Binary number), 8진수 , 16진수 표기
//=> 2진수 : 0b 로시작 -> 0b1111
//=> 8진수 : 0  Octal Number
//=> 16진수: 0x Hexadecimal Number
public class Ex05_BinOctHex {
	public static void main(String[] args) {
		
		int bin =0b1111;
		System.out.println("2진수 0b1111 :"+bin);
		//2진수 -> 1+2+4+8
		//결과 : 2진수 0b1111 :15
		
		int oct = 017;
		//8진수 -> 8+7
		System.out.println("8진수 017 :"+oct);
		//결과 :8진수 017 :15
		
		int hex = 0xf;
		//16진수 -> 15 (...9 , A(10), B(11), C(12), D(13), E(14), F(15),10)
		System.out.println("16진수 0xf :"+hex);
		//결과 :16진수 0xf :15
		
		System.out.printf("(printf이용)2진수 bin :%d , 8진수 oct :%d , 16진수 hex:%d \n",bin,oct,hex);
		//결과 :(printf이용)2진수 bin :15 , 8진수 oct :15 , 16진수 hex:15 
		System.out.printf("(printf이용)2진수 bin :%s , 8진수 oct :%#o , 16진수 hex:%#x \n",Integer.toBinaryString(bin) ,oct,hex);
		//결과 :(printf이용)2진수 bin :1111 , 8진수 oct :017 , 16진수 hex:0xf 
		
		//int 를 2 , 8 , 16진법으로 출력하기
		System.out.printf("(toBinaryString 이용)  Integer.toBinaryString(12345):%s \n", Integer.toBinaryString(12345));
		//결과 :(toBinaryString 이용)  Integer.toBinaryString(12345):11000000111001 
		System.out.printf("(toOctalString 이용)  Integer.toOctalString(12345):%s \n", Integer.toOctalString(12345));
		//결과 :(toOctalString 이용)  Integer.toOctalString(12345):30071 
		System.out.printf("(toHexString 이용)  Integer.toHexString(12345):%s \n", Integer.toHexString(12345));
		//결과 :(toHexString 이용)  Integer.toHexString(12345):3039 
		System.out.println();
		
		
		//int to string
		System.out.printf("(printf이용)2진수 bin :%d , 8진수 oct :%d , 16진수 hex:%d \n",bin,oct,hex);
		//결과 :(printf이용)2진수 bin :15 , 8진수 oct :15 , 16진수 hex:15 
		System.out.println("int to stirng 1: +bin+oct+hex : "+bin+oct+hex);
		//결과 :int to stirng 1: +bin+oct+hex : 151515
		System.out.println("int to stirng 2 : +(bin+oct+hex): "+(bin+oct+hex));
		//결과 :int to stirng 2 : +(bin+oct+hex): 45
		System.out.println("int to stirng 3: (String.valueOf(bin))+100) : "+(String.valueOf(bin))+100);
		//결과 :int to stirng 3: (String.valueOf(bin))+100) : 15100
		
		System.out.println();
	
		//string to int
		String s = "123";
		System.out.println("string s :"+s);
		//결과: string s :123
		System.out.println("string to int 1:+(s+100): "+(s+100));
		//결과 :string to int 1:+(s+100): 123100
		System.out.println("string to int 2:+(Integer.parseInt(s)+100): "+(Integer.parseInt(s)+100));
		//결과 :string to int 2:+(Integer.parseInt(s)+100): 223
		System.out.println("string to int 3:+(Integer.valueOf(s)+100)): "+(Integer.valueOf(s)+100));
		//결과 :string to int 3:+(Integer.valueOf(s)+100)): 223
		System.out.println();
		
		
		//string to double
		s = "123.456";
		System.out.println("string s :"+s);
		//결과 :string s :123.456
		System.out.println("string to double 1:+(s+100): "+(s+100));
		//결과 : string to double 1:+(s+100): 123.456100
		System.out.println("string to duuble 2:+(Double.parseDouble(s)+100): "+(Double.parseDouble(s)+100));
		//결과 :string to int 2:+(Double.parseDouble(s)+100): 223.45600000000002
		
		//string에서 숫자가 아닌 형태일때의 오류
		s="abcd.123";
		//System.out.println("string to int 2:+(Double.parseDouble(s)+100): "+(Double.parseDouble(s)+100));
		//오류 java.lang.NumberFormatException: For input string: "abcd.123"
	}

}

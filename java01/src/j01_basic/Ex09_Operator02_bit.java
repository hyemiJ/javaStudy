package j01_basic;

public class Ex09_Operator02_bit {
	//** bit 연산
	//=> 쉬프트 연산 , 논리 연산
	public static void main(String[] args) {
		int x=10, y=3; // 1010
		//==============================쉬프트 연산
		System.out.printf("쉬프트 연산 :10진법 x = %d , y = %d %n",x,y);
		System.out.printf("쉬프트 연산 :2진법 x = %s , y = %s %n",Integer.toBinaryString(x),Integer.toBinaryString(y));
		//결과  :쉬프트 연산 :2진법 x = 1010 , y = 11 
		System.out.println("x>>y : "+(x>>y));
		//x를 y만큼 이동,
		//1010 -> 0101 -> 0010 -> 0001 -> 1
		System.out.println("x<<y : "+(x<<y));
		//x를 좌측으로 y 만큼이동,
		//1010 -> 1 0100 -> 10 1000 -> 101 0000 -> 64+16 => 80
		System.out.println("x<<1 : "+(x<<1));
		//x 를 좌측으로 1만큼 이동.
		//1010 -> 1 0100 => 20
		//===============================논리 연산
		//and(&)-두개가 1이면 1 , or(|)- 둘중 하나라도 1 이면 1 , xor(^)- 두개가 같으면 0
		System.out.printf("논리 연산 :10진법 x = %d , y = %d %n",x,y);
		System.out.printf("논리 연산 :2진법 x = %s , y = %s %n",Integer.toBinaryString(x),Integer.toBinaryString(y));
		
		System.out.println("x&y : "+(x&y));
		//1010 =x
		//0011 =y
		//----
		//0010 => 2
		
		System.out.println("x|y : "+(x|y));
		//1010 =x
		//0011 =y
		//----
		//1011 => 11
		
		System.out.println("x^y : "+(x^y));
		//1010 =x
		//0011 =y
		//----
		//1001 => 9
		System.out.println();
		
		//==================================활용
				 
		int password = 1234567 , d=0;
		int key = 0x1ABC55; //16진수로.
		System.out.println("암호화 전 password : "+ password);
		//암호화 작업(encryption)
		d = password^key;
		System.out.println("암호화 된 password : "+ d);
		
		//복호화 작업(decryption)
		d = d^key;
		System.out.println("복호화 된 password : "+ d);
	}

}

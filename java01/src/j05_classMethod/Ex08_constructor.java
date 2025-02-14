package j05_classMethod;

//** 생성과정
//=> new 연산자가 해당되는 클래스를 메모리에 로드해서 생성함.
//=> 이때 생성직후 생성자메서드를 호출함
//
//** 생성자(Constructor) 메서드
//=> 클래스와 이름 동일하고, return 값이 없음. (void 조차도 생략됨)
//그러나 매개변수는 갯수, Type 제한 없음
//=> 생성시에 단한번 호출가능 
//=> 한 클래스의 생성자는 여러개 가능 (생성자 오버로딩) 
//=> 생성자를 작성하지 않으면 컴파일러가 자동으로 기본생성자를 만들어줌(Default Constructor)
//(단, 하나라도 생성자 메서드를 작성하면 Default 생성자는 자동으로 만들어지지않음)
// 
//** 생성자 메서드에서 생성자 메서드 호출 가능 
//=> this(?,?,...)
//=> this(...) 은 반드시 생성자 메서드 내에서 첫줄에 위치해야함.



class Phone {
	static int count;
	
	String company ;
	String number;
	int price ;
	
	public int dataUp( int i) {
		return i * 100;
	}
	
	public String toString() {
		return"[ company : "+company+", number : "+number
				+", price : "+price +" static count : "+ count +" ]";
	}
	
	public  Phone(String company , int price) {
		//company = company; // 구분이 가지 않는 상태가 되어버림. 
		this.company = company; // this 는 현재 인스턴스를 일컫는다. 그로 인해 인스턴스 멤버 변수를 표기할 수 있다.
		this.price = price;
		count++;
		System.out.println("test : 인자 두개의 count: "+count);
	}// 생성자 메서드
	
	//기본 생성자 추가
	public  Phone() {
		count++;
		System.out.println("test : 기본생성자 count: "+count);
		
	}
	public Phone (String company ,String number , int price ) {
		this.company = company;
		this.number = number;
		this.price = price;
		count++;
		System.out.println("test : 인자 세개의 count: "+count);
	}
	
	public Phone (String company ,String number , int price , int count) {
		this.company = company;
		this.number = number;
		this.price = price;
		Phone.count = count;
		System.out.println("test : 모든 인자의 count: "+count);
	}
	public Phone (String company  , String number) {
		this(company,number,0,0); // this()의 인자의 갯수와 타입이 일치하는 생성자의 인자의 갯수와 타입이 일치하는 것을 불러들이는 것임.
		count++;
		System.out.println("test : this()활용 count: "+count);
	}
	
}



public class Ex08_constructor {

	public static void main(String[] args) {
		//1.Default Constructor(= 기본생성자. 인자가 없는 생성자) 확인 : 생성자를 하나라도 추가하면 자동 생성은 되지 않음.
		Phone phone1 = new Phone(); // new(생성) , Phone() (생성자 메서드) // The constructor Phone() is undefined 오류 발생
		phone1.company = "apple";
		phone1.number="010-0000-0000";
		phone1.price = 10000;
		
		System.out.println("phone1.toString() : "+phone1);
		
		//2.인자가 있는 생성자 확인
		System.out.println();
		Phone phone2 = new Phone("LG", 2000);
		System.out.println("phone2.toString() : "+phone2);

		//3.인자로 모든 instance 변수를 초기화 하는 생성자 확인
		System.out.println();
		Phone phone3 = new Phone("LG","0000000", 2000);
		System.out.println("phone3.toString() : "+phone3);
		
		//4.인자로 모든 변수를 초기화 하는 생성자 확인
		System.out.println();
		Phone phone4 = new Phone("LG","0000000", 2000 , 5);
		System.out.println("phone4.toString() : "+phone4);
		
		//5.this()를 활용
		System.out.println();
		Phone phone5 = new Phone("삼성","12345");
		System.out.println("phone5.toString() : "+phone5);
	}

}

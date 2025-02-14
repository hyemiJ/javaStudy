package j05_classMethod;
//** 접근제어자
//=> 클래스 또는 클래스의 맴버들의 접근 범위 제한 
//=> public(프로젝트전체) > protected(상속+default) > default(같은 패키지내) > private(해당 클래스내)
//
//** 설정자(mutator) 와 접근자(accessor)
//=> 외부클래스 에서 변수에 직접 접근하지 못하도록 하고, 
// 메서드를 통해서만 접근하도록 함
//=> 그러면 변수에 값을 넣어주는 메서드 (설정자) 와
// 변수의 값을 보여주는 메서드 (접근자) 가 필요함.
//=> 설정자: 맴버변수 write, setXXX() 형식 -> setter
//=> 접근자: 맴버변수 read, getXXX() 형식 -> getter
//
//=> 메서드를 통해 접근하므로 변수값에 대한 Control 이 가능함
//=> 필요에 따라서 setter , getter 를 적절하게 작성해서 외부에서의 접근을 조정 할 수 있음

class Member{
	//접근제어자를 통하여 멤버 변수 자료들을 보호함.
	//private 으로 정의 : 현재 클래스에서만 접근 가능함.
	//클래스 외부에서는 메서드(setter / getter)를 통하여 접근 함.
	//전역변수는 기본 디폴트값이 들어간다. null , 0 , 0.0 
	private String id ;
	private String name ;
	private int age ;
	//기본생성자와 초기화 생성자준비
	public Member() {
	}
	public Member(String id,String name, int age) { //지역변수일 경우 값을 넣어주지않으면 실행문(sysout)에서 사용 할 수 없다.
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//설정자와 접근자
	//id 설정자
	public void setId(String id) {
		this.id = id;
	}
	//id 접근자
	public String getId() {
		return this.id;
	}
	public String getId(String id) {
		if (id != "admin") {
			return null;
		}else {			
			return this.id;
		}
	}
	//name 설정자
	public void setName(String name) {
		this.name = name;
	}
	//name 접근자
	public String getName() {
		return this.name;
	}
	//age 설정자
	public void setAge(int age) {
		this.age = age;
	}
	//age 접근자
	public int getAge() {
		return this.age;
	}
	//toString 만들기
	@Override //재정의
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
}



public class Ex09_accesor {
	public static void main(String[] args) {
		
		//test : 다른 클래스의 private 접근 하기.
		Member member01 = new Member();
		member01.setId("apple");
		member01.setAge(30);
		member01.setName("사과");
		System.out.println("member01.getId() : "+member01.getId());
		System.out.println("member01.getName() : "+member01.getName());
		System.out.println("member01.getAge() : "+member01.getAge());
		System.out.println();
		//한번에 초기화 해보기
		Member member02 = new Member("바나나","banna",40);
		System.out.println("member02.getId() : "+member02.getId());
		System.out.println("member02.getName() : "+member02.getName());
		System.out.println("member02.getAge() : "+member02.getAge());
		System.out.println();
		//아이디 보호 예시 (조건의 추가)
		Member member03 = new Member("수박","워터멜론",100);
		System.out.println("member03.getId() : "+member03.getId("수박"));
		System.out.println("member03.getName() : "+member03.getName());
		System.out.println("member03.getAge() : "+member03.getAge());
		
		
	}
}

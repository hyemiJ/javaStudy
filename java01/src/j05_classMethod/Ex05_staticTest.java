package j05_classMethod;
//** static, instance 접근하기
//=> 다른클래스의 맴버 접근 ( Ex05_static )
public class Ex05_staticTest {

	public static void main(String[] args) {
		//옆집의 static 멤버 호출해 보기.
		//호출 방법 : 클래스 . 멤버명
		System.out.println("옆집의 static 멤버 호출해 보기.");
		System.out.println("Ex05_static.staticTotal : "+Ex05_static.staticTotal);
		System.out.println("Ex05_static.staticAdd(4, 2, new Ex05_static()) : "+Ex05_static.staticAdd(4, 2, new Ex05_static()));
		System.out.println();
		//옆집의 instance 멤버 호출해보기.
		Ex05_static instanceTest = new Ex05_static();
		System.out.println("옆집의 instance 멤버 호출해 보기.");
		System.out.println("Ex05_static.staticTotal : "+Ex05_static.staticTotal);
		System.out.println("instanceTest.instanceTotal : "+instanceTest.instanceTotal);
		System.out.println("instanceTest.instanceMulti(1, 4) : "+instanceTest.instanceMulti(1, 4));
		System.out.println("Ex05_static.staticTotal : "+Ex05_static.staticTotal);
	}

}

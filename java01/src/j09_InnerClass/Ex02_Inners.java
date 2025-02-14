package j09_InnerClass;

//** Local Inner Class
//=> 메서드의 내부에 정의되는 InnerClass.
//=> 메서드내에 정의되는 지역변수와 같다 (즉, 메서드내에서만 사용됨)
//=> static Local_InnerClass는 허용 되지 않음
//   단, 상수는 허용



class Outer{//=========================================================================================Outer class
	
	class InstanceInner{//====================================================================InstanceInner class (Inner : Outer)
		int instanceValue = 100;
	}
	
	static class StaticInner{//==================================================================StaticInner class (Inner : Outer)
		int instanceValue = 200;
		static int staticValue = 300;
	}
	
	void myMethod() {//=========================================================================== myMethod method
		class LocalInner{//==========================================================================LocalInner class (Inner : Outer - myMethod )
			int instanceValue =400;
		}//로컬클래스인 LocalInner는 myMethod 안에서 생과 사를 이룸.
		LocalInner li = new LocalInner();
		System.out.println("myMethod 의 instanceValue"+li.instanceValue);
	}
	
}



public class Ex02_Inners {//============================================================================main method
	public static void main(String[] args) {
		//InstanceInner 생성 : 외부 클래스 인스턴스에 종속된 인스턴스를 생성
		Outer.InstanceInner ic = new Outer().new InstanceInner();
		System.out.println("!! InstanceInner test !!");
		System.out.println("InstanceInner 의 instanceVallue : "+ic.instanceValue);
		
		System.out.println();//---------------------------------------------------------------
		
		//StaticInner 생성
		System.out.println("!! StaticInner test !!");
		
		//static 멤버 :  외부 클래스의 인스턴스 없이 직접 접근 , 외부 클래스를 통해 접근
		System.out.println("StaticInner 의 staticValue : "+Outer.StaticInner.staticValue);
		
		//instance 멤버 : 내부 클래스의 인스턴스가 필요함.
		Outer.StaticInner sc = new Outer.StaticInner();
		System.out.println("StaticInner 의 instanceVallue : "+sc.instanceValue);

		System.out.println();//---------------------------------------------------------------
		
		//Local Inner 호출
		System.out.println("!! LocalInner test !!");
		//Outer ot = new Outer();
		//ot.myMethod();
		
		new Outer().myMethod();
		
	}
}

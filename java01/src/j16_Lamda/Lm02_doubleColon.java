package j16_Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//** 메서드 참조  람다식 ::
//:: ( double conlon operator , 정식 명칭은 method reference )
//=> 람다를 더 간결하게 표현하는 문법.
//=> 람다식이 하나의 메서드만을 호출하는 경우 메소드 참조로 람다식을 간단하게 표현.
//   메소드를 참조해서 매개변수의 정보 및 리턴타입을 미리 알아내어,
//   람다식에서 사용하는 매개변수를 생략하는 방식의 표현법.

//=> 대상::메소드 (대상은 클래스 또는 참조변수가 될수있음)
//   대상에서 메소드의 정보를 추출하여 람다식처럼 익명 구현객체를 생성하는것.
// 참조하는 메소드의 매개변수를 생략할 수 있음.
//=> ppt 4p 
//=> https://myhappyman.tistory.com/65

//** Generic 타입제한 (Wildcards_와일드카드타입 이용으로)
//=> <?>
//   Unbounded Wildcards (제한없음_모든 클래스나 인터페이스 타입 가능)
//=> <? extends ...>
//   Upper Bounded Wildcards (상위클래스 제한_같거나 하위 타입 가능)
//=> <? super ...>
//   Lower Bounded Wildcards (하위클래스 제한_ 같거나 상위타입 가능)


//===================================================================
// => void forEach(Consumer<? super String> action)
// => Consumer<? super String> : 같거나 상위타입 가능 (즉, String, Object)
// => Consumer 클래스 소스 확인    
//      - @FunctionalInterface
//    - void accept(T t);   
//      - 인자는 하나 전달 받고 return 하지않는 즉, 인자를 소비하는 형태의 추상메서드
//      - 그러므로 인자를 가지고 어떤 결과를 보여야 할때 유용하게 사용할 수 있음.  
/* => forEach 매서드의 매개변수로는 다음식의 우측 코드가 전달되어야함 
      Consumer<String> cc = new Consumer<String>() {
           @Overriding
           void accept(String s) { 
               System.out.println(s); 
           } 
      } 
   => 이 코드를 람다식으로 정리하면 아래처럼 됨
      마치 메서드가 매개변수로 전달되는것과 같은 효과를 줌      
*/

public class Lm02_doubleColon {
	public static void main(String[] args) {
		//1.기본적 반복문 출력.
		List<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
		colors.add("White");
		colors.add("Black");
		System.out.println("🐇. 기본 반복문 출력 ");
		for (String c : colors) {
			System.out.println("🐇. forEach =>"+c);
		}
		for (int i = 0; i < colors.size(); i++) {
			System.out.println("🐇. for =>"+colors.get(i));
		}
		System.out.println();
		System.out.println();
		System.out.println("🐼. 람다 적용 반복문 출력(forEach) ");
		colors.forEach(s->{System.out.println("🐼. forEach =>"+s);});
		// => forEach 는 리스트의 Data 를 하나씩 꺼내어 매개변수로 전달해줌 
        //    forEach 메서드는 Iterable 인터페이스의 default 메서드이고, 
        //    Collection 인터페이스에서 Iterable 인터페이스를 상속하고 있기에 호출가능함.
		System.out.println();
		System.out.println("🐶. 람다 적용 반복문 출력(forEach) ");
		colors.forEach(System.out::println);
		
        // 4. Function<T,R> 사용예
        // => T type 의 값을 받아 R type 으로 Return 하는 apply 추상메서드를 가지고 있음.
        //    R apply(T t); 
        /*
        Function<String, Integer> f1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String t) {
                return Integer.parseInt(t);
            }
        };
        */
		/*
		 * Function<String, Integer> f1 = (String t)-> { return Integer.parseInt(t); };
		 */
		 
		Function<String, Integer> f1 = t->Integer.parseInt(t);
		Function<String, Integer> f2 =Integer::parseInt;
		f1.apply("6");
		
		System.out.println();
		System.out.println("🐶. Function<T,R> (활용) ");
		System.out.println("🤬 (f1+f2) 연산 =>"+(f1.apply("100")+f2.apply("100")));
		
	}//main
}//class





package j18_Optional;

import java.util.Optional;

public class ex01_Start {

	public static void main(String[] args) {
		//1. Optional 생성
		Optional<String> opt1 = Optional.empty();
		Optional<String> opt2 = Optional.ofNullable("Hello");
		Optional<String> opt3 = Optional.ofNullable(null);
		
		System.out.println("opt1 =>"+opt1);
		System.out.println("opt1.isEmpty() =>"+opt1.isEmpty());
		System.out.println("opt1.isPresent() =>"+opt1.isPresent());
		
		System.out.println("opt2 =>"+opt2);
		System.out.println("opt2.isEmpty() =>"+opt2.isEmpty());
		System.out.println("opt2.isPresent() =>"+opt2.isPresent());
		System.out.println("opt2.get() =>"+opt2.get());
		
		System.out.println("opt3 =>"+opt3);
		System.out.println("opt3.isEmpty() =>"+opt3.isEmpty());
		System.out.println("opt3.isPresent() =>"+opt3.isPresent());
		System.out.println();
		System.out.println("ifPresent test");
		opt3.ifPresent(s -> System.out.println(s));
		opt2.ifPresent(System.out::println);
		System.out.println();
		opt2.ifPresentOrElse(System.out::println, () -> System.out.println("null"));// 값이 있는 애
		opt3.ifPresentOrElse(System.out::println, () -> System.out.println("null"));// 값이 없는 애
		System.out.println();
		String result2 = opt2.orElse(null);
		String result3 = opt3.orElse(null);
		System.out.println(result2);
		System.out.println(result3);
	}

}

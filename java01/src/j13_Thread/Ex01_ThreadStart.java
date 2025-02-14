package j13_Thread;

import java.util.Iterator;

//** Thread 클래스 구현
//=> Thread 를 적용할 수 있는 클래스를 구현
//1) Thread 클래스 상속
//2) Runnable interface 구현

//** 계층구조 : Runnable interface -> Thread 클래스
//=> Thread 클래스에 Thread 를 지원하는 다양한 메서드 들이 정의 되어있음 
//=> Thread 클래스 가 Runnable 을 구현함. 
// public class Thread implements Runnable { ....   }

//=> Thread 클래스의 생성자 중 Runnable을 매개변수로 하는 생성자가 있음
//   -> Runnable 을 구현한 MyThread02 생성시 이용됨
//    public Thread(Runnable target) {
//           this(null, target, "Thread-" + nextThreadNum(), 0);
//      }

//** run() 메서드
//=> thread 실행의 주체 메서드
// 생성된 thread 의 main 메서드
//=> thread 를 통해 실행하려는 기능 (객체가 해야되는 일) 을 여기에 작성함.
//=> start() 메서드 호출에 의해 실행됨.
// 자신의 일을 다 마치면 (run 메서드의 종료) 자동으로 소멸됨   
//** start() 메서드
//=> Thread 를 시작함 (Runnable 상태로)

//** 실습1. Thread 클래스 상속

class MyThread01 extends Thread{
	@Override
	public void run() {
		for (int i = 0 ; i<50 ; i++) {
			System.out.printf("Thread 01 i = %d , "
					+ "Thread01_name = %s %n", i ,getName());
		}
	}//run()
	
}//MyThread01

//** 실습2. Runnable interface 구현
class MyThread02 implements Runnable {
  @Override
  public void run() {
      for (int i=0; i<50; i++) {
          System.out.printf("** Thread02 i=%d, "
          		+ "Thread02_Name=%s \n", i, Thread.currentThread().getName());
          // => 조상인 Thread 에 정의된 getName() 호출
      } //for
  } //run()
} //MyThread02


public class Ex01_ThreadStart {

	public static void main(String[] args) {
		//1. 클래스 활용
		MyThread01 th01 = new MyThread01();
		//다형성 이용
		Thread th02 = new MyThread01();
		
		//2.인터페이스 활용
		MyThread02 r01 = new MyThread02();
		Runnable r02 = new MyThread02(); 
		
		Thread rth01 = new Thread(r01);
		//Thread rth02 = new Thread(r02);
		Thread rth02 = new Thread(new MyThread02());
		
		rth01.start();
		rth02.start();
		
		
		//run() 메서드만 호출됬을 뿐, 스레드가 적용된것은 아님.
		// => multi thread 는 실행되지 않고 main 이 일반 메서드 호출 & 실행.  
		//th01.run();
		//th02.run();
		
			
		//스레드 적용
		//th01.start();
		//th02.start();
		
		System.out.println("main 정상 종료");
	}//main
}//Ex01_ThreadStart

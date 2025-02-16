package j13_Thread;

// 2. 메서드에 synchronized block(영역) 지정
// => 동기화를 지정하지않은 경우와 지정한경우 비교
//    동기화전 : 입.출금 결과 균형, count 안맞음  
//    동기화후 : 입.출금 결과 균형, count 모두 정확
//    단, 실행 순서는 실행시마다 다를수 있음

class Calculator {
	int count = 0; // 연산 횟수 Count
	int iTot = 10000;
	int uTot = 10000;

	// 입금 ( U -> I 에게 입금)
	// ** 동기화 전 -> 후
	public void add(int m) {
		count++;
		iTot += m;
		uTot -= m;
		System.out.printf("*입금 iTot=%d, uTot=%d, count=%d \n", iTot, uTot, count);
	} // add
//	public void add(int m) {
//		synchronized (this) {
//			// this : 동기화 대상을 알리는 용도
//			//     => 즉, 호출된 인스턴스의 메서드를 대상으로 한다는 의미
//			count++;
//			iTot +=m;
//			uTot -=m;
//			System.out.printf("**add iTot=%d, uTot=%d, count=%d \n", iTot, uTot, count);
//		} //synchronized
//	} //add

	// 출금 (I-> U 에게 입금)
	// ** 동기화 전 -> 후
//	public void min(int m) {
//		count++;
//		iTot -=m;
//		uTot +=m;
//		System.out.printf("*출금 iTot=%d, uTot=%d, count=%d \n", iTot, uTot, count);
//} //min	
	public void min(int m) {
		synchronized (this) {
			count++;
			iTot -= m;
			uTot += m;
			System.out.printf("**min iTot=%d, uTot=%d, count=%d \n", iTot, uTot, count);
		} // synchronized
	} // min

	// 총연산 횟수 출력
	public void showCount() {
		System.out.printf("*총연산 횟수 = %d \n", count);
	}
} // Calculator

class AddThread extends Thread {
	Calculator cal;

	// 생성자로 초기화
	AddThread(Calculator cal) {
		this.cal = cal;
	}

	@Override
	public void run() {
		cal.add(1000);
		cal.add(1000);
	} // run
} // AddThread

class MinThread extends Thread {
	Calculator cal;

	// 생성자로 초기화
	MinThread(Calculator cal) {
		this.cal = cal;
	}

	@Override
	public void run() {
		cal.min(700);
		cal.min(700);
	} // run
} // MinThread

public class Ex05_sync02Block {

	public static void main(String[] args) {
		// 생성
		Calculator cal = new Calculator();

		AddThread at1 = new AddThread(cal);
		MinThread mt1 = new MinThread(cal);
		AddThread at2 = new AddThread(cal);
		MinThread mt2 = new MinThread(cal);
		AddThread at3 = new AddThread(cal);
		// 실행
		at1.start();
		mt1.start();
		at2.start();
		mt2.start();
		at3.start();
		try {
			at1.join();
			mt1.join();
			at2.join();
			mt2.join();
			at3.join();
		} catch (Exception e) {
			System.out.println("** main Exception => " + e.toString());
		}
		// 결과 확인
		cal.showCount();
		System.out.println("** Main Stop **");
	} // main

	/*
	 * 동기식 결과 add iTot=11000, uTot=9000, count=1 add iTot=12000, uTot=8000, count=2
	 ** min iTot=11300, uTot=8700, count=3 min iTot=10600, uTot=9400, count=4 add
	 * iTot=11600, uTot=8400, count=5 add iTot=12600, uTot=7400, count=6 min
	 * iTot=11900, uTot=8100, count=7 min iTot=11200, uTot=8800, count=8 add
	 * iTot=12200, uTot=7800, count=9 add iTot=13200, uTot=6800, count=10 총연산 횟수 =
	 * 10
	 * 
	 */

} // class
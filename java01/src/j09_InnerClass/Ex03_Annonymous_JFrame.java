package j09_InnerClass;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//** 익명 클래스의 활용예
//=> 이벤트 리스너를 이용하여 종료버튼 만들기




public class Ex03_Annonymous_JFrame extends JFrame {
	public static void main(String[] args) {
		//1. UI 준비
		Ex03_Annonymous_JFrame ex03 = new Ex03_Annonymous_JFrame();
		//JFrame 를 상속받았기 때문에 기본 메서드들을 사용 할 수 있다.
		Button btn = new Button("STOP");
		
		ex03.setSize(300,300);
		ex03.add(btn);
		ex03.setVisible(true);
		
		//종료 버튼 만들기
//		ActionListener ac = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(e.getActionCommand().equals("STOP")) {
//					System.exit(0);
//				}
//			}
//		};
//		btn.addActionListener(ac);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("STOP")) {
					System.exit(0);
				}
			}
		});
	}
}

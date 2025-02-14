package j02_ifSwitch;

public class Ex02_if_elseif {

	public static void main(String[] args) {
		// 등급처리
		// score 90 이상 : A / 80 이상 : B / 70 이상 : C / 60 이상 : D / 아니면 F
		
		int score = 75;
		char grade ;
		
		if(score>=90) {
			grade = 'A';
			if(score ==100) System.out.println("100점 ,장학금지급");
		}else if (score>=80) {
			grade = 'B';
		}else if (score>=70) {
			grade = 'C';
		}else if (score>=60) {
			grade ='D';
		}else {
			grade = 'F';
			
		}
		System.out.printf("score 는 %d , gade는 %c %n",score,grade);
		//결과 : score 는 75 , gade는 C
		
		// 구문 비교
		if(score>=90) grade='A';
		if(score>=80) grade='B';
		if(score>=70) grade='C';
		if(score>=60) grade='D';
		else grade='F';
		System.out.printf("score 는 %d , gade는 %c %n",score,grade);
		//결과 : score 는 75 , gade는 D 

		//중첩 if 로 변경해보기.
		if(score>=90) {//90이상
			grade = 'A';
			if(score ==100) System.out.println("100점 ,장학금지급");
			//if( ( score > 90) < 95) 관계식을 통해 true /false로 나오기 때문에 숫자와의 비교를 할 수 없다. 
				
		}else {//90미만
			if (score>=80) {//80이상
				grade = 'B';
			} else {//80미만
				if (score>=70) { //70이상
					grade ='C';
				} else {//70미만
					if (score>=60) { //60이상
						grade = 'D';
					} else {//60미만
						grade = 'F';
					}
				}
			}
		}
		
		//switch 문으로 만들기
		switch (score/10) {
		case 10 : //100점이 들어오면 break 가 없어서 9로 진행.
		case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
		default:
			grade='F';
			break;//default 의 break 는 생략가능
		}
		System.out.printf("score 는 %d , gade는 %c %n",score,grade);
		//결과 : score 는 75 , gade는 C 
		
		//if ..elseif 와 switch 의 차이
		//if/else 는 조건이 맞을때 까지 구문을 거쳐가지만 
		//switch 는 맞는 조건을 찾아서 구문을 찾아가기 때문에
		//cpu의 입장에서의 효율성은 switch가 더 효율적이라고 볼 수 있다. 
	}

}

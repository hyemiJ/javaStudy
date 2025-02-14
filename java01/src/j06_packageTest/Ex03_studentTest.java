package j06_packageTest;

import j05_classMethod.Car;

//student class 정의 .
//인스턴스 5개를 배열로 담음.
//성적 순으로 출력.
//멤버변수 : id name 과목(java , spring , mysql)
// 생성자로 초기화 할것.
//인스턴스 5개 이상 배열에 담고 출력. 출력순서가 성적순(내림차순).
// 출력순서 :
//no: 성적순
//id : 
//name : 
//점수 : 
//합계 : 
//평균 : 

class Student {
    private String id;
    private String name;
    private int java;
    private int spring;
    private int mysql;


    // 기본 생성자
    public Student() {
    }

    // 초기화 생성자
    public Student(String id, String name, int java, int spring, int mysql) {
        this.id = id;
        this.name = name;
        this.java = java;
        this.spring = spring;
        this.mysql = mysql;
    }

    // getter 및 setter 메서드
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public int getMysql() {
        return mysql;
    }

    public void setMysql(int mysql) {
        this.mysql = mysql;
    }

    public double average() {
        int add = java + spring + mysql;
        return add / 3.0;
    }

    // toString 메서드
    @Override
    public String toString() {
        return " [id=" + id + "\n name=" + name +
                "\n 성적 : java=" + java + ", spring=" + spring + ", mysql=" + mysql +
                "\n 합계 : " + (java + spring + mysql) +
                "\n 평균 : " + average() +
                "]";
    }
}


public class Ex03_studentTest {
	
    //Ex01_ClassToClass 관계 테스트를 위한 추가.
    public static Car car = new Car();
    
    public static void studentSort(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].average() < arr[j].average()) {
                    Student temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student st1 = new Student("일번", "단무지", 10, 20, 30);
        Student st2 = new Student("이번", "오이", 50, 20, 30);
        Student st3 = new Student("삼번", "당근", 50, 55, 56);
        Student st4 = new Student("사번", "계란", 32, 12, 50);
        Student st5 = new Student("오번", "우엉", 50, 100, 100);

        Student[] studentList = {st1, st2, st3, st4, st5};
        studentSort(studentList);
        
        for (Student student : studentList) { 
        	int count = 1;
        	System.out.println("no : "+ count);
            System.out.println(student);
            System.out.println();
            count++;
        }
    }
}


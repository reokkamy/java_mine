package ch4;

public class QuizMain {
    public static void main(String[] args) {

        Quiz1 Quiz11 = new Quiz1();
        Quiz11.name = "사탕";
        Quiz11.number = "1111";
        Quiz11.company = "쿠팡";

        Quiz11.showInfo();
        System.out.println("-----------------");

        Quiz1 Quiz12 = new Quiz1("세제", "2222", "네이버"); // 매개변수 생성자 호출
        Quiz12.showInfo();
        System.out.println("-----------------");

        Quiz1 Quiz13 = new Quiz1("비누", "3333", "다음"); // 매개변수 생성자 호출
        Quiz13.showInfo();
        System.out.println("-----------------");

        Quiz1 Quiz14 = new Quiz1("과자", "8444");
        Quiz14.company = "홈플러스";
        Quiz14.showInfo();
        System.out.println("-----------------");

        Quiz1 Quiz15 = new Quiz1("생수");
        Quiz15.number = "9442";
        Quiz15.company = "이마트";
        Quiz15.showInfo();
        System.out.println("-----------------");

    }

}
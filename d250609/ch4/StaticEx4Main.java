package d250609.ch4;

public class StaticEx4Main {
    public static void main(String[] args) {
        // 예시 인스턴스 3개 생성 후, 생성된 전체 숫자 확인.
        StaticEx4 staticEx4_1 = new StaticEx4("이상용1");

        // 전체 숫자 확인.
        System.out.println("총 수 확인 ");
        StaticEx4.showInfoTotal();

        StaticEx4 staticEx4_2 = new StaticEx4("이상용2");
        System.out.println("총 수 확인 ");
        StaticEx4.showInfoTotal();

        StaticEx4 staticEx4_3 = new StaticEx4("이상용3");
        System.out.println("총 수 확인 ");
        StaticEx4.showInfoTotal();

    }
}

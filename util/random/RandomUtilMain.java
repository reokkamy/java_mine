package util.random;

public class RandomUtilMain {
    // 메인 메소드가 있는 클래스, 실행용 클래스
    public static void main(String[] args) {
        System.out.println("Math.random()를 사용하여 생성된 난수: " + RandomUtil.generateRandom());
        System.out.println("1이상 45 이하 사이의 랜덤 정수: " + RandomUtil.generateRandomInRange(1, 45));
        // 랜덤한 숫자를 생성하는 기능.
        // 로또 번호 생성 기능을 호출
        System.out.println("나만의 로또 번호 생성기 프로그램");
        RandomUtil.generateLottoNumbers();
    }
}

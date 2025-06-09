package util.random;

public class RandomUtil_doc {
    // 설계 클래스
    // Math 클래스에 있는 random() 메소드를 사용하여
    // 0.0 이상 1.0 미만의 난수를 생성하는 메소드를 작성
    // 기본 기능 확인용, 정적 메서드 추가해보기.
    public static double generateRandom() {
        // 데이터 타입 : double, 변수명 : randomValue
        // Math 클래스의 정적 메소드 random()를 호출하여
        double randomValue = Math.random();
        return randomValue;
    }

    // 특정 범위의 난수를 생성하기. 실수 -> 정수 형태로 변경.
    // 1 이상 10 이하의 난수를 생성하는 메소드 작성
    public static int generateRandomInRange(int min, int max) {
        // Math.random()을 사용하여 0.0 이상 1.0 미만의 난수를 생성
        // 이를 이용하여 원하는 범위의 정수 난수를 생성

        // 설명 1. Math.random() : 0.0 이상 1.0 미만의 난수를 생성
        // 결과 모양 0.0 <= x < 1.0 ,

        // 예시) min = 1, max = 10
        // 설명 2. Math.random() * (max - min + 1)
        // 결과 모양 0.0 <= x < 10.0
        //
        // 형변환 연산자, 캐스팅 연산자라고 하고, 기호는 소괄호를 사용.
        // 예시 )
        // (변환하고 싶은 타입) 원래 데이터
        // 예시) (int) Math.random() * (max - min + 1)

        // 설명 3. (int) Math.random() * (max - min + 1) : double 타입을 int 타입으로 변환
        // 결과 모양 0 <= x < 10

        // 설명 4. (int) Math.random() * (max - min + 1) + min
        // 결과 모양 1 <= x < 11
        // -> 1 <= x <= 10
        int randomValue = (int) (Math.random() * (max - min + 1)) + min;
        return randomValue;
    }

    // 퀴즈1
    // 로또 번호를 생성하는 기능을 만들기.
    // 아직 배열 안배워서, 각각의 6자리 숫자를 따로 받아서,
    // 출력만 한번에 생성하는 기능으로,
    // 정적 메소드를 만들어서, 출력 문장에서, 랜덤 숫자 6개 보여주기 형식으로 하기.
    // 출력문 모양: 이상용의 자동 로또 번호 생성기 사용한 번호 : 1, 20 ,30, 11, 17 ,45
    // 조건문을 활용해서, 중복된 숫자가 발생 안하게끔 , 해보기
    public static void generateLottoNumbers() {
        // 로또 번호를 생성하는 기능을 구현
        // 1부터 45까지의 숫자 중에서 중복되지 않는 6개의 숫자를 생성
        // 예시 출력: 이상용의 자동 로또 번호 생성기 사용한 번호 : 1, 20, 30, 11, 17, 45

        // 첫번째 숫자 생성
        int n1 = generateRandomInRange(1, 45);

        // 두번째 숫자 생성
        int n2; // 일단 정의만 먼저하고, 초기화 값 할당은 뒤에 하기.
        do {
            // 실제 값 할당은 뒤에서 하고,
            n2 = generateRandomInRange(1, 45);
        } while (n2 == n1); // 중복 체크

        // 세번째 숫자 생성
        int n3;
        do {
            n3 = generateRandomInRange(1, 45);
        } while (n3 == n1 || n3 == n2); // 중복 체크

        // 네번째 숫자 생성
        int n4;
        do {
            n4 = generateRandomInRange(1, 45);
        } while (n4 == n1 || n4 == n2 || n4 == n3); // 중복 체크

        // 다섯번째 숫자 생성
        int n5;
        do {
            n5 = generateRandomInRange(1, 45);
        } while (n5 == n1 || n5 == n2 || n5 == n3 || n5 == n4); // 중복 체크

        // 여섯번째 숫자 생성
        int n6;
        do {
            n6 = generateRandomInRange(1, 45);
        } while (n6 == n1 || n6 == n2 || n6 == n3 || n6 == n4 || n6 == n5); // 중복 체크

        // 로직 구현은 생략하고, 출력문만 작성
        System.out.println("이상용의 자동 로또 번호 생성기 사용한 번호 : "
                + n1 + ", " + n2 + ", " + n3 + ", " + n4 + ", " + n5 + ", " + n6);

    }
}

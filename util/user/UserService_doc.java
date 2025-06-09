package util.user;

import java.util.Scanner;

public class UserService_doc {
    // 회원 가입 기능, 정적 메소드 생성.
    // 콘솔로 입력을 받고, 결과를 문자열로 반환하는 기능을 포함.
    // 추후 업그레이드는 반환 타입을 : 문자열에서, 사용자 클래스 객체로 변경 예정.
    // 메인 메소드가 없음, 왜냐하면, 실행을 여기서 안함.
    // 이런 클래스를 , 설계용 클래스.
    public static void registerUser(Scanner scanner) {
        // Scanner 객체를 매개변수로 받기,
        // 해결책 1, 각 메서드에서, 공용으로 사용을 할 스캐너를 받는 변수를 정의
        System.out.println("이상용 홈피 회원가입");
        // 순서1, Scanner 객체 생성
        // Scanner scanner = new Scanner(System.in);

        // 순서2, 이름 입력 받기
        System.out.println("이름 입력해주세요 > ");
        String name = scanner.nextLine(); // 이름 입력 받기
        // 순서3, 이메일 입력 받기
        System.out.println("이메일 입력해주세요 > ");
        String email = scanner.nextLine(); // 이메일 입력 받기
        // ====================================================================================
        // 패스워드 입력 확인 후, 다음 단계로 넘어가기
        String password;
        // while 문에서, 패스워드 부분이 입력이 맞으면 다음 단계, 아니면 , 계속 확인하기.
        while (true) {
            System.out.println("패스워드 입력해주세요 > ");
            password = scanner.nextLine(); // 패스워드 입력 받기

            System.out.println("패스워드 확인 입력해주세요 > ");
            String password2 = scanner.nextLine(); // 패스워드 입력 받기

            // 패스워드가 비어있지 않은지 확인
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
            } else if (password.equals(password2)) { // 패스워드와 확인 입력이 일치하는지 확인
                System.out.println("패스워드가 일치합니다");
                break; // 패스워드가 일치하면 루프 종료
            } else {
                System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }
        // ====================================================================================
        // 순서4, 패스워드 입력 받기
        // System.out.println("패스워드 입력해주세요 > ");
        // String password = scanner.nextLine(); // 패스워드 입력 받기

        // 순서5, 입력 받은 내용 출력
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
        System.out.println("회원 가입 완료되었습니다.");

        // 순서6, scanner 닫기
        // scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지
        // 메인에서, 한번에 다 사용후 , 자원 반납

    }

    // 콘솔로 이메일 입력받고, 패스워드 입력 받기.

    // 검증 없이, 단순 로그인 정보만 출력하기.

    // 힌트는 모두 문자열 해도 좋습니다.
    // 로그인 이메일 입력해주세요 >
    // 로그인 패스워드 입력해주세요 >

    // 출력 결과는
    // 로그인 이메일 정보 : {이메일}
    // 로그인 패스워드 정보 : {패스워드}
    // 로그인 완료되었습니다. 현재 임시로 단순 출력용입니다. 조금 있다. 검증도 추가 해보기
    public static void loginUser(Scanner scanner) { //
        // 해결책 1, 각 메서드에서, 공용으로 사용을 할 스캐너를 받는 변수를 정의
        System.out.println("이상용 홈피 로그인");
        // Scanner scanner = new Scanner(System.in); // 이슈 , 발생 ,

        String email = ""; // 이메일 변수 초기화
        String password = ""; // 패스워드 변수 초기화
        while (true) {
            // 순서1, 이메일 입력 받기
            System.out.println("이메일 입력해주세요 > ");
            email = scanner.nextLine(); // 이메일 입력 받기

            // 이메일이 비어있으면, 다시 입력 받기
            if (email.isEmpty()) {
                System.out.println("이메일은 비워둘 수 없습니다. 다시 입력해주세요.");
                continue; // 다시 입력 받기 -> while 루프의 처음으로 돌아감 -> 계속 반복 진행한다.
            }

            // 순서2, 패스워드 입력 받기
            System.out.println("패스워드 입력해주세요 > ");
            password = scanner.nextLine(); // 패스워드 입력 받기

            // 패스워드가 비어있으면, 다시 입력 받기
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
                continue; // 다시 입력 받기
            }
            // emai: admin@naver.com , pasword: 1234로 가정하고, 일치시 다음으로 진행하기.
            if (email.equals("admin@naver.com") && password.equals("1234")) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("로그인 실패, 이메일 또는 패스워드를 확인해주세요.");
                continue; // 다시 입력 받기

            }

            // 유효성 체크 완료 후, 루프 종료
            break;

        }
        // System.out.println("이메일 입력해주세요 > ");
        // String email = scanner.nextLine(); // 이메일 입력 받기
        // System.out.println("패스워드 입력해주세요 > ");
        // String password = scanner.nextLine(); // 패스워드 입력 받기

        System.out.println("로그인 이메일 정보 : " + email);
        System.out.println("로그인 패스워드 정보 : " + password);
        System.out.println("로그인 완료되었습니다. 현재 임시로 단순 출력용입니다.");

        // 순서6, scanner 닫기
        // scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지
        // 메인에서, 한번에 다 사용후 , 자원 반납
    }

    // 퀴즈,
    // 클래스명, UserService_doc.java 여기서 작업 후,
    // 클래스명 , UserService.java로 복사해서 붙여넣기
    // 적용 클래스 : MainClass.java 실행 해보기.
    // 참고 내용은.
    // String password;
    // // while 문에서, 패스워드 부분이 입력이 맞으면 다음 단계, 아니면 , 계속 확인하기.
    // while (true) {
    // System.out.println("패스워드 입력해주세요 > ");
    // password = scanner.nextLine(); // 패스워드 입력 받기

    // System.out.println("패스워드 확인 입력해주세요 > ");
    // String password2 = scanner.nextLine(); // 패스워드 입력 받기

    // // 패스워드가 비어있지 않은지 확인
    // if (password.isEmpty()) {
    // System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
    // } else if (password.equals(password2)) { // 패스워드와 확인 입력이 일치하는지 확인
    // System.out.println("패스워드가 일치합니다");
    // break; // 패스워드가 일치하면 루프 종료
    // } else {
    // System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.");
    // }
    // }

    // 유효성 체크를 , 로그인에도 적용해보기.
    // 로그인에서, 데이터 베이스가 없으니, email: admin@naver.com, 패스워드: 1234로 가정하고,
    // 일치 하는 경우에만, "로그인 성공" 메시지 출력,
    // 일치하지 않는 경우, "로그인 실패" 메시지 출력.
    // 이메일 비워져 있으면, "이메일은 비워둘 수 없습니다." 메시지 출력,
    // 패스워드 비워져 있으면, "패스워드는 비워둘 수 없습니다." 메시지 출력.
}

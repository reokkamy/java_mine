package homework._0605.ch4;

import java.util.Random;
import java.util.Scanner;

import util.date.*;
import util.model.Member;

public class Homework_func {

    // 퀴즈
    // 폴더 만들기 -homework
    // homework 폴더 안에,-> 0605 폴더 ->
    // ch4 폴더 -> 기능 클래스 만들기, 실행 클래스 만들기, 모델 클래스 만들기.
    // 자동차 관리 프로그램 만들기,
    // 자동차 정보 1) 자동차명, 2) 제조사, 3) 연식, 4) 등록일로 구성,
    // 메서드 : showInfo() 메서드 만들기,
    // 자동차 정보 CRUD , 추가, 조회, 수정, 삭제 기능 , 검색, 더미데이터 추가 구현.
    // 최대한 강사 코드 재사용해서 복습하기.

    static final int MAX_USERS = 100;

    static Homework_model[] cars = new Homework_model[MAX_USERS];

    static int userCount = 0; // 현재 등록된 회원 수

    // 회원 추가 메서드
    public static void addCar(Scanner scanner) {
        if (userCount < MAX_USERS) { // 기본 유효성 체크
            System.out.println("자동차명을 입력하시오: ");
            String name = scanner.nextLine();

            System.out.println("제조사를 입력하시오: ");
            String company = scanner.nextLine();

            System.out.println("연식을 입력하시오: ");
            String model_year = scanner.nextLine();

            // 현재 날짜와 시간 저장
            String registrationDate = DateUtil.getCurrentDateTime();

            // 사용자들로 부터 입력 받은 정보를, 모델 클래스의 인스턴스 생성 하는 곳에 사용.
            Homework_model car = new Homework_model(name, company, model_year, registrationDate);

            cars[userCount] = car;
            // 회원 수 증가
            userCount++;
            System.out.println("자동차가 추가되었습니다: " + name + ", " + model_year + ", " + registrationDate);
        } else {
            System.out.println("자동차수가 최대치를 초과했습니다.");
        }
    } // 회원 추가 메서드

    // 회원 조회 메서드
    public static void viewCars() {
        if (userCount == 0) {
            System.out.println("등록된 자동차가 없습니다.");
            return; // 등록된 회원이 없을 때, 조회 기능 종료, 메서드(함수)를 나가기
        }
        System.out.println("등록된 자동차 목록:");
        for (int i = 0; i < userCount; i++) {
            System.out.println("========== 인덱스: " + i + " ==========");
            cars[i].showInfo();
            System.out.println("-------------------------------");

        }
    } // 회원 조회 메서드

    // 회원 수정 메서드
    // 회원 전체 목록에서, 해당 회원의 인덱스를 번호를 이용해서, 회원 정보를 수정해보기.
    public static void updateCar(Scanner scanner) {
        System.out.println("수정할 자동차의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 수정할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거
        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        System.out.println("수정할 자동차의 이름을 입력하세요: ");
        String name = scanner.nextLine();
        // names[index] = name; // 이름 수정

        System.out.println("수정할 자동차의 연식 입력하세요: ");
        String model_year = scanner.nextLine();
        // model_years[index] = model_year; // 이메일 수정

        System.out.println("수정할 자동차의 제조사를 입력하세요: ");
        String company = scanner.nextLine();
        // companys[index] = company; // 패스워드 수정

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();
        // registrationDates[index] = registrationDate; // 등록일 수정

        // 변경할 정보를 담아둘 Member 객체 생성
        Homework_model car = new Homework_model(name, company, model_year, registrationDate);
        // 해당 인덱스에 수정된 회원 정보 저장
        cars[index] = car;

        System.out.println(" 정보가 수정되었습니다: " + name + ", " + model_year + ", "
                + registrationDate);
    } // 회원 수정 메서드

    // 회원 삭제 메서드
    // 수정 처럼, 회원의 인덱스 번호를 입력시, 삭제하는 로직.
    public static void deleteCar(Scanner scanner) {
        System.out.println("삭제할 자동차의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }

        // 삭제할 회원 정보 출력
        // members 의 모양 : members = {member1, member2, member3, ...}
        // 배열에서 원소를 꺼내서, 다시 변수에 담을 때, 해당 클래스 타입으로 담기.
        Homework_model car = cars[index];
        System.out.println("삭제할 정보: ");
        car.showInfo(); // 회원 정보 출력

        for (int i = index; i < userCount - 1; i++) {
            cars[i] = cars[i + 1]; // 다음 인덱스의 회원 정보를 현재 인덱스로 이동
        }
        // 마지막 인덱스의 회원 정보는 null로 설정
        cars[userCount - 1] = null; // 마지막 인덱스의 회원 정보 삭제

        // 회원 수 감소
        userCount--;
        System.out.println("정보가 삭제되었습니다.");
    }
    // 회원 삭제 메서드

    // 회원 더미 데이터 5개 추가하는 메서드
    public static void addDummy() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            if (userCount < MAX_USERS) {
                int year = rand.nextInt(2024 - 1990 + 1) + 1990;
                String modelYear = year + "년식";

                Homework_model dummyMember = new Homework_model(
                        "더미" + (i + 1),
                        "company" + (i + 1),
                        modelYear,
                        DateUtil.getCurrentDateTime());
                // members 배열에 더미 회원 정보 추가
                cars[userCount] = dummyMember;

                userCount++;
            } else {
                System.out.println("더미 추가 실패: 최대 정보 수 초과");
                break;
            }
        }
        System.out.println("더미 5대가추가되었습니다.");
    }
    // 회원 더미 데이터 5개 추가하는 메서드

    // 검색 기능
    // 회원 목록에서 이름 또는 이메일로 검색하는 기능을 추가할 수 있습니다.
    public static void searchCar(Scanner scanner) {
        System.out.println("검색할 자동차 이름 또는 연식을 입력하세요: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < userCount; i++) {
            // 변경, Member , getName(), getmodel_year() 메서드 사용, 이용해서 검색 기능 구현하기.
            if (cars[i].getName().contains(searchQuery) || cars[i].getModelYear().contains(searchQuery)) {
                // System.out.println("검색 결과: " + (i + 1) + ". " + names[i] + ", " +
                // model_years[i] +
                // ", "
                // + registrationDates[i]);
                cars[i].showInfo(); // 회원 정보 출력
                found = true;
            }
        }

        if (!found) { // 검색 결과가 있을 경우, 실행이 안됨, found = true; -> false;
            System.out.println("검색 결과가 없습니다.");
        }
    }
    // 검색 기능

}

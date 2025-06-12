package d250612.member_project.model;

// 변경사항, 
// 기존,
// 1) 메모리 상에서 데이터를 임시로 저장,  배열 -> 컬렉션(ArrayList, HashMap)
// 변경, 
// 파일 형식으로 데이터를 저장, 불러오기 작업, 
// 파일 형식: member.txt -> 실제 구조 csv 파일 형식 -> 콤마를 기준으로 데이터를 구분 형식. 
// 예시) 이름,이메일,패스워드,등록날짜
// 회원 관리 프로그램 시작 -> 파일에서 데이터를 불러오고 -> 임시로 ArrayList  저장 ->
// 추가, 수정, 삭제 -> 파일에 저장 

// 주석, 추가 사항 1 형식으로 라벨링 작업.
public class Member {
    String name;
    String password;
    String email;
    String regDate;

    // ====================================================================
    // 추가사항1
    // 회원의 정보 내용을 csv 형식으로 문자열 한줄 반환 기능.
    // 멤버 정보 , 예) 이상용,1234,lsy@naver.com,2025-06-12 10시10분
    public String toCSV() {
        return name + "," + password + "," + email + "," + regDate;
    }

    // 추가사항2
    // 매개변수의 정보 : 타입 문자열 ,
    // 내용 : 아래의 예) 의 형태입니다.
    // 한줄의 멤버의 정보를 : 예) 이상용,1234,lsy@naver.com,2025-06-12 10시10분
    //
    // Member 인스턴스를 생성하는 재료로 사용할 예정.
    // 매개변수가 4개인 인스터스 생성하는 기능.
    public static Member fromCSV(String csvLine) {
        // 시뮬레이션1
        // String csvLine = "이상용,1234,lsy@naver.com,2025-06-12 10시10분"
        String[] parts = csvLine.split(",", -1); // -1 , 없는 데이터 있어도, 그 자리 형태를 유지, 정보 4개형태,
        // 시뮬레이션2
        // parts = {"이상용","1234,"lsy@naver.com","2025-06-12 10시10분"}
        if (parts.length != 4) {
            return null;
        }
        return new Member(parts[0], parts[1], parts[2], parts[3]);
    }
    // ====================================================================

    public Member(String name, String password, String email, String regDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.regDate = regDate;
    }

    public void showInfo() {
        System.out.println("회원 이름 : " + this.name);
        System.out.println("회원 이메일 : " + this.email);
        System.out.println("회원 패스워드 : " + this.password);
        System.out.println("회원 등록일 : " + this.regDate);
    }

    public String getName() {
        return name;
    }

    // 이메일 조회 기능, 게터 getter
    public String getEmail() {
        return email;
    }
}

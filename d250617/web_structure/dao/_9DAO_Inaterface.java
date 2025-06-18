package d250617.web_structure.dao;

import java.util.List;

import d250617.web_structure.dto._10Member;

// DAO(Data Access Object) , : DB 에 접근하는 기능 모음집
// CRUD, 검색, 한명 조회, 필터 등. 
// 인터페이스를 만들기 -> 이걸 구현하는 클래스 형식 -> 느슨한 결합 작업. 
// 스프링의 기본 뼈대 작업 방식. 

// DTO(Data Transfer Object) : DB 에 전달하는 모델 클래스 
// 데이터베이스 , 회원의 정보를 각각 따로 전달하기보다는, 모델 클래스에 담아서, 인스턴스로 전달. 

public interface _9DAO_Inaterface {
    // 자바 특성, 클래스 끼는 단일 상속 만 가능해서,
    // 다양한 기능을 추가하는데 한계가 있음.
    // 인터페이스는 다중 구현이 가능하게, 여러 기능 구현시, 굉장히 많이 사용함.
    //
    // 장점,)
    // 1) 사용하는 메서드들의 명세서(목록), 파악 쉽고,
    // 2) 유지 보수가 편함.
    // 3) 유지 보수시, 코드의 변경 및 적용이 적습니다.

    // 단점,)
    // 1) 복잡도 증가
    // 2) 소규모에서는 따로 분리를 안하려는 경향도 있음.
    // 3)

    // 인터페이스를 이용 안 할 경우 -> 유지 보수시, 변경 및, 변경으로 인하 수정 해야 할 부분이 늘어남.
    //
    // CRUD 내가 구현할 기능들의 목록 미리 만들기,
    // 구현체가 없음. 즉, 어떠한 메서드인지 , 추상적으로 모양만 만들고,
    // 실제 구현은 인터페이스를 구현한 클래스에서 구체적인 코드 작업함.

    // 1) 전체 조회
    // List 부모 타입, ArrayList 자식 타입, 다형성으로 받을수 있음.
    List<_10Member> findAll();

    // 2) 한명 회원 조회
    _10Member findById(int id);

    // 3) 회원 추가
    // 화면에서 입력 받은 정보 -> member -> 디비 입력 -> true
    boolean insert(_10Member member);

    // 4) 회원 수정
    boolean update(_10Member member);

    // 5) 회원 삭제
    boolean delete(int id);

    // 6) 회원 검색
    // 0618, 검색 작업 중1
    // 리턴을 한명의 인스턴스만 받구나, 수정하자, 리스트로
    // _10Member findByName(String name);
    List<_10Member> findByName(String name);

}

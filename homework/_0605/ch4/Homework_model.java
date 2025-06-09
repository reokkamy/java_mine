package homework._0605.ch4;

public class Homework_model {

    String name;
    String company;
    String model_year;
    String regDate;

    public Homework_model(String name, String company, String model_year, String regDate) {
        this.name = name;
        this.company = company;
        this.model_year = model_year;
        this.regDate = regDate;
    }

    public void showInfo() {
        System.out.println("자동차명 : " + this.name);
        System.out.println("제조사 : " + this.company);
        System.out.println("연식 : " + this.model_year);
        System.out.println("등록일 : " + this.regDate);
    }

    // 검색을 위해서, 해당 이름과, 이메일 정보를 조회 하는 기능,
    // 이름 조회 기능, 게터 , 자동 생성, 또는 라이브러리 사용해서, 자동 생성된 기능을 이용할 예정.
    // 또는 수동으로 만들어서 사용도 함.
    // 결론, 나중에 라이브러리 많이 사용함.,
    public String getName() {
        return name;
    }

    public String getModelYear() {
        return model_year;
    }

    // 이메일 조회 기능, 게터 getter
    public String getCompany() {
        return company;
    }
}

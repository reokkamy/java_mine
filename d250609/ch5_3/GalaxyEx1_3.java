package d250609.ch5_3;

public class GalaxyEx1_3 extends PhoneEx1_2 {
    // 자식 클래스
    //
    private String logo;

    public void logoInfo() {
        System.out.println("로고 모양 : " + logo);
    }
    // getter 만들고,

    public String getLogo() {
        return logo;
    }

    // 생성자 만들기., 우클릭으로 반자동으로 만들기 중.
    public GalaxyEx1_3(String company, String name, String price, String logo) {
        super(company, name, price);
        this.logo = logo;
    }

}

package d250610.ch5;

public class RectangleEx1 extends ShapeEx1 {
    // 자식 클래스만의 멤버를 구성.
    private int edgeCount;

    @Override
    public void draw() {
        System.out.println("사각형 모양 그리기");
    }
}

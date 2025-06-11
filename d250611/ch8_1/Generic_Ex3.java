package d250611.ch8_1;

import java.util.ArrayList;

public class Generic_Ex3<T> {
    // 제너릭을 이용한 Stack 자료구조,
    // FILO(First In Last Out)
    private ArrayList<T> list = new ArrayList<>();

    // 데이터 담기, 저장, set
    public void push(T value) {
        list.add(value);
    }

    // 데이터 꺼내기, 가져오기, get
    public T pop() {
        // 리스트에 데이터 유무 확인, - 유효성 체크
        if (list.isEmpty()) {
            return null;
        }
        // list = {1,2,3,4,5} // 현재 5개 있음.
        // list.size() : 총 5개 의미
        // list.size() - 1 : 마지막 인덱스 번호,
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        Generic_Ex3<Integer> stack = new Generic_Ex3<>();
        // 스택이라는 자료 구조에 반복문 이용해서, 샘플 값 5개 넣는 과정.
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        // 스택에서 데이터를 하나씩 꺼내는 과정이고,
        // 모두 다 꺼냈을 경우는 비워져 있다는 것을 표현하기.
        while (!stack.isEmpty()) {
            System.out.println("스택 자료 구조 형식으로 : 데이터 꺼내기 작업");
            System.out.println("값 : " + stack.pop());
        }

    }

}

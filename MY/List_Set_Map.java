package MY;

import java.util.ArrayList;
import java.util.Scanner;

public class List_Set_Map {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>(); // 이름을 저장할 리스트 생성

        // 이름 5개 입력받기
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + "번째 이름 입력: ");
            String name = scanner.nextLine(); // 사용자 입력
            names.add(name); // 리스트에 추가
        }

        // 저장된 이름 출력
        System.out.println("입력한 이름 목록:");
        for (String name : names) {
            System.out.println("- " + name);
        }

        scanner.close();
    }
}
package MY;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Set_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = new HashSet<>(); // 중복을 허용하지 않는 집합

        // 숫자 5개 입력받기 (중복은 저장 안 됨)
        while (numbers.size() < 5) {
            System.out.print("숫자 입력 (" + (numbers.size() + 1) + "/5): ");
            int num = scanner.nextInt();
            numbers.add(num); // 중복이면 자동으로 무시됨
        }

        // 저장된 유일한 숫자 출력
        System.out.println("저장된 숫자들 (중복 제거됨):");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        scanner.close();
    }
}
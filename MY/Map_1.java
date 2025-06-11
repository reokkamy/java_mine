package MY;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Map_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> studentScores = new HashMap<>();

        // 이름과 점수 3명 입력받기
        for (int i = 0; i < 3; i++) {
            System.out.print("학생 이름 입력: ");
            String name = scanner.next();

            System.out.print(name + "의 점수 입력: ");
            int score = scanner.nextInt();

            studentScores.put(name, score); // 이름과 점수를 Map에 저장
        }

        // 저장된 학생 정보 출력
        System.out.println("학생들의 점수 목록:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "점");
        }

        // 최고 점수 학생 찾기
        String topStudent = "";
        int maxScore = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                topStudent = entry.getKey();
            }
        }

        System.out.println("최고 점수 학생: " + topStudent + ", 점수: " + maxScore);

        scanner.close();
    }
}
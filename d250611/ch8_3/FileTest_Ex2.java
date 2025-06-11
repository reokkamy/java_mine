package d250611.ch8_3;

import java.io.File;

public class FileTest_Ex2 {
    public static void main(String[] args) {
        // 새로운 폴더 만들기, backup 폴더 만들기.
        // File dir = new File("backup");
        // dir.mkdir();

        // 2. 파일의 크기 확인 (용량 확인 )test.txt
        // File file = new File("test.txt");
        // System.out.println("파일 용량 확인 : " + file.length());

        // 3.현재 폴더의 모든 파일/폴더 이름 출력
        // File file = new File("D:\\0-java-vscode");
        // File file = new File(".");
        // // 문자열 타입을 가지는 배열에, 파일, 폴더 명을 담기
        // String[] names = file.list();
        // // 출력
        // for (String string : names) {
        // System.out.println("현재 폴더 안에 파일명 폴더명 조회 : " + string);
        // }

        // 4. 특정 폴더가 없으면 새로 만들기
        // File dir = new File("mydir");
        // if (!dir.exists()) {
        // dir.mkdir();
        // }
        // // 5. 특정 파일 삭제
        // File file = new File("k2.png");
        // if (file.isFile()) {
        // file.delete();
        // }
        // 6. 해당 파일 있으면 삭제, 없으면 생성
        try {
            File file = new File("input.txt");
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

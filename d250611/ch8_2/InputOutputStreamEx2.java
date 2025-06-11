package d250611.ch8_2;

import java.io.FileOutputStream;

public class InputOutputStreamEx2 {
    public static void main(String[] args) {
        // test.txt 파일에 hello 문자열를 저장하는 코드 작성.
        try {
            // test.txt 파일에 데이터를 출력하는 도구 만들기.
            FileOutputStream fos = new FileOutputStream("test.txt");
            // 파일 안에 작성할 내용을 추가하는 기능
            // 문자열 -> 바이트 단위로 변환한 작업.
            fos.write("hello 안녕하세요".getBytes());
            // 파일 입출력, 네트워크 통신, 디비 연결등 할 때, 반드시 자원 반납, Scanner close() 참고하기.
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

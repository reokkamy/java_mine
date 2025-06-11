package d250611.ch8_2;

import java.io.FileInputStream;

public class InputOutputStreamEx3 {
    public static void main(String[] args) {
        // 파일에서 한 바이트씩 읽어 화면에 출력
        // try ~ resource 구문, 문장안에 알아서, fis 자동으로 닫는 코드가 탑재가됨.
        // 그래서, 결론, 따로 fis.close() 작성 안해도 된다.
        // FileInputStream fis = new FileInputStream("test.txt"): 해당 파일을 메모리 상으로 읽은 상태
        // fis 담아져 있다.
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            int data; // 한 바이트씩 읽어서 임시로 담을 변수
            // a -> 유니코드 값으로 , 97
            // b -> 유니코드 값으로 , 98
            while ((data = fis.read()) != -1) { // 파일안에 데이터 다 읽을 때 까지 반복.
                // 97 -> a , 반환
                System.out.println((char) data);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

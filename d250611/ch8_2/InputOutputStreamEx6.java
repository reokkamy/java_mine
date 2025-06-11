package d250611.ch8_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// 버퍼링 
// 입출력 성능 향상을 위해 버퍼(메모리 임시 저장소, 배열) 활용, 성능 향상시키기 
// 데이터를 모아 한번에 처리, 속도 향상, 
// 기존에는 하나의 바이트 읽고, 한번 쓰기, 
// 기본 문법 
// BufferedReader br = new BufferedReader(new FileReader("a.txt")) , 읽기 도구 
// BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt")) , 쓰기 도구 
// 자주 사용하는 옵션 
// readLine() : 한줄 단위로 읽기 
// write(String) : 한줄 단위로 쓰기 
// flush() : 버퍼 내용을 강제 저장, 
// close() : 자원 반납 
public class InputOutputStreamEx6 {
    public static void main(String[] args) {
        // 예제 5에서 , 사용했던, 이미지 파일 복사하는 기능.
        // 성능 향상 시켜서, 모아서(버퍼) 쓰기 작업 해보기.
        try {
            // 원본 이미지를 바이트로 읽기 도구,
            FileInputStream fis = new FileInputStream("k2.png");

            // 원본 이미지를 바이트로 쓰기 도구,
            FileOutputStream fos = new FileOutputStream("copyk2.png");

            // 임시로 담을 공간 만들기 (메모리 = 버퍼 = 배열)
            byte[] buffer = new byte[1024]; // 1kb

            // 읽어서 임시로 담아둘 변수
            int data;

            // 기존에 : 1바이트 읽기,
            // 후 : 지정한 버퍼의 크기 만큼 읽기,
            // 후 : 지정한 버퍼의 크기 만큼 쓰기,
            while ((data = fis.read(buffer)) != -1) { // 이미지 파일의 내용을 끝까지 읽겠다.
                // 기존에 : 1바이트 쓰기,
                // 쓰기 작업. 지정한 크기 만큼씩 쓰기.
                System.out.println("data 값 : " + data);
                fos.write(buffer, 0, data);
            }
            System.out.println("이미지 파일 복사 완료");
            fis.close();
            fos.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

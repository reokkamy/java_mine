package d250611.ch8_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutputStreamEx5 {
    // 바이트 단위를 이용해서, 이미지를 읽기 / 쓰기 작업
    public static void main(String[] args) {
        try {
            // 원본 사진을 읽을 도구
            FileInputStream fis = new FileInputStream("k2.png");
            // 사진을 출력할 도구
            FileOutputStream fos = new FileOutputStream("copyk2.png");
            // 한 바이트를 읽어서 담아 둘 임시 변수
            int data;
            while ((data = fis.read()) != -1) { // 이미지의 마지막 픽셀 까지 읽겠다는 뜻.
                fos.write(data);
            }
            fis.close();
            fos.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

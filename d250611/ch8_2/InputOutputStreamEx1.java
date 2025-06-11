package d250611.ch8_2;

public class InputOutputStreamEx1 {
    // 입력, 출력에 대한 개념,
    // 스트림(Stream) : 데이터를 일렬로 흘려보내는 통로 (비유)
    // 입력 스트림 : 외부 -> 프로그램 (예: 파일 읽기, 키보드 입력)
    // 출력 스트림 : 프로그램 -> 외부 (예: 파일 쓰기, 화면 출력 )

    // 바이트 단위 I/O : InputStream / OutputStream
    // 문자 단위 I/O : Reader / Writer

    // 주의사항,
    // 1) 파일 입 출력, 의무적으로 , 예외처리를 해야함. try ~ catch ~ finally ,

    public static void main(String[] args) {
        // 키보드에서 한 글자를 입력받아 정수로 출력해보기.
        try {
            int data = System.in.read();
            System.out.println(data);
        } catch (Exception e) {
            // 오류가 발견 되는 과정을 추적해서 보여줄게요.
            e.printStackTrace();
        }
    }

}

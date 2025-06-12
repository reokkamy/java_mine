package d250612.member_project.main;

import java.util.Scanner;

import d250612.member_project.ui.MemberUI;
import d250612.member_project.service.UserService_ArrayList_version;

class MainClass {
    public static void main(String[] args) {
        // 추가 기능 반영
        // 시작 시, 파일 불러오기
        UserService_ArrayList_version.loadFromFile();
        Scanner scanner = new Scanner(System.in);
        MemberUI.drawUI(scanner);
    }

}
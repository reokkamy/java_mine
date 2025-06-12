package d250611.member_project.main;

import java.util.Scanner;

import d250611.member_project.ui.MemberUI;

class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberUI.drawUI(scanner);
    }

}
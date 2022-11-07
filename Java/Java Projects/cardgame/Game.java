package com.espresso.cardgame;

import java.util.Scanner;

public class Game {

    public static void play() {

        // �� �г��� �Է�
        System.out.print("���� ����� �г����� �Է��� �ּ���: ");
        Scanner scan = new Scanner(System.in);
        String my_name = scan.nextLine() + "(����)";

        // ���� ����
        Dealer dealer = new Dealer();

        // �Բ� �÷��� �� �÷��̾� �г��� �Է�
        String answer;
        while (true) {
            System.out.print("�Բ� �÷��� �� Player�� �߰��Ͻðڽ��ϱ�? (yes / no): ");
            answer = scan.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.print("Player�� �г����� �Է��� �ּ���: ");
                new Player(scan.nextLine());
            } else if (answer.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
            }
        }

        // �� ����
        new Player(my_name);

        // ����
        dealer.gambling();
    }

    public static void main(String[] args){
        play();
    }

}
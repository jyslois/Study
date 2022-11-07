package com.espresso.cardgame;

import java.util.ArrayList;

public class Dealer extends Gamer {
    // ���� �ݾ�
    private int bettingAmount;
    // ���� ī�带 ���� ���и� �Ǵ��ؾ� �ϱ� ������ PlayerŸ�� ���������� ����
    Player player;
    // ���̸Ӹ� ������ ������ �����ĺ���Ͽ� �߰��ϱ� ���� ��̸���Ʈ
    static ArrayList<Gamer> candidates = new ArrayList<>();
    // ���ڸ� ��� ���� ���� ����
    Gamer winner;
    // ���� ȸ���� ��� ���� ����
    static int game = 0;
    // ���� �ƽ� �ݾ�
    final static int MAX_BETTING = 500000;

    Dealer() {
        super("Dealer");
        candidates.add(this);
    }

    public int getBettingAmount() {
        return bettingAmount;
    }

    // ���� �ݾ� �������� ���� (1~50��������)�ϴ� �޼���
    void choosingBettingAmount() {
        this.bettingAmount = (int) (Math.random() * MAX_BETTING);
        System.out.println("-----------------------" + ++game + "ȸ�� ���� ����------------------------");
        System.out.println("���� �ݾ���: " + this.bettingAmount + "�� �Դϴ�.");
    }

    // ī�� �̾Ƽ� �����ִ� �޼���
    void drawCard() {
        Deck deck = new Deck();
        for (int i = 0; i < candidates.size(); i++) {
            Card card = deck.pick();
            candidates.get(i).receiveCard(card);
            System.out.println(candidates.get(i).name + "�� ���� ī�� - " + candidates.get(i).card + " || ���� ��: " + candidates.get(i).money);
        }
    }

    // ���� ã���ִ� �޼���
    void findWinner() {
        // ����Ʈ�� ���鼭 ���̸�.ī��.���ڸ� ���� max ã��
        int max = 0;

        for (int i = 0; i < candidates.size(); i++) {
            if (max <= candidates.get(i).card.number) {
                max = candidates.get(i).card.number;
            }
        }

        // max�� ���� ����� �Ǵٸ� ����Ʈ�� �����ؼ� �߰�
        ArrayList<Gamer> winningGamers = new ArrayList<>();

        for (int i = 0; i < candidates.size(); i++) {
            if (max == candidates.get(i).card.number) {
                winningGamers.add(candidates.get(i));
            }
        }

        if (winningGamers.size() != 1) {
            // ����� 1���� Ŭ ���, ���̸�.ī��.������ ���� ���� ū �� ã��
            int max_shape = 0;
            for (int i = 0; i < winningGamers.size(); i++) {
                if (max_shape < winningGamers.get(i).card.shape) {
                    max_shape = winningGamers.get(i).card.shape;
                }
            }
            // max_shape ����� ���� �����̸�, winner�� ����
            for (int i = 0; i < winningGamers.size(); i++) {
                if (max_shape == winningGamers.get(i).card.shape) {
                    winner = winningGamers.get(i);
                }
            }
            System.out.println("�̹� ���� ���ڴ�: " + winner.name);
        } else {
            // ����� 1�� ��� ���� ����
            winner = winningGamers.get(0);
            System.out.println("�̹� ���� ���ڴ�: " + winner.name);
        }

    }

    // ���ڴ� �����ݾ׿� ���ñݾ��� ���ϰ�, ���ڴ� ���ִ� �޼���
    void calculateMoney() {
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i) == winner) {
                candidates.get(i).money += bettingAmount;
                // ������ candidates.get(i).money += (bettingAmount * (candidates.size() - 1))�� ���־�� ������,
                // ������ ȸ���� �ʹ� ������Ƿ� �����ߴ�.
            } else {
                candidates.get(i).money -= bettingAmount;

            }
        }

        System.out.println("============================================================");
        for (int i = 0; i < candidates.size(); i++) {
            // ���� �ݾ� ����Ʈ
            System.out.println(candidates.get(i).name + ": " + candidates.get(i).money);
        }
    }

    // ���� �ݾ��� 0���� ���ų� �۴ٸ� �ĺ�����Ʈ���� �����ϴ� �޼���.
    void sortcandidates() {
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).money <= 0) {
                candidates.remove(candidates.get(i));
                i--;
            }
        }
    }

    // ���� �����ϴ� �޼���
    void gambling() {
        while (true) {
            choosingBettingAmount();
            drawCard();
            findWinner();
            calculateMoney();
            sortcandidates();
            if (candidates.size() == 1) {
                break;
            }
        }

        System.out.println();
        System.out.println("�ڡڡڡڡڡڡ����� �¸��ڴ� \"" + candidates.get(0).name + "\" �Դϴ�.�ڡڡڡڡڡڡ�");
    }


}
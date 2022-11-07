package com.espresso.cardgame;
import java.util.ArrayList;

public class Deck {
    // ���߿� �� �� ���� ī�带 ���ֱ� ���� ��� ����Ʈ ���
    // Card��ü ��̸���Ʈ�� ����
    ArrayList<Card> cards = new ArrayList<>();


    // ������: 52���� ī��� Deck�� ��̸���Ʈ cards�� �ʱ�ȭ
    Deck() {
        // ����� ���� ��� 1���� �����ؼ� 4/13����.
        for (int i = 1; i <= Card.SHAPE_MAX; i++) {
            for (int j = 1; j <= Card.NUM_MAX; j++) {
                // ī�� ��ü�� �����ؼ�
                Card card = new Card(i, j);
                // �迭�� �߰�
                cards.add(card);
            }
        }
    }

    // ī�� �������� �̱�, ���� ī��� ��ġ�� �ʱ� ���� ����Ʈ���� ����
    Card pick() {
        int random = (int) (Math.random() * cards.size());
        Card selectedCard = cards.get(random);
        // ���� ī��� cards���� ����
        cards.remove(random);
        return selectedCard;
    }
}
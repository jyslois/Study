package com.espresso.cardgame;

import java.util.ArrayList;

public class Gamer {
    String name;
    int money;
    // ī�带 �����ϱ� ���� Card Ÿ�� ���������� ��������� ����
    Card card;

    Gamer(String name) {
        this.name = name;
        this.money = 1000000;
    }

    // ���� ī�带 ������ �޼���
    public void receiveCard(Card card) {
        this.card = card;
    }

    Card getCard() {
        return this.card;
    }

}
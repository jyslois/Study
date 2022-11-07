package com.espresso.cardgame;

public class Card {
    // ���� number: A,2,3,4,5,6,7,8,9,10(X),J,Q,K
    // ���� shape: clover(1), heart(2), diamond(3), spade(4)
    // ��� �ν��Ͻ��� ���������� �����ϰ� �־�� �ϰ�(static)
    // ���� ������ �ʾƾ� �ϹǷ�(final) static final������ ����� �ش�.
    static final int CLOVER = 1;
    static final int HEART = 2;
    static final int DIAMOND = 3;
    static final int SPADE = 4;

    // Deck���� ����ϱ� ���� static���� ī�� ���� ���� ���̺� ī�� ����
    // ��������� ����
    static final int SHAPE_MAX = 4;
    static final int NUM_MAX = 13;

    int shape;
    int number;

    Card(int shape, int number) {
        this.shape = shape;
        this.number = number;
    }

    Card() {
        this(1, 1);
    }

    public String toString() {
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        // ���ڴ� 1���� ���������� �迭�� �ε����� 0���� ������. (0, 1234)

        String numbers = "-A23456789XJQK";
        // ���ڴ� 1(A)���� 13����. 10�� X�� ǥ��

        // 10�̸� X��� ���ڷ� ǥ���ϱ� ���� �ڵ�
        String is_ten;

        if (this.number == 10) {
            is_ten = "10";
        } else {
            is_ten = numbers.charAt(this.number) + "";
            // char�� String Ÿ���� is_ten���� �ٲٱ� ���� + ""
        }

        return "����: " + is_ten + ", ����: " + kinds[this.shape];
    }

}

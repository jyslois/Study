package study.minesweeper_game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) {
        // ��ź�� *, ���� ĭ�� -, ����� &

        // 1. 2���� �迭 ����� �ʱ�ȭ
        char[][] land = new char[5][5];
        // 1-1. �÷��̾�� �迭 ����
        char[][] player_land = new char[5][5];

        // 2. ��ź�� ���ϱ�(�ּ� 1���� �ִ� 5����)
        // - Random Ŭ���� ��ü ����� ��ź�� �������� �����ϱ�
        Random random = new Random();
        int bomb_num = random.nextInt(1, 5);
        System.out.println("���� ��ź �� (1~4): " + bomb_num);

        // ����� �ִ� ������ ���� ��ź �� + 1
        int max_flag = bomb_num + 1;
        System.out.println("��� ������ ��� �� : " + max_flag);

        // 3. �������� ������ ��ź����ŭ ���� ��ġ�� ��ź ��ġ�ϱ�
        // �������� ������ ��ź����ŭ ���� ��ġ �̰�, �� ���� ��ġ�� ��ġ�ϸ� 1
        // �ƴϸ� 0���� �迭 �� �ʱ�ȭ�ϱ�

        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();

        for (int b = 1; b <= bomb_num; b++) {
            // �������� ������ ��ź�� ��ŭ ���� ��ġ�� �̴µ�,
            // �� ���� ��ġ�� ��ġ�� �ʱ� ���ؼ� �� row�� column ��̸���Ʈ�� �����
            // �� ��̸���Ʈ�� �����ϸ� �ٽ� �̾� ���� �����ϰ� (�� �Ŀ� ���� ���� ��̸���Ʈ�� �߰��ϰ�),
            // �������� �ʴ´ٸ� �״�� �����ϴ� �� (�״�� �����Ʈ�� �߰�)
            // �������� row�� column �ε��� �̱�
            int random_row = random.nextInt(0, 4);
            int random_column = random.nextInt(0, 4);
            // �������� ���� ���� ��̸���Ʈ�� �������� ���� ������ ���� �̾� �����ϱ�
            while (row.contains(random_row) && column.contains(random_column)) {
                random_row = random.nextInt(0, 4);
                random_column = random.nextInt(0, 4);
            }
            // ��̸���Ʈ�� �߰��ϱ�
            row.add(random_row);
            column.add(random_column);

            for (int i = 0; i < land.length; i++) { // ��
                for (int j = 0; j < land.length; j++) { // ��
                    if (i == random_row && j == random_column) {
                        // ��ź�� ��ġ�Ǿ� ���� ���� ���, ��� ���� �����ε����� ��ġ�� ���
                        land[i][j] = '*';
                    } else if (land[i][j] == '\u0000') {
                        land[i][j] = '-';
                    }
                }
            }
        }
//        // ��ź �迭 ����ϱ�
//        for (char[] temp : land) {
//            for (char i : temp) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

        System.out.println("=======���� ����========");

        // player_land ���
        for (char[] temp : player_land) {
            for (char i : temp) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // ��ǥ �Է� �ޱ�
        int x = 0;
        int y = 0;

        outer:
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("���� ���� ���� ĭ�� ��ǥ�� �Է��ϼ��� : ");
            String coordinates = scan.nextLine();

            if (coordinates.length() == 2) {
                x = coordinates.charAt(0) - '0';
                y = coordinates.charAt(1) - '0';
            }

            // ���� �˻��ؾ� �ϱ� ������ else if�� �ƴ� if�� ���
            if (coordinates.length() != 2 || x < 0 || y < 0 || x >= land.length || y >= land[0].length) {
                System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
                continue;
            }

            // �Է� ���� ��ǥ�� ��ź(*)�� ������ gameover ���,
            // �Է� ���� ��ǥ ��ó 8ĭ�� ��ź(*)�� ������ ��ǥ�� �ش� ��ź ����ŭ ��Ÿ����.
            // ��ǥ ��ó 8ĭ�� �������� ����� if�� �ȿ� boolean�� �̿��ؼ� ����ó�� �� �ֱ�.
            int bomb = 0;
            int peri_bomb = 0;

            boolean error = true;

            if (land[x][y] == '*') {
                System.out.println("��ź�Դϴ�! Game Over");
                System.out.println("��ź ��ġ: ");
                for (char[] tmp : land) {
                    for (char i : tmp) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                }
                break;
            } else {
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
                            error = false;    // ������ ����� ��쿡 ����ó���� ���� boolean
                        } else {
                            if (land[i][j] == '*') {
                                bomb++;
                            }
                        }
                    }
                }
            }


            if (bomb != 0) { // x,y �ֺ��� ��ź�� �ϳ��� �ִٸ�
                player_land[x][y] = (char) (bomb + '0');  // ��ź ���ڸ� ���ڷ� �����ؼ� �ֱ�
            } else { // x, y �ֺ��� ��ź�� �ϳ��� ������ (��ĭ)
                player_land[x][y] = '-';
                // x, y �ֺ� 8ĭ�� �ֺ� 8ĭ�� �˻��Ѵ�
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        peri_bomb = 0;
                        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
                            error = false;    // ������ ����� ��쿡 ����ó���� ���� boolean
                        } else {
                            for (int k = i - 1; k <= i + 1; k++) {
                                for (int q = j - 1; q <= j + 1; q++) {
                                    if (k < 0 || k >= land.length || q < 0 || q >= land[0].length) {
                                        error = false;    // ������ ����� ��쿡 ����ó���� ���� boolean
                                    } else {  // ���� �ֺ� 8ĭ�� 8ĭ�� ��ź�� �ִٸ�,
                                        if (land[k][q] == '*') {
                                            peri_bomb++;  // ��ź ���� �÷��ְ�
                                        }
                                    }
                                }
                            }
                            if (peri_bomb != 0) { // ���ο� �ֺ�8ĭ�� Ž���ϱ� ���� ���� ��ź�� �ϳ��� ������
                                if (player_land[i][j] == player_land[x][y]) {
                                    error = false; // �ϴ� x,y�� ���ܽ��Ѿ� �ϴϱ� ���ְ�
                                } else {
                                    player_land[i][j] = (char) (peri_bomb + '0'); // ��ź ���� �� �ֺ� ĭ�� �Է�
                                }
                            } else {
                                player_land[i][j] = '-'; // ��ź�� ���ٸ� '-'�� ǥ���ؼ� ĭ �����ֱ�
                            }


                        }
                    }
                }

            }

            // �迭 ����ϱ�
            for (char[] tem : player_land) {
                for (char i : tem) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }

            // ��� ��ġ
            // ��� ��ǥ a, b
            int a = 0;
            int b = 0;


            // ��� ���� 0�� �� ������ �ݺ�
            while (max_flag > 0) {
                System.out.println("���� ��� �� : " + max_flag + " ��.");
                System.out.print("����� ��ġ�Ͻðڽ��ϱ�? (���� y, �ƴϿ�� n �Է�): ");
                String answer = scan.nextLine();

                if (answer.equalsIgnoreCase("n")) {
                    break;
                } else if (answer.equalsIgnoreCase("y")) {
                    System.out.print("����� ��ǥ�� �Է��� �ּ���: ");
                    String flag = scan.nextLine();

                    if (flag.length() == 2) {
                        a = flag.charAt(0) - '0';
                        b = flag.charAt(1) - '0';
                    }

                    if (flag.length() != 2 || a < 0 || b < 0 || a >= land.length || b >= land[0].length || !(0 <= a && a <= 9) || !(0 <= b && b <= 9)) {
                        System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
                        continue;
                    }

                    if ('0' <= player_land[a][b] && player_land[a][b] <= '9' || player_land[a][b] == '-') {
                        System.out.println("�ش� ��ġ���� ����� ��ġ�� ���� �����ϴ�.");
                        continue;
                    }

                    if (player_land[a][b] == '&') {
                        System.out.println("�̹� ����� ���� �ڸ��Դϴ�.");
                        continue;
                    }

                    player_land[a][b] = '&';
                    max_flag--;  // ��� �� �� �ֱ�

                    // �迭 ����ϱ�
                    for (char[] tmp : player_land) {
                        for (char i : tmp) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }

                } else {
                    System.out.println("�߸� �Է��ϼ̽��ϴ�.");
                }

                // �¸�����: ��� ��ź�� ��ġ�� ����� �����Ѵٸ� �¸�.
                int bomb_count = 0;

                // row�� column�� ���� ��ź�� x,y��ǥ�� ��� ����
                for (int i = 0; i < row.size(); i++) {
                    if (player_land[row.get(i)][column.get(i)] == '&') {
                        bomb_count++;
                    }
                }
                if (bomb_count == row.size()) {
                    System.out.println("�¸��ϼ̽��ϴ�~! Victory!");
                    System.out.println("��ź ��ġ: ");
                    for (char[] tmp : land) {
                        for (char i : tmp) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    break outer;
                }

                // flag�� ������ 0�̸鼭 ��� ��ź�� ��ġ�� ����� ���ٸ� Game Over
                if (max_flag == 0 && bomb_count != row.size()) {
                    System.out.println("����� ��� ���������� ��ź�� ��� ã�� ���߽��ϴ�! Game Over");
                    System.out.println("��ź ��ġ: ");
                    for (char[] tmp : land) {
                        for (char i : tmp) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    break outer;

                }


            }
        }
    }
}
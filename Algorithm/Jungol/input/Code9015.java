import java.util.Scanner;

public class Code9015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("두 수를 입력하시오. ");
        int a = scan.nextInt();
        int b = scan.nextInt();

        System.out.printf("%d + %d = %d%n" + "%d * %d = %d", a, b, a+b, a, b, a*b);
    }
}

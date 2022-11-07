import java.util.ArrayList;
import java.util.Scanner;

/*
N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다.
단어는 영어 알파벳으로만 구성되어 있습니다.
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 */

/*
오류:
Scanner.nextInt() 메소드가 사용자가 입력한 enter(개행문자)를
제거하지 않기 때문에 발생한다. 사용자는 콘솔창에 숫자입력 후 enter를 누르는데,
이때 nextInt() 가 숫자는 입력받고, 개행문자는 제거하지않은 채 그대로 남겨둔다.
남겨진 개행문자가 다음 scan.nextLine() 의 입력으로 처리되어 곧바로 개행된다.
처리 방법은 두 가지로, Integer.parseInt(scan.nextLine());을 해 주거나,
아니면 Scan.nextLine() 하기 전 Scan.nextLine()을 한 번 더 쳐서 개행문을 없애준다.
(출저: itbeginner2020tistory)

아니면 next()메소드를 쓰는 방법이 있다.
nextLine()과 next()메소드의 차이는 nextLine()메소드는 Enter를 치기 전까지
쓴 문자열을 모두 리턴한다는 것이고 next() 메소드는 스페이스 즉 공백 전까지
입력받은 문자열을 리턴한다는 것이다. 그래서 공백이 있는 문자열 한줄을 리턴받고 싶으면
nextLine() 메소드를 사용하고 그냥 한 단어만 쓰고 싶다면 next()를 쓰는거지만
nextLine()을 써도 상관없다.
이렇게 하면 nextInt()다음에 nextLine()을 실행할 경우 발생하는 오류를 막을 수 있다.
(출저: deftkangtistory)
 */
public class ReversingWords1 {

    // 1) 직접 뒤집기
    public static ArrayList<String> solution(String[] words) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char[] tmp = words[i].toCharArray();
            String oneword = "";
            for (int j = tmp.length - 1; j >= 0; j--) {
                oneword += tmp[j];
            }
            answer.add(oneword);
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 1. 3과 20사이(둘 다 포함)의 자연수 입력
        int num = 0;

        while (!(num >= 3 && num <= 20)) {
//            num = Integer.parseInt(scan.nextLine());
            num = scan.nextInt();
            if (!(num >= 3 && num <= 20)) {
                System.out.println("잘못 입력하셨습니다. 3과 20 사이 자연수를 입력해 주세요.");
            }
        }

        // 개행문자 제거(위에 주석 참조)
        scan.nextLine();

        // 2. N개의 단어 입력(각 줄에 하나씩)
        String[] words = new String[num];

        for (int i = 0; i < words.length; i++) {
            words[i] = scan.nextLine();
        }

        // 출력
        for (String word : solution(words)) {
            System.out.println(word);
        }

    }
}
import java.util.*;

public class ReversingSpecific0 {
    // 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
    // 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
    // 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
    // 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

    public static String solution(char[] sen) {
        int left = 0, right = sen.length - 1;

        while (left < right) {
            // left와 right의 글자가 모두 a나 z사이, 혹은 A나 B사이 일때만 스위치
            if (Character.isAlphabetic(sen[left]) && Character.isAlphabetic(sen[right])) {
                char tmp = sen[left];
                sen[left] = sen[right];
                sen[right] = tmp;
                left++;
                right--;
            } else {
                // 문자일 경우(알파벳이 아닐 경우) 그 문자의 인덱스만 더하거나 빼기
                if (!(Character.isAlphabetic(sen[left]))) {
                    left++;
                }
                if (!(Character.isAlphabetic(sen[right]))) {
                    right--;
                }
            }

        }

        String answer = new String(sen);

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String set = scan.nextLine();
        char[] sen = set.toCharArray();

        for (char word : solution(sen).toCharArray()) {
            System.out.print(word);
        }
    }
}

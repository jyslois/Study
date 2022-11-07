import java.util.*;

public class WithinWord3 {
    // 2. indexOf()와 substring() 사용: 변형
    public static String solution(String sen) {
        String answer = "";
        int max_length = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;

        index = sen.indexOf(" "); // 첫번째 공백 인덱스

        while (index != -1) { // 못 찾지 않으면(-1이 아니면) 반복
            String tmp = sen.substring(0, index);
            int len = tmp.length();
            if (len > max_length) { // 여기서 >= 하게 되면 뒤쪽 단어를 잡게 되므로, >를 해야지 앞쪽 단어가 나온다.
                max_length = len;
                answer = tmp;
            }
            sen = sen.substring(index+1);
            index = sen.indexOf(" ");
        }
        // 마지막 단어 처리
        if (sen.length() > max_length) {
            answer = sen;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sen = scan.nextLine();
        System.out.println(solution(sen));
    }

}

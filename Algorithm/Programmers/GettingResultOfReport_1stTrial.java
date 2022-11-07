/*
신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는
시스템을 개발하려 합니다.  무지가 개발하려는 시스템은 다음과 같습니다.
각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게
정지 사실을 메일로 발송합니다. 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에
게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고,
k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.

이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가
담긴 문자열 배열 report, 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때,
각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요
 */

import java.util.*;

public class GettingResultOfReport_1stTrial {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(Solution.solution(id_list, report, k)));
    }

    class Solution {
        static public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            // 1. 유효한 신고 목록 구하기
            // 한 사람이 같은 사람을 여러 번 신고해도 한 번만 신고한 것으로 쳐야 한다.
            // 중복된 요소를 저장하지 않는 HashSet 성질 이용해서
            // 유효한(신고 횟수에 포함되는) 신고만 넣기.
            // 1) 배열을 리스트(콜렉션)으로 만든 다음 Set으로 만들기
            Set<String> valid = new HashSet<>(Arrays.asList(report));
            // 2) 셋을 다시 배열로 만들기
            report = valid.toArray(new String[valid.size()]);

            // 2. 유저 별로 신고당한 횟수 구하기
            // 3) 배열의 두 번째 매개변수를 카운트 해서 신고당한 횟수 찾기
            int[] count = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++) {
                for (int j = 0; j < report.length; j++) {
                    if (id_list[i].equals(report[j].split(" ")[1])) {
                        count[i]++;
                    }
                }
            }

            // 3. 2번 이상 신고당한 유저 리스트 뽑기
            ArrayList<String> blocked = new ArrayList<>();
            for (int i = 0; i < count.length; i++) {
                if (count[i] >= k) {
                    blocked.add(id_list[i]);
                }
            }
            System.out.println(blocked);

            // 3. 2번 이상 신고당한 유저를 신고한 유저가 몇 번의 처리 결과 메일을 받는지 구하기
            // id_list = {"muzi", "frodo", "apeach", "neo"}
            // count = [1, 2, 0, 2]
            // blocked = [frodo, neo]
            // report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
            // answer = [0, 0, 0, 0]

            for (int i = 0; i < id_list.length; i++) {
                for (int j = 0; j < report.length; j++) {
                    for (int b = 0; b < blocked.size(); b++) {
                        String[] list = report[j].split(" ");
                        if (list[0].equals(id_list[i]) && list[1].equals(blocked.get(b))) {
                            answer[i]++;
                        }
                    }
                }
            }


            return answer;

        }
    }
}



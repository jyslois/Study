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

public class GettingResultOfReport_Answer {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(Solution.solution(id_list, report, k)));
    }

    class Solution {
        static public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length]; // id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일 밷열
            // 유효한 신고 목록. 동일한 유저에 대한 신고 횟수는 1회로 처리되기 때문에
            // 중복 처리를 위해 value는 set으로 저장
            HashMap<String, HashSet<String>> valid = new HashMap<>();
            // 유저별로 신고당한 횟수 목록.
            HashMap<String, Integer> count = new HashMap<>();

            for (String reportInfo : report) {
                String reporter = reportInfo.split(" ")[0]; // 신고자
                String reported = reportInfo.split(" ")[1]; // 신고당한 사람

                boolean flag = false;

                // 만약 valid에 key로 reporter가 있을 경우
                if (valid.containsKey(reporter)){
                    if (valid.get(reporter).contains(reported)) {
                        // 만약 value에 신고당한 사람이 있을 경우(이미 신고한 유저를 또 신고했을 경우)
                        flag = true;
                    } else {
                        // value에 신고당한 사람이 없을 경우
                        // reporter key의 value HashSet에 reported 추가
                        valid.get(reporter).add(reported);
                    }
                // 아직 key로 reported가 없을 경우
                } else {
                    // key로 reporter 등록, value로 new HashSet 만들어서 reported 추가
                    valid.put(reporter, new HashSet<String>(){{add(reported);}});
                }

                // 이미 신고한 유저를 또 신고했을 경우 (if true)
                if (flag) {
                    // 스킵. 더하지 않음.
                    continue;
                // 만약 신고 횟수 목록의 key에 reported가 있을 경우
                } else if (count.containsKey(reported)) {
                    // key값으로 reported, value값으로 현재 value에 1더해서 저장.
                    count.put(reported, count.get(reported)+1);
                // 신고 횟수 목록의 key에 reported가 없을 경우
                } else {
                    // 최초로 신고목록에 등록하면서 신고당한 횟수로 1 지정
                    count.put(reported, 1);
                }
            }

//            // 유저 아이디 목록(id_list) : [muzi, frodo, apeach, neo]
//            System.out.println("아이디 목록(id_list): " + Arrays.toString(id_list));
//            // 유효한 신고 목록(valid) : {muzi=[neo, frodo], frodo=[neo], apeach=[muzi, frodo]}
//            System.out.println("유효한 신고 목록(valid): " + valid);
//            // 유저별로 신고당한 횟수(count) : {muzi=1, neo=2, frodo=2}
//            System.out.println("유저별로 신고당한 횟수(count): " + count);

            // 유저별로 신고당한 횟수에 유저 이름을 각각을 돌면서,
            for (String reported : count.keySet()) {
                // 해당 유저가 몇 번 신고당했는지 횟수
                int number = count.get(reported);
                // 만약 이 횟수가 k보다 크거나 같다면
                if (number >= k) {
                    // 메일 발송 대상
                    // id리스트를 돌면서
                    for (int i = 0; i < id_list.length; i++) {
                        // 유효한 신고 목록에 신고자로 id가 있고,
                        // 해당 id가 신고한 자의 목록에 reported가 있으면
                        // 신고자가 받는 메일의 게수를 1 늘려준다
                        if (valid.containsKey(id_list[i]) && valid.get(id_list[i]).contains(reported)) {
                            answer[i]++;
                        }
                    }
                }
            }

            return answer;

        }
    }
}


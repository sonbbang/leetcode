import java.util.*;

public class KakaoSolution {

    public static String solution1(String S, String C) {
        StringBuilder result = new StringBuilder();
        String[] names = S.split(", ");
        Map<String, Integer> emailCount = new HashMap<>();

        for (String originalName : names) {
            String processedName = originalName.replace("-", "");
            String[] parts = processedName.split(" ");
            String firstName = parts[0].toLowerCase();
            String lastName = parts[parts.length - 1].toLowerCase();
            String middleName = parts.length == 3 ? parts[1].toLowerCase() : "";

            if (lastName.length() > 8) {
                lastName = lastName.substring(0, 8);
            }

            String baseEmail = firstName.charAt(0) + "" + (middleName.isEmpty() ? "" : middleName.charAt(0)) + lastName;
            String emailDomain = "@" + C.toLowerCase() + ".com";
            String email = baseEmail + emailDomain;

            // 중복 이메일 처리
            int count = emailCount.getOrDefault(baseEmail, 0) + 1;
            emailCount.put(baseEmail, count);

            if (count > 1) {
                email = baseEmail + count + emailDomain;
            }

            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(originalName + " <" + email + ">");
        }

        return result.toString();
    }


    public int solution2(int[] T, int[] A) {

        // 부모 관계로 트리 형성
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            tree.putIfAbsent(T[i], new HashSet<>());
            tree.get(T[i]).add(i);
        }

        // 목표 기술을 배우기 위한 최소 기술 개수 찾기
        Set<Integer> requiredSkills = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // 목표 기술들에 대해 부모를 추적
        for (int target : A) {
            queue.offer(target);
        }

        while (!queue.isEmpty()) {
            int skill = queue.poll();
            if (requiredSkills.contains(skill)) continue;
            requiredSkills.add(skill);

            // 부모가 있다면 부모도 큐에 넣기
            if (T[skill] != skill) { // 자기 자신이 부모가 아닌 경우
                queue.offer(T[skill]);
            }
        }

        return requiredSkills.size();
    }

    public int solution3(int[] A) {
        if (A.length < 2) return A.length;

        int maxLen = 1;
        int currLen = 1;
        boolean evenMatch = true;
        boolean oddMatch = true;

        int evenValue = A[0];
        int oddValue = A.length > 1 ? A[1] : A[0];

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] != evenValue) evenMatch = false;
            if (i % 2 == 1 && A[i] != oddValue) oddMatch = false;
        }
        
        if (evenMatch && oddMatch) return A.length;

        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[i - 2]) {
                currLen = 2;
            } else {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }

}



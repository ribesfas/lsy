package moonword;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeywordPriority {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> priorities = new HashMap<>();

        // 질문들과 우선순위 매핑
        priorities.put("급한가?", 3);
        priorities.put("중요한가?", 4);

        // 사용자 입력 받기
        List<String> userResponses = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : priorities.entrySet()) {
            System.out.print(entry.getKey() + " ");
            String response = scanner.nextLine().toLowerCase();
            userResponses.add(response);
            if (response.equals("y")) {
                priorities.put(entry.getKey(), entry.getValue() - 1);
                break;
            }
        }

        // 우선순위에 따라 정렬
        List<Map.Entry<String, Integer>> sortedPriorities = new ArrayList<>(priorities.entrySet());
        Collections.sort(sortedPriorities, (a, b) -> a.getValue().compareTo(b.getValue()));

        // 정렬된 우선순위 출력
        System.out.println("\n우선순위:");
        for (Map.Entry<String, Integer> entry : sortedPriorities) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

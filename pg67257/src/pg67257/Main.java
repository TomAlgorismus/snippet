package pg67257;

// https://school.programmers.co.kr/learn/courses/30/lessons/67257
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String expression = "100-200*300-500+20";
        System.out.println(sol.solution(expression));
    }
}

class Solution {
    public long solution(String expression) {
        expression = expression.replaceAll("-", " - ");
        expression = expression.replaceAll("\\+", " + ");
        expression = expression.replaceAll("\\*", " * ");
        String[] tokens = expression.split(" ");
        System.out.println(Arrays.toString(tokens));
        String[] op = { "+", "-", "*" };
        String[] order = new String[3];
        boolean[] visited = new boolean[3];
        List<String> list = new ArrayList<>();
        dfs(tokens, 0, op, order, visited, list);
        System.out.println(list);
        long answer = 0;
        for (int i = 0; i < list.size(); i++) {
            String[] temp = tokens.clone();
            for (int j = 0; j < order.length; j++) {
                for (int k = 0; k < temp.length; k++) {
                    if (temp[k].equals(order[j])) {
                        long a = Long.parseLong(temp[k - 1]);
                        long b = Long.parseLong(temp[k + 1]);
                        long res = calc(a, b, order[j]);
                        temp[k - 1] = String.valueOf(res);
                        temp[k] = "0";
                        temp[k + 1] = "0";
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(temp[0])));
        }
        return answer;
    }

    public String[] dfs(String[] tokens, int idx, String[] op, String[] order, boolean[] visited, List<String> list) {
        if (idx == 3) {
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals(op[0]) || tokens[i].equals(op[1]) || tokens[i].equals(op[2])) {
                    list.add(tokens[i]);
                }
            }
            return list.toArray(new String[list.size()]);
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[idx] = op[i];
                dfs(tokens, idx + 1, op, order, visited, list);
                visited[i] = false;
            }
        }
        return null;
    }
    public long calc(long a, long b, String op) {
        if (op.equals("+"))
            return a + b;
        else if (op.equals("-"))
            return a - b;
        else
            return a * b;
    }


}
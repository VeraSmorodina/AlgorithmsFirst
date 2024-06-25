package task4;

public class Main {
    public static boolean isBreacketsMatch(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            if (elem == '(') {
                stack.push(elem);
                continue;
            }
            if (elem == ')' && stack.size() == 0) {
                return false;
            }
            if (elem == ')') {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}


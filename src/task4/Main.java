package task4;

public class Main {
    public static boolean is(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int stackLength = stack.size();
        int count = 0;
        for (int i = 0; i < stackLength; i++) {
            Character character = stack.pop();
            if (count < 0) return false;
            if (i <= 1 && character != ')') return false;
            if (i == 0) continue;
            if (i == 1) {
                count++;
                continue;
            }
            if (i >= stackLength - 2 && character != '(') return false;
            if (i == stackLength - 2) {
                count--;
                continue;
            }
            if (i == stackLength - 1) continue;
            count = character != ')' ? count - 1 : count + 1;
        }
        return count == 0;
    }
}


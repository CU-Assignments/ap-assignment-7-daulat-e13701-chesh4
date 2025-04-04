public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            // Swap x and y, and process "ba" before "ab"
            return maximumGain(s.replaceAll("ba", ""), y, x);
        }

        int score = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'b' && sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a') {
                sb.deleteCharAt(sb.length() - 1);
                score += x;
            } else {
                sb.append(c);
            }
        }

        String result = sb.toString();
        sb.setLength(0);

        for (char c : result.toCharArray()) {
            if (c == 'a' && sb.length() > 0 && sb.charAt(sb.length() - 1) == 'b') {
                sb.deleteCharAt(sb.length() - 1);
                score += y;
            } else {
                sb.append(c);
            }
        }

        return score;
    }
}

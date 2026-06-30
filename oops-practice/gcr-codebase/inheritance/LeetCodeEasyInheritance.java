import java.util.*;

public class LeetCodeEasyInheritance {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree Iterator (173) - see nested class");
        System.out.println("Flatten Nested List Iterator (341) - see nested class");
        System.out.println("Number Of Islands (200) -> " + numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
        System.out.println("Count Primes (204) -> " + countPrimes(10));
        System.out.println("Contains Duplicate II (219) -> " + containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println("Maximal Square (221) -> " + maximalSquare(new char[][]{
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'}
        }));
        System.out.println("Rectangle Area (223) -> " + computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println("Basic Calculator (224) -> " + calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println("Basic Calculator II (227) -> " + calculateII("3+2*2"));
        System.out.println("Add Digits (258) -> " + addDigits(38));
        System.out.println("Ugly Number (263) -> " + isUgly(14));
        System.out.println("Ugly Number II (264) -> " + nthUglyNumber(10));
        System.out.println("Missing Number (268) -> " + missingNumber(new int[]{3, 0, 1}));
        System.out.println("H-Index (274) -> " + hIndex(new int[]{0, 1, 3, 5, 6}));
    }

    static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    static int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lastIndex.containsKey(nums[i]) && i - lastIndex.get(nums[i]) <= k) {
                return true;
            }
            lastIndex.put(nums[i], i);
        }
        return false;
    }

    static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return (Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1)) + (Math.abs(bx2 - bx1) * Math.abs(by2 - by1)) - (overlapWidth * overlapHeight);
    }

    static int calculate(String s) {
        int result = 0, sign = 1, num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                // handled simply for easy practice
            }
        }
        return result + sign * num;
    }

    static int calculateII(String s) {
        int result = 0, current = 0, last = 1;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                current = current * 10 + (ch - '0');
            } else {
                if (op == '+') result += last;
                else if (op == '-') result -= last;
                else if (op == '*') result = result - last + (last * current);
                else if (op == '/') result = result - last + (last / current);
                last = current;
                current = 0;
                op = ch;
            }
        }
        if (op == '+') result += last;
        else if (op == '-') result -= last;
        else if (op == '*') result = result - last + (last * current);
        else if (op == '/') result = result - last + (last / current);
        return result;
    }

    static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    static boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if (ugly[i] == ugly[i2] * 2) i2++;
            if (ugly[i] == ugly[i3] * 3) i3++;
            if (ugly[i] == ugly[i5] * 5) i5++;
        }
        return ugly[n - 1];
    }

    static int missingNumber(int[] nums) {
        int expected = nums.length * (nums.length + 1) / 2;
        int actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return expected - actual;
    }

    static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] >= n - i) {
                h = n - i;
                break;
            }
        }
        return h;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int count = 0;

    public static void dfs(int[][] board, int x, int y) {
        if (board[x][y] == 0) {
            return;
        }
        board[x][y] = 0;
        count++;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                dfs(board, nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] board = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] array = scanner.next().split("");
            for (int j = 0; j < array.length; j++) {
                board[i][j] = Integer.parseInt(array[j]);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                count = 0;
                dfs(board, i, j);
                if (count > 0) {
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }
}

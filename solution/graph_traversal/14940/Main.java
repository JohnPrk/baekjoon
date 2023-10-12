import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static int[][] bfs(int[][] board, int x, int y) {
        int[][] answer = new int[board.length][board[0].length];
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));
        board[x][y] = 0;
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                    if (board[nx][ny] == 1) {
                        queue.add(new Location(nx, ny));
                        board[nx][ny] = 0;
                        answer[nx][ny] = answer[location.x][location.y] + 1;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] board = new int[x][y];
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int number = scanner.nextInt();
                if (number == 2) {
                    startX = i;
                    startY = j;
                }
                board[i][j] = number;
            }
        }
        int[][] answer = bfs(board, startX, startY);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                if (answer[i][j] == 0 && board[i][j] == 1) {
                    answer[i][j] = -1;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                stringBuilder.append(answer[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}

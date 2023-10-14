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

    public static int[][] bfs(int[][] board) {
        int[][] answer = new int[board.length][board[0].length];
        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    answer[i][j] = -1;
                } else if (board[i][j] == 1) {
                    queue.add(new Location(i, j));
                    answer[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Location location = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = location.x + dx[j];
                    int ny = location.y + dy[j];
                    if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                        if (board[nx][ny] == 0) {
                            board[nx][ny] = 1;
                            queue.add(new Location(nx, ny));
                            answer[nx][ny] = answer[location.x][location.y] + 1;
                        }
                    }
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int x = scanner.nextInt();
        int[][] board = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int[][] answer = bfs(board);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                if (answer[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, answer[i][j]);
            }
        }
        System.out.println(max - 1);
    }
}

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

    private static final int START_X = 0;
    private static final int START_Y = 0;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final int START = 1;

    public static int[][] bfs(int[][] board, int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        board[x][y] = 0;
        queue.add(new Location(x, y));
        int[][] minimumBoard = new int[board.length][board[0].length];
        minimumBoard[0][0] = START;
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        queue.add(new Location(nx, ny));
                        minimumBoard[nx][ny] = minimumBoard[location.x][location.y] + 1;
                    }
                }
            }
        }
        return minimumBoard;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] board = new int[x][y];
        for (int i = 0; i < x; i++) {
            String[] array = scanner.next().split("");
            for (int j = 0; j < array.length; j++) {
                board[i][j] = Integer.parseInt(array[j]);
            }
        }
        int[][] answer = bfs(board, START_X, START_Y);
        System.out.println(answer[x - 1][y - 1]);
    }
}

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

    public static void reverseABombLocationAndItsAdjacencyLocationToOtherLocation(String[][] board) {
        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("O")) {
                    queue.add(new Location(i, j));
                }
            }
        }
        bomb(board);
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            board[location.x][location.y] = ".";
            for (int i = 0; i < dx.length; i++) {
                int nx = location.x + dx[i];
                int ny = location.y + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                    board[nx][ny] = ".";
                }
            }
        }
    }

    private static void bomb(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "O";
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int time = scanner.nextInt();
        String[][] board = new String[x][y];
        for (int i = 0; i < x; i++) {
            String[] array = scanner.next().split("");
            for (int j = 0; j < y; j++) {
                board[i][j] = array[j];
            }
        }
        for (int i = 1; i <= time; i++) {
            if (i % 2 != 1) {
                reverseABombLocationAndItsAdjacencyLocationToOtherLocation(board);
            }
        }

        if (time % 2 == 0) {
            bomb(board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

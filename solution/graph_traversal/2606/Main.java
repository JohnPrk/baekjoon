import java.util.*;

class Main {

    public static int VIRUS = 1;

    public static void bfs(int[][] graph, int[] visited) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(VIRUS);
        visited[VIRUS] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 1; i < visited.length; i++) {
                if (graph[temp][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int[][] graph = new int[vertices + 1][vertices + 1];
        int[] visited = new int[vertices + 1];
        int edges = scanner.nextInt();
        for (int i = 0; i < edges; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        bfs(graph, visited);
    }
}

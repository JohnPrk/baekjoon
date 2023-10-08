import java.util.*;

class Main {

    public static int START = 1;

    public static void bfs(Map<Integer, List<Integer>> map, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(START);
        visited.add(START);
        Map<Integer, Integer> answer = new TreeMap<>();
        while(!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> childList = map.get(parent);
            for(int child : childList) {
                if(!visited.contains(child)) {
                    answer.put(child, parent);
                    queue.add(child);
                    visited.add(child);
                }
            }
        }
        answer.forEach((k, v) -> System.out.println(v));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edges = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=1; i < edges; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map.putIfAbsent(x, new ArrayList<>());
            map.putIfAbsent(y, new ArrayList<>());
            map.get(x).add(y);
            map.get(y).add(x);
        }
        bfs(map, visited);
    }
}

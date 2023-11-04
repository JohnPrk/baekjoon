import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> people = new TreeSet<>(Collections.reverseOrder());
        int count = Integer.parseInt(scanner.next());
        for (int i = 0; i < count; i++) {
            String name = scanner.next();
            String entryStatus = scanner.next();
            if(entryStatus.equals("enter")) {
                people.add(name);
            } else {
                people.remove(name);
            }
        }
        people.forEach(System.out::println);
    }
}

import java.util.*;

public class CdAndPwdCommands {
    public static void main(String[] args) {
        // codefroce problem: https://codeforces.com/contest/158/problem/C
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        List<String> path = new ArrayList<>(); // holds current directory path

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.equals("pwd")) {
                StringBuilder sb = new StringBuilder("/");
                for (String dir : path) {
                    sb.append(dir).append("/");
                }
                System.out.println(sb.toString());
            } else if (command.startsWith("cd ")) {
                String dirPath = command.substring(3);
                if (dirPath.startsWith("/")) {
                    // Absolute path: clear current path
                    path.clear();
                }
                String[] dirs = dirPath.split("/");
                for (String dir : dirs) {
                    if (dir.equals("..")) {
                        if (!path.isEmpty()) path.remove(path.size() - 1);
                    } else if (!dir.isEmpty()) {
                        path.add(dir);
                    }
                }
            }
        }
        sc.close();
    }
}

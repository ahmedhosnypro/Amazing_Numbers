public class Main {

    public static void main(String[] args) {
    // write your program here
        int cnt = 0;
        for (Secret e : Secret.values()
        ) {
            if (e.toString().startsWith("STAR")){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

/* sample enum for inspiration
   enum Secret {
    STAR, CRASH, START, // ...
}
*/
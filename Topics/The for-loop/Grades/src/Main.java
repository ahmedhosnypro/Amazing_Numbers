import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = 0, B = 0, C = 0, D = 0;

        for (int i = 0; i < n; i++){
            int current = scanner.nextInt();
            switch (current){
                case 2:
                    D++;
                    break;
                case 3:
                    C++;
                    break;
                case 4:
                    B++;
                    break;
                case 5:
                    A++;
                    break;
                default:
                    break;
            }
        }
        System.out.println(D + " " + C + " " + B + " " + A);
    }
}
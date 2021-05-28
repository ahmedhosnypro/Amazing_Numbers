import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++){
            if (i == length - 1){
                array[0] = scanner.nextInt();
            }
            else {
                array[i + 1] = scanner.nextInt();
            }

        }
        for (int i = 0; i < length; i++){
            System.out.print(array[i] + " ");
        }

    }
}
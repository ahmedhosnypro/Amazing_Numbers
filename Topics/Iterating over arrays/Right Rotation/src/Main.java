import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] entrance  = scanner.nextLine().split(" ");
        int[] intArray = new int[entrance.length];
        for (int i = 0; i < entrance.length; i++){
            intArray[i] = Integer.parseInt(entrance[i]);
        }
        int r = scanner.nextInt();
        int[] rotatedArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++){
            int rotation = i + r;
            if (i + r >= intArray.length){
                rotation %= intArray.length;
            }
            rotatedArray[rotation] = intArray[i];
        }

        for (var n:
             rotatedArray) {
            System.out.print(n + " ");
        }
    }
}
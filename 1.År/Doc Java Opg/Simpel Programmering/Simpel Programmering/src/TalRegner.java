import java.util.Scanner;


public class TalRegner {
    public static int Tal(){
        int X;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number: ");
        X = sc.nextInt();

        return (X + 7) *2;
    }
}

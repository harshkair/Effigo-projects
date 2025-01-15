import java.util.Scanner;
import java.lang.Math;
public class DiceJack{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any three numbers:");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();
        int sum = n1 + n2 + n3;
        int roll1 = rollDice();
        int roll2 = rollDice();
        int roll3 = rollDice();
        int randomSum = roll1 + roll2 + roll3;
        if (winCheck(sum, randomSum)){
            System.out.println("You have won!");
        } else{
            System.out.println("You lost :(");
        } 
        scan.close();
    }
    public static int rollDice(){
        double  randomNumber = (int)Math.random() * 6;
        int randomNumber1 = (int)randomNumber + 1;
        System.out.println("You have rolled the number:" + randomNumber1);
        return randomNumber1;

    }
    public static boolean winCheck(int sum, int randomSum){
        if ((randomSum - sum) < 3){
            return true;
        }
        else{
            return false;
        }
    }
}

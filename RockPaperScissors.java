import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        
        while(true){
            System.out.println("Are you ready? Write 'yes' if you are.");
            String decision = scan.nextLine();
            if (decision.equals("yes")){
                System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
                System.out.println("\nGreat! \n rock - paper - scissors, shoot!");
                String option = scan.nextLine();
                String computerChoice = randomChoice();
                String result = result(option, computerChoice);
                printResult(option, computerChoice, result);
    
            }
            else{
                System.out.println("Darn, some other time...!");
                break;
            }
        }
        
        
        
        scan.close();
    }
    public static String randomChoice(){
        int option = (int) (Math.random() * 3);
        switch (option){
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
            default: return "";
        }
    }
    public static String result(String yourChoice, String randomChoice) {
        String result;
        if((yourChoice.equals("rock") && randomChoice.equals("scissors")) || (yourChoice.equals("paper") && randomChoice.equals("rock")) || (yourChoice.equals("scissors") && randomChoice.equals("paper"))){
            result = "You win!";
        }
        else if((yourChoice.equals("scissors") && randomChoice.equals("rock")) || (yourChoice.equals("rock") && randomChoice.equals("paper")) || (yourChoice.equals("paper") && randomChoice.equals("scissors"))){
            result = "You lose :(";
        }
        else if (yourChoice.equals(randomChoice)){
            result = "Its a tie!";
        }
        else {
            result="Invalid choice";
        }
        return result;
    }
    public static void printResult(String yourChoice, String randomChoice, String result){
        System.out.println("Your choice:" + yourChoice);
        System.out.println("Computer's choice:" + randomChoice);
        System.out.println("Result: " + result);
    }
 

    //Task 4  – Write a function that compares the choices and returns the result.

    /**
     * Function name: result - It returns the result of the game.
     *  @param yourChoice (String)
     *  @param computerChoice (String) 
     *  @return result (String) 

     * Inside the function:
     *   
     *   1. result is "You win!" if:
     *
     *       You: "rock"      Computer: "scissors"
     *       You: "paper"     Computer: "rock"
     *       You: "scissors"  Computer: "paper"
     *
     *   2. result is "You lose" if:
     * 
     *       Computer: "rock"      You: "scissors"
     *       Computer: "paper"     You: "rock"
     *       Computer: "scissors"  You: "paper"
     *
     *   3. result is "It's a tie" if: Your choice equals computer choice.
     * 
     * 
     *   4. Otherwise, print "INVALID CHOICE" and exit the program.
     *
     *
     */

    
     //Task 5  – Write a function that prints your choice, the computer's, and the result.

    /**
     * Name: printResult - It prints everything (your choice, computer choice, result)
     * @param yourChoice (String)
     * @param computerChoice (String)
     * @param result (String)
     * 
     * Inside the function:
     * 
     *  1. prints everything:
     *      – prints: You chose:          <your choice>
     *      – prints: The computer chose: <computer choice>
     *      – prints: <result>
     */

}

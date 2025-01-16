import java.util.Scanner;

public class Pokerito {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        scan.nextLine();
        System.out.println("It's like Poker, but a lot simpler.");
        System.out.println("• There are two players, you and the computer.\n• The dealer will give each player one card.");
        System.out.println("• Then, the dealer will draw five cards (the river)\n• The player with the most river matches wins!\n• If the matches are equal, everyone's a winner!");
        System.out.println("• Ready? Type anything if you are.");
        scan.nextLine();
        int yourCard = randomCard();
        System.out.println("Here's your card: "+ yourCard);
        int computerCard = randomCard();
        System.out.println("Here's the computer's card: " +computerCard);
        int yourMatches = 0;
        int computerMatches =0;
        for (int i=0; i<=4; i++){
            int drawCard = randomCard();
            System.out.println("Card " + (i+1) +"\n\n" + drawCard);
            if (drawCard == yourCard){
                yourMatches += 1;
            } else if (drawCard == computerCard){
                computerMatches += 1;
            } else{ 
                continue;
            }

        }
        if (yourMatches == computerMatches){
            System.out.println("Everyone wins");
        } else if (yourMatches > computerMatches){
            System.out.println("You win");
        } else {
            System.out.println("Computer wins");
        }


         scan.close();
    }
    public static int randomCard(){
        // int number = 1;
        int number = (int)(Math.random() * 13 + 1 );
        switch (number){
            case 1: System.out.println( "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n");
                   return 1;
            case 2: System.out.println( "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n");
                    return 2;
            case 3: System.out.println( "   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____E|\n");
                  return 3;
            case 4: System.out.println( "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n");
                   return 4;
            case 5: System.out.println( "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n");
                    return 5;
            case 6: System.out.println( "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n");
                    return 6;
            case 7: System.out.println( "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n" );
                    return 7;
            case 8: System.out.println( "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n");
                    return 8;
            case 9: System.out.println( "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n");
                    return 9;
            case 10: System.out.println( "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n");
                    return 10;
            case 11: System.out.println( "   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n");
                    return 11;
            case 12: System.out.println( "   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n");
                    return 12;
            case 13: System.out.println( "   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n");
                    return 13;
            default : return 0;
        }
    }

}

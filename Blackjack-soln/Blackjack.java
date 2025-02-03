import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        int handValue = 0;
        int dealerValue = 0;
        String decision;
        while (handValue < 21){
            handValue = hit(handValue);
            TimeUnit.SECONDS.sleep(3);
            handValue = hit(handValue);
            TimeUnit.SECONDS.sleep(3);
            System.out.println(" Your total is " + handValue);
            TimeUnit.SECONDS.sleep(2);
            dealerValue = hit(dealerValue);
            System.out.println("The dealer shows \n" + dealerValue + "\nand has a card facing down \n" + faceDown());
            TimeUnit.SECONDS.sleep(3);
            while(true && handValue < 21){
                System.out.println("Would you like to hit or stay?");
                decision = scan.nextLine();
                if( decision.equals("hit")){
                    handValue = hit(handValue);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Your new total is " + handValue);
                    continue;
                } else{
                    break;
                }
            }
            break;
        }
        if (handValue > 21){
            System.out.println("Bust! You lose");
        } else{
            System.out.print("Hidden Card is:");
            dealerValue = hit(dealerValue);
            TimeUnit.SECONDS.sleep(3);
            while(true && dealerValue < 21){
                decision = dealerDecison(dealerValue, handValue);
                if( decision.equals("hit")){
                    dealerValue = hit(dealerValue);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Dealer new total is " + dealerValue);
                } else{break;}
            }
            winOrLose(dealerValue, handValue);
        } 
         scan.close();

    }
    public static String winOrLose(int dealerValue, int handValue){
        if (dealerValue > handValue){
            return "Dealer Wins";
        } else if (handValue > dealerValue){
            return "You win";
        } else {
            return "Its a tie!";
        }
    
    }
    public static int randomNumber(){
        int number = (int)(Math.random() * 10 + 1 );
        return number;
    }
    public static String randomCard(int number){
        // int number = 1;
        switch (number){
            case 1: return ( "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n");
                   
            case 2: return ( "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n");
                    
            case 3: return ( "   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____E|\n");
                  
            case 4: return ( "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n");
                   
            case 5: return ( "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n");
                
            case 6: return ( "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n");
                    
            case 7:  return ( "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n" );
                    
            case 8: return ( "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n");
                    
            case 9: return ( "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n");
                
            case 10: return( "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n");
                    
            // case 11: return ( "   _____\n" +
            //         "  |J  ww|\n"+ 
            //         "  | o {)|\n"+ 
            //         "  |o o% |\n"+ 
            //         "  | | % |\n"+ 
            //         "  |__%%[|\n");
                    
            // case 12: return ( "   _____\n" +
            //         "  |Q  ww|\n"+ 
            //         "  | o {(|\n"+ 
            //         "  |o o%%|\n"+ 
            //         "  | |%%%|\n"+ 
            //         "  |_%%%O|\n");
                    
            // case 13: return ( "   _____\n" +
            //         "  |K  WW|\n"+ 
            //         "  | o {)|\n"+ 
            //         "  |o o%%|\n"+ 
            //         "  | |%%%|\n"+ 
            //         "  |_%%%>|\n");
                
            default : return "";
        }
    }
    public static String dealerDecison(int dealerValue, int yourValue){
        if (dealerValue < yourValue){
            return "hit";
        }
        else if (dealerValue > yourValue){
            return "stay";
        }
        else {return "stay";}

        
    }
    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    public static int hit(int currentValue){
        int value = randomNumber();
        boolean hasAce = false;
        if (value == 1 && currentValue <= 10){
            currentValue += 11;
            hasAce = true;
        }else if(hasAce == true && currentValue > 11){
            currentValue -= 10;
            currentValue += value;
        }
        else{
            currentValue += value;
        }
        System.out.println(randomCard(value));
        return currentValue;
    }
    }


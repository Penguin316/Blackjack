import java.util.Random;
import java.util.Scanner;

public class DealHand {

    int totalChips;

    public DealHand() { // DealHand Constructor; resets every game
        //int totalChips = 0;

        if (totalChips == 0) {
            System.out.println("How many chips would you like to buy?");
            Scanner buyChips = new Scanner(System.in);
            totalChips += buyChips.nextInt();
            System.out.println("You now have " + totalChips + " chips");
        }

        System.out.println("You currently have " + totalChips + " chips");

        totalChips--;

        System.out.println("Your hand is: ");
        int firstHand = dealCard();
        System.out.println(firstHand);

        int secondHand = dealCard();
        System.out.println(secondHand);

        int total = firstHand + secondHand;
        System.out.println("Total is: " + total);

        int dealerFirstCard = dealerCard();


        int dealerSecondCard = dealerCard();
        int dealerTotal = dealerFirstCard + dealerSecondCard;

        if (dealerFirstCard == 11) {
            System.out.println("Dealer's hand shows an ace and might be a blackjack. The second card is hidden.");
        }

        if (dealerFirstCard != 11) {
            System.out.println("Dealer's hand shows: " + dealerTotal);
        }


        if (total < 21) {
            //boolean hitOrStay = hit();
            while (total <= 21) {

                if (hit() == false || total > 20) {
                    break;
                }
                int nextCard = dealCard();
                System.out.println(nextCard);
                total += nextCard;
                System.out.println("Your total is: " + total);
                if (total > 20) {
                    break;
                }

            }

        }
        if (total == 21) {
            System.out.println("Blackjack! You win!");
        }
        if (total > 21) {
            System.out.println("Uh oh, busted!");
        }

        if (total < 22) {
            while (dealerFirstCard != 11 && dealerTotal < 16) {
                int nextDealerCard = dealerCard();
                dealerTotal += nextDealerCard;
                System.out.println("Dealer's hand shows: " + dealerTotal);
            }
        }

        if (dealerTotal > 21) {
            System.out.println("Dealer has busted!");
        }

        if (dealerFirstCard == 11) {
            //dealerTotal = dealerFirstCard + hiddenDealerHand;
            System.out.println("Dealer's total is: " + dealerTotal);
        }

        if (total < 21) {
            if (total > dealerTotal || dealerTotal > 21) {
                System.out.println("You win with a hand of: " + total + " against the dealer's hand of: " + dealerTotal);
                totalChips += 2;
            } else /*(total < dealerTotal || total > 21)*/ {
                System.out.println("You lost with a hand of: " + total + " against the dealer's hand of: " + dealerTotal);
            }
        }


        new PlayAgain();
    }

    private int dealCard() {
        Random ran = new Random();
        int x = ran.nextInt(11) + 1;

        return x;
    }

    private boolean hit() {
        System.out.println("Would you like to hit?");
        Scanner hit = new Scanner(System.in);
        String answer = hit.nextLine();

        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            return true;
        }

        if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
            return false;
        }
        return false;
    }

    private int dealerCard() { // redundant; dealCard method does the same thing
        Random dealerRan = new Random();
        int x = dealerRan.nextInt(11) + 1;

        return x;
    }

    /*private int chips(int newChips) {
        //int totalChips;
        int oldChips = buyIn(oldChips);
        int totalChips = oldChips + newChips;
    }*/

    private int buyIn(int buyChips) {
        return buyChips;
    }
}

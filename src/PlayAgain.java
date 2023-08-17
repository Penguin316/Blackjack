import java.util.Scanner;

public class PlayAgain {

    public PlayAgain() {
        boolean answer = keepPlaying();
        if (answer == true) {
            System.out.println("ok");
            new DealHand();
        }

        if (answer == false) {
            System.out.println("That's too bad");
        }
        /*else {
            System.out.println("That doesn't even make sense");
        }*/
    }


    private boolean keepPlaying() {
        System.out.println("Would you like to continue playing? Yes or no?");
        Scanner continuePlaying = new Scanner(System.in);
        String answer = continuePlaying.nextLine();
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            return true;
        }

        if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
            return false;
        }
        /*else {
            System.out.println("That doesn't even make sense");
        }*/
        return false;
    }
}

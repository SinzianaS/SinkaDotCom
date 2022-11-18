import java.util.*;
     /*Create 3 DotComs, give each of them a name.
       Call a setter method on each DotCom instance.
       Put the DotComs on a grid, and do it for all 3 instances.
       Check each user guess with all instances.
       Keep playing the game until there are no more live DotComs.
     */
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCOm> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setupGame() {
        DotCom one = new DotCom();     //make 3 dotcoms, give them names
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComsList.add(one);              //put them in an ArrayList
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink the 3 dotcoms.");     //brief instructions for user
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest possible guesses.");
        
        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
            
        }
    }

    private void startPlaying() {

    }

    private void checkUserGuess() {

    }

    private void finishGame() {

    }

    public static void main (String[] args) {
        DotComBust game = new DotComBust();
    }
}
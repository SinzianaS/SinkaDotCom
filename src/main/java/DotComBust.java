import java.util.*;
     /*Create 3 DotComs, give each of them a name.
       Call a setter method on each DotCom instance.
       Put the DotComs on a grid, and do it for all 3 instances.
       Check each user guess with all instances.
       Keep playing the game until there are no more live DotComs.
     */
public class DotComBust {
         private GameHelper helper = new GameHelper();
         private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
         private int numOfGuesses = 0;

         private void setUpGame() {
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
                 dotComToSet.setLocationCells(newLocation);  //call the setter to give it the location you just got from
                 // the helper
             }
         }

         private void startPlaying() {
             while (!dotComsList.isEmpty()) {
                 String userGuess = helper.getUserInput("Enter a guess: ");
                 checkUserGuess(userGuess);
             }
             finishGame();
         }

         private void checkUserGuess(String userGuess) {
             numOfGuesses++;
             String result = "miss";
             for (DotCom dotComToTest : dotComsList) {             //repeat for all the dotcoms in the list
                 result = dotComToTest.checkYourself(userGuess);  //ask the DotCom to check the user guess for a hit or kill
                 if (result.equals("hit")) {
                     break;
                 }
                 if (result.equals("kill")) {  //this guy is dead so remove him from the DotComs list
                     dotComsList.remove(dotComToTest);
                     break;
                 }
             }
             System.out.println(result);         //print result for the user

         }

         private void finishGame() {
             System.out.println("All Dot Coms are dead!  Your stock is now worthless");
             
             if (numOfGuesses <= 18) {
                 System.out.println("It only took you " + numOfGuesses + " guesses");
                 System.out.println("You got out before your options sank.");
             } else {
                 System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
                 System.out.println("Fish are dancing with your options.");
             }
         }

         public static void main (String[] args) {
                DotComBust game = new DotComBust();     //create game object
                game.setUpGame();                       //tell the game object to set up the game
                game.startPlaying();                    //tell the game object to start the main
                                                        //game play loop
         }

}
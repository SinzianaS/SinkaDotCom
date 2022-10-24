import java.util.Arraylist;

public class DotCom {
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> loc) {  //setter method to update the DotCom's location
        locationCells = loc;
    }

    public void setName (String n) {
        name = n;
    }

    public String CheckYourself(String userInput) {
        String result = "miss";  //assume it'a miss
        int index = locationCells.indexOf(userInput); // find put if the user guess is in the ArrayList by asking for its index
                                                      // if it's not return a -1
        if (index >= 0) {
            locationCells.remove(index); // the user guess is in the list, so remove it

            if (locationCells.isEmpty()) {  //if the list is empty then this was the killing blow
                result = "kill";
                System.out.println("Ouch! You sunk + " + name + " :( ");
            } else {
                result = "hit";
            }
        }

        return result;
    }
}
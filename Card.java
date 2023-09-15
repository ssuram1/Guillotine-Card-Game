/**
 * A class to represent the cards of the game Guillotine
 * @author Shravani Suram
 */
public class Card{
    /**stores the name of the card */
    String name;
    /**stores the group of the card */
    String group;
    /**stores the score of the card */
    int score;
    /**
     * Creates the instance of Card and stores inputs into fields
     */
    public Card(String name, String group, int score){
        this.name = name;
        this.group = group;
        this.score = score;
    }
    /**
     *Returns the name of the specified card
     */
    public String getName(){
        return this.name;
    }
    /**
     * Returns the group of the specified card
     */
    public String getGroup(){
        return this.group;
    }
    /**
     * Returns the score of the specified card
     */
    public int getScore(){
        return this.score;
    }
    /**
     * Returns the String version of the card name, group, and score
     */
    public String toString(){
        if(this.score != 0)
            return this.name + "/" + this.group + "/ " + this.score;
        else
            return this.name + "/" + this.group + "/ *";
    }
}

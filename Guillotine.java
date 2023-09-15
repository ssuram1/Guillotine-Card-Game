import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import javafx.scene.layout.TilePane;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.Node;
/**
 * A class to represent the game Guillotine
 * @author Shravani Suram
 */
public class Guillotine extends Application{
    /** stores the current set of cards that players must draw from */
    private LinkedList<Card> currentSet;
    /** stores all of the cards that can be used for the game */
    private ArrayList<Card> masterSet;
    /** stores which player's turn it is */
    private int playerTurn = 1;
    /** stores the cards that player1 has collected */
    private LinkedList<Card> player1Cards;
    /** stores the cards that player2 has collected */
    private LinkedList<Card> player2Cards;
    /** stores the name and score of player 1 */
    private Text player1;
    /** stores the name and score of player 2 */
    private Text player2;
    /** stores the number of points player 1 has collected */
    private int player1Score;
    /** stores the number of points player 2 has collected */
    private int player2Score;
    /** stores the buttons representing player 1's collected cards */
    private TilePane p1Tile;
    /** stores the buttons representing player 2's collected cards */
    private TilePane p2Tile;
    /** stores the number of cards that will be used in game (inputted or default) */
    private static int numberOfCards;
    /**
     * Creates display for gameboard, randomly draws specified number of cards from masterSet, and creates action buttons and collected cards for each player */

    public void start(Stage primaryStage){
        /** Creates masterSet of cards and LinkedLists for each player's cards */
        makeMasterSet();
        player1Cards = new LinkedList<Card>();
        player2Cards = new LinkedList<Card>();

        /** Creates game display with each player's name and score */
        player1 = new Text("Player 1\nScore: 0");
        player2 = new Text("Player 2\nScore: 0");
        /** Creates border to store game display */
        BorderPane border = new BorderPane();
        /** Creates boxes to store each player's information on each side of display */
        VBox vboxLeft = new VBox(10);
        VBox vboxRight = new VBox(10);

        /** Create tiles for center cards */
        TilePane tile = new TilePane(Orientation.VERTICAL);
        tile.setTileAlignment(Pos.CENTER_LEFT);
        tile.setPrefRows(20);

        /** Creates button displaying which player's turn it is */
        Button buttonTurn = new Button("Player " + playerTurn + " Turn");

        /** Creates Player 1 Action Buttons */
        /**stores button for Move Front Back 4 action */
        Button b1 = new Button("Move Front Back 4");
        b1.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.moveBack(4);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b1.setDisable(true);
                }
            }
        });
        /**stores button for Move Front Back 3 action */
        Button b2 = new Button("Move Front Back 3");
        b2.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.moveBack(3);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b2.setDisable(true);
                }
            }
        });
        /**stores button for Move Front Back 2 action */
        Button b3 = new Button("Move Front Back 2");
        b3.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.moveBack(2);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b3.setDisable(true);
                }
            }
        });
        /**stores button for Move Front Back 1 action */
        Button b4 = new Button("Move Front Back 1");
        b4.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.moveBack(1);

                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b4.setDisable(true);
                }
            }
        });
        /**stores button for Move Front to End action */
        Button b5 = new Button("Move Front to End");
        b5.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.moveFirstToLast();

                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b5.setDisable(true);
                }
            }
        });
        /**stores button for Move Last Person to Front action */
        Button b6 = new Button("Move Last Person to Front");
        b6.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.moveLastToFirst();

                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b6.setDisable(true);
                }
            }
        });
        /**stores button for Reverse Line action */
        Button b7 = new Button("Reverse Line");
        b7.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.reverseList();

                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b7.setDisable(true);
                }
            }
        });
        /**stores button for Reverse First 5 action */
        Button b8 = new Button("Reverse First 5");
        b8.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    currentSet.reverseFirstK(5);

                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b8.setDisable(true);
                }
            }
        });
        /**stores button for Skip Turn action */
        Button b9 = new Button("Skip Turn");
        b9.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and switches player turn */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    playerTurn = 2;
                    buttonTurn.setText("Player: " + playerTurn + " Turn");
                    b9.setDisable(true);
                }
            }
        });
        /**stores button for Take Front Person action */
        Button b10 = new Button("Take Front Person");
        b10.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and removes card from front of currentSet */
            public void handle(ActionEvent e){
                if(playerTurn == 1){
                    /** Adds card to beginning of player1 collected cards list and removes from currentSet */
                    player1Cards.addToFront(currentSet.getFirstNode().getElement());
                    currentSet.removeFromFront();
                    tile.getChildren().remove(0,1);
                    /** Displays new collected cards of player 1 */
                    p1MakeTiles();
                    player1Score = calculateScore(player1Cards);
                    player1.setText("Player 1\nScore: " + player1Score);

                    /** Switches player turn and updates display if cards are left in currentSet */
                    if(currentSet.getFirstNode() != null){
                        playerTurn = 2;
                        buttonTurn.setText("Player " + playerTurn + " Turn");
                    }
                    else {
                        Text text = new Text("GAME OVER!");
                        border.setCenter(text);
                    }
                }
            }
        });



        //Player 2 Action Buttons
        /**stores button for Move Front Back 4 action */
        Button b11 = new Button("Move Front Back 4");
        b11.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.moveBack(4);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b11.setDisable(true);
                }
            }
        });
        /**stores button for Move Front Back 3 action */
        Button b12 = new Button("Move Front Back 3");
        b12.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.moveBack(3);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b12.setDisable(true);
                }
            }
        });
        /**stores button for Move Front Back 2 action */
        Button b13 = new Button("Move Front Back 2");
        b13.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.moveBack(2);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b13.setDisable(true);
                }
            }
        });
        /**stores button for Move Front Back 1 action */
        Button b14 = new Button("Move Front Back 1");
        b14.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.moveBack(1);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b14.setDisable(true);
                }
            }
        });
        /**stores button for Move Front to End action */
        Button b15 = new Button("Move Front to End");
        b15.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.moveFirstToLast();
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b15.setDisable(true);
                }
            }
        });
        /**stores button for Move Last Person to Front action */
        Button b16 = new Button("Move Last Person to Front");
        b16.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.moveLastToFirst();
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b16.setDisable(true);
                }
            }
        });
        /**stores button for Reverse Line action */
        Button b17 = new Button("Reverse Line");
        b17.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.reverseList();
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b17.setDisable(true);
                }
            }
        });
        /**stores button for Reverse First 5 action */
        Button b18 = new Button("Reverse First 5");
        b18.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and rearranges cards */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    currentSet.reverseFirstK(5);
                    /** Removes tiles in currentSet display */
                    tile.getChildren().remove(0,currentSet.length());
                    LLNode<Card> node = currentSet.getFirstNode();
                    /**loops through new currentSet and creates buttons for display in new order */
                    while(node != null) {
                        Button b =  new Button(node.getElement().toString());
                        tile.getChildren().add(b);
                        node = node.getNext();
                    }
                    border.setCenter(tile);
                    b18.setDisable(true);
                }
            }
        });
        /**stores button for Skip Turn action */
        Button b19 = new Button("Skip Turn");
        b19.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and switches player turn */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    playerTurn = 1;
                    buttonTurn.setText("Player: " + playerTurn + " Turn");
                    b19.setDisable(true);
                }
            }
        });
        /**stores button for Take Front Person action */
        Button b20 = new Button("Take Front Person");
        b20.setOnAction(new EventHandler<ActionEvent>(){
            /** catches action and removes card from front of currentSet */
            public void handle(ActionEvent e){
                if(playerTurn == 2){
                    /** Adds card to beginning of player1 collected cards list and removes from currentSet */
                    player2Cards.addToFront(currentSet.getFirstNode().getElement());
                    currentSet.removeFromFront();
                    tile.getChildren().remove(0,1);
                    /** Displays new collected cards of player 2 */
                    p2MakeTiles();

                    player2Score = calculateScore(player2Cards);
                    player2.setText("Player 2\nScore: " + player2Score);
                    /** Switches player turn and updates display if cards are left in currentSet */
                    if(currentSet.getFirstNode() != null){
                        playerTurn = 1;
                        buttonTurn.setText("Player " + playerTurn + " Turn");
                    }
                    else {
                        Text text = new Text("GAME OVER!");
                        border.setCenter(text);
                    }
                }
            }
        });

        /**creates LinkedList randomly with the number of cards specified*/
        int index = 0;
        this.currentSet = new LinkedList<Card>();
        /** generates random index and adds element to currentSet linkedlist */
        for(int i = 0; i < numberOfCards; i++){
            index = (int) (Math.random() * masterSet.size());
            currentSet.addToFront(masterSet.get(index));
        }


        LLNode<Card> node = currentSet.getFirstNode();
        /**Creates Buttons for each card in current set and adds to TilePane for display*/
        while(node != null) {
            Button b =  new Button(node.getElement().toString());
            tile.getChildren().add(b);
            node = node.getNext();
        }
        /**Stores tilepane to hold Player 1's collected cards */
        p1Tile = new TilePane(Orientation.VERTICAL);
        p1Tile.setTileAlignment(Pos.CENTER_LEFT);
        p1Tile.setPrefRows(20);

        /**Stores tilepane to hold Player 2's collected cards */
        p2Tile = new TilePane(Orientation.VERTICAL);
        p2Tile.setTileAlignment(Pos.CENTER_LEFT);
        p2Tile.setPrefRows(20);

        //stores ScrollPane for currentSet and adds tile with currentSet buttons
        ScrollPane pane = new ScrollPane();
        pane.setContent(tile);

        /**adds header text, action buttons, and collected cards for each player to each VBox layout*/
        vboxLeft.getChildren().addAll(player1, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, p1Tile);
        vboxRight.getChildren().addAll(player2, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, p2Tile);

        /*Adds tiles and text to appropriate sides of BorderPane */
        border.setRight(vboxRight);
        border.setLeft(vboxLeft);
        border.setCenter(pane);
        border.setTop(buttonTurn);
        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Creates an array with all of the possible cards
     */
    public void makeMasterSet(){
        masterSet = new ArrayList<Card>();

        masterSet.add(new Card("King Louis XIV", "Royal", 5));
        masterSet.add(new Card("Marie Antoinette", "Royal", 5));
        masterSet.add(new Card("Regent", "Royal", 4));
        masterSet.add(new Card("Duke", "Royal", 3));
        masterSet.add(new Card("Baron", "Royal", 3));
        masterSet.add(new Card("Count", "Royal", 2));
        masterSet.add(new Card("Countess", "Royal", 2));
        masterSet.add(new Card("Lord", "Royal", 2));
        masterSet.add(new Card("Lady", "Royal", 2));
        masterSet.add(new Card("Cardinal", "Church", 5));
        masterSet.add(new Card("Archbishop", "Church", 4));
        masterSet.add(new Card("Nun", "Church", 4));
        masterSet.add(new Card("Bishop", "Church", 2));
        masterSet.add(new Card("Priest", "Church", 1));
        masterSet.add(new Card("Priest", "Church", 1));
        masterSet.add(new Card("Heretic", "Church", 0));
        masterSet.add(new Card("Governor","Civic", 3));
        masterSet.add(new Card("Mayor", "Civic", 3));
        masterSet.add(new Card("Councilman", "Civic", 3));
        masterSet.add(new Card("Judge", "Civic", 2));
        masterSet.add(new Card("Judge", "Civic", 2));
        masterSet.add(new Card("Tax Collector","Civic", 0));
        masterSet.add(new Card("Sheriff", "Civic", 1));
        masterSet.add(new Card("Sheriff", "Civic", 1));
        masterSet.add(new Card("Palace Guard", "Military", 0));
        masterSet.add(new Card("Palace Guard", "Military", 0));
        masterSet.add(new Card("Palace Guard", "Military", 0));
        masterSet.add(new Card("Palace Guard", "Military", 0));
        masterSet.add(new Card("Palace Guard", "Military", 0));
        masterSet.add(new Card("General", "Military", 4));
        masterSet.add(new Card("Colonel", "Military", 3));
        masterSet.add(new Card("Captain", "Military", 2));
        masterSet.add(new Card("Lieutenant", "Military", 1));
        masterSet.add(new Card("Lieutenant", "Miliatry", 1));
        masterSet.add(new Card("Tragic Figure", "Commoner", 0));
        masterSet.add(new Card("Heroic Figure", "Commoner", -3));
        masterSet.add(new Card("Student", "Commoner", -1));
        masterSet.add(new Card("Student", "Commoner", -1));
        masterSet.add(new Card("Student", "Commoner", -1));
        masterSet.add(new Card("Student", "Commoner", -1));

    }

    /**
     * Calculates the score for the player's collected cards
     * @param plist specifies which player's cards score should be calculated for
     */
    public static int calculateScore(LinkedList<Card> plist){
        /** stores the node of the list and helps loop through list*/
        LLNode<Card> nodeptr;
        /** stores the total score for the player */
        int score = 0;
        /** stores the specified card name */
        String nodeName = "";
        /** stores the specified card group */
        String nodeGroup;
        /** stores the number of points the specified card is worth */
        int nodeScore;
        /** stores whether the player has a Countess card */
        boolean hasCountess = false;
        /**stores whether player has Count card */
        boolean hasCount = false;
        /**stores whether player has Lord card */
        boolean hasLord = false;
        /** stores whether player has Lady card */
        boolean hasLady = false;
        /** stores whether player Tax Collector card */
        boolean hasTaxCollector = false;
        /** stores whether player has Heretic card */
        boolean hasHeretic = false;
        /** stores whether player has Tragic Figure card */
        boolean hasTragicFigure = false;
        /** stores the number of Church cards the player has */
        short countChurch = 0;
        /** stores the number of Civic cards the player has */
        short countCivic = 0;
        /** stores the number of Palace Guards the player has */
        short countPalaceGuards = 0;
        /** stores the number of Commoner cards the player has */
        short countCommoner = 0;

        nodeptr = plist.getFirstNode();
        /** loops through the linked list of the player's cards and records if it has special cards */
        while(nodeptr != null){
            nodeName = nodeptr.getElement().getName();
            nodeGroup = nodeptr.getElement().getGroup();
            nodeScore = nodeptr.getElement().getScore();
            if(nodeScore != 0)
                score = score + nodeptr.getElement().getScore();

            if(nodeName.equals("Countess"))
                hasCountess = true;
            else if(nodeName.equals("Count"))
                hasCount = true;
            else if(nodeName.equals("Lord"))
                hasLord = true;
            else if(nodeName.equals("Lady"))
                hasLady = true;
            else if(nodeName.equals("Palace Guard"))
                ++countPalaceGuards;
            else if(nodeName.equals("Heretic"))
                hasHeretic = true;
            else if(nodeName.equals("Tax Collector"))
                hasTaxCollector = true;
            else if(nodeName.equals("Tragic Figure"))
                hasTragicFigure = true;

            if(nodeGroup.equals("Church"))
                ++countChurch;
            else if(nodeGroup.equals("Civic"))
                ++countCivic;
            else if(nodeGroup.equals("Commoner"))
                ++countCommoner;

            nodeptr = nodeptr.getNext();
        }
        /** Checks which special cards the player has and adjusts score accordingly */
        if(hasCountess == true && hasCount == true)
            score = score + 4;
        if(hasLord == true && hasLady == true)
            score = score + 4;
        if(hasHeretic == true)
            score = score + countChurch;
        if(hasTaxCollector == true)
            score = score + countCivic;
        if(countPalaceGuards != 0)
            score = score + (countPalaceGuards * countPalaceGuards);
        if(hasTragicFigure == true)
            score = score - countCommoner;

        return score;
    }


    /**
     * Creates Buttons for Player1 Cards
     */
    public void p1MakeTiles(){
        /** stores the node that will loop through player 1's collected cards */
        LLNode<Card> node;

        node = player1Cards.getFirstNode();
        Button b =  new Button(node.getElement().toString());
        p1Tile.getChildren().add(b);

    }
    /**
     * Creates Buttons for Player2 Cards
     */
    public void p2MakeTiles(){
        /**stores the node that will loop through player 2's collected cards */
        LLNode<Card> node;

        node = player2Cards.getFirstNode();
        Button b =  new Button(node.getElement().toString());
        p2Tile.getChildren().add(b);
    }
    /**
     * Sets the number of center cards players can draw from based on inputs and launches game
     */
    public static void launchGuillotine(String [] args){
        if(args.length == 0)
            numberOfCards = 20;
        else {
            if(Integer.parseInt(args[0]) > 40)
                numberOfCards = 20;
            else
                numberOfCards = Integer.parseInt(args[0]);
        }
        Application.launch(args);
    }
    /*
     * Launches the program by calling launchGuillotine method with input of number of cards
     */
    public static void main(String[] args){
        Guillotine.launchGuillotine(args);
    }
}


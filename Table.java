// Team mandarinOranges
// Bryan Chan, Eric Chen, Datian Zhang
// APCS1 pd3
import java.util.ArrayList;
import cs1.Keyboard;
public class Table {

    // D = Diamond
    // C = Clubs
    // H = Hearts
    // S = Spades
    private static final String[] DECK = {
	"2D","2C","2H","2S",
	"3D","3C","3H","3S",
	"4D","4C","4H","4S",
	"5D","5C","5H","5S",
	"6D","6C","6H","6S",
	"7D","7C","7H","7S",
	"8D","8C","8H","8S",
	"9D","9C","9H","9S",
	"10D","10C","10H","10S",
	"JD","JC","JH","JS",
	"QD","QC","QH","QS",
	"KD","KC","KH","KS",
	"AD", "AC", "AH", "AS",
    };

    public String[] _deck;
    private ArrayList<Player> players;
    private ArrayList<Player> currentPlayers;
    public ArrayList<String> tableCards;
    private double pool;
    private double stayInBet;
    private int numRaises;
    private int currentIndex;
    private int j;//Needed cause raise causes issues if it's not an inst var.
    /*
      private static Player firstPlayer;
      private static Player secondPlayer;

      public Table(){
      firstPlayer= new Player(0,0);
      secondPlayer= new Player(0,0);

      _deck = new String[DECK.length];
      for( int i = 0; i < DECK.length; i++ ){	 // copy deck	
      _deck[i]=  DECK[i];
      }

      }
    */

    public Table( int numPlayers ) {

	players = new ArrayList<Player>();

	for ( int i = 1 ; i <= numPlayers ; i += 1 ) {
	    System.out.println( "What is Player " + i + "'s name?" );
	    String playerName = Keyboard.readString();
	    // System.out.println("My name is" + " " + playerName);
	    Player p = new Player();
	    p.setName( playerName );
	    players.add( p );
	} // Codeblock idea from http://stackoverflow.com/questions/22335279/creating-multiple-objects-based-on-user-input
	tableCards = new ArrayList<String>();

	numRaises=0;
	currentIndex=0;
    }

    public ArrayList<Player> getPlayers() {
	return players;
    }
    
    public static String retArray(String [] arr){
	String retStr = "";
	for(String array : arr){
	    retStr += array + " ";
	}
	return retStr;
    } // Diagnostic

    // Credits to XinYi Chen for discovering this method!
    public static void clearScreen() {
	String cls = "printf \"\033c\"";
	System.out.println(cls);
    }
   
    public String getCard(){

        int deckIndex = (int)(Math.random()*_deck.length);
	String retStr = _deck[deckIndex];

	String temp = _deck[deckIndex];
	_deck[deckIndex] = _deck[_deck.length - 1];//Swaps with the last item so we can cut it off the deck
	_deck[_deck.length - 1] = temp;

	String _data[] = new String[_deck.length - 1];
	for( int i = 0; i < _data.length; i++ ){
	    _data[i] = _deck[i];
	}//basically a collapse/truncate method

	_deck = _data;
	
	return retStr; 
	//return DECK[((int)(Math.random()*DECK.length))];
	
    }
    public String getTC(){
	String retStr = "";
	for (int i = 0; i < tableCards.size(); i++ ){
	    retStr += " " +  tableCards.get(i);
	}
	return retStr;
    }
    public ArrayList<String> getALCards(){
	return tableCards;
    }

    public void prompt( Player p ) {
	
	System.out.println( "========== Player " + p.getName() + "'s turn ==========" );

	System.out.println("The current cards are: " + tableCards);
	System.out.println( "Your cards are " + p.getHand() );
		    
	System.out.println( "Your balance is " + p.getBalance() );
	System.out.println( "The current pool is " + pool );
	System.out.println( "Your current bet is " + p.playerBet );
	System.out.println( "The bet required to stay in the round is: " + stayInBet );
		
	System.out.println( "Would you like to 1. Call, 2. Raise, or  3. Fold" );
	System.out.println( "Please type the integer that corresponds to your decision" );

	int action = Keyboard.readInt();

	clearScreen();

	// CALL
	if ( action == 1 ) {
	    
	    double ogPlayerBet = p.playerBet;//if someone raises the stayInBet from 100 to 200, and you already bet 100 you just need to add 100 to your original bet
	    if (p.balance < stayInBet){
		System.out.println("You don't have enough money to call, All In'd instead!");
		p.playerBet = p.balance;
		p.balance -= p.balance;
		pool = pool + p.balance - ogPlayerBet;
		System.out.println( "Updated balance: " + p.getBalance() );
	    }
	    else {
		p.playerBet = stayInBet;
		p.balance = p.balance - stayInBet + ogPlayerBet;
		pool = pool + stayInBet - ogPlayerBet;
		System.out.println( "You called." );
	    }
	    
	}

	// RAISE
	else if ( action == 2 ) {

	    System.out.println( "Your balance is " + p.getBalance() );
	    System.out.println( "The current pool is " + pool );
	    System.out.println( "The bet required to stay in the round is: " + stayInBet );
	    System.out.println( "How much would you like to raise by? ( Must be at least " + (stayInBet + 50) + " )" ); // add in 50 increments
	    double raiseAmt = Keyboard.readDouble();
	    if ( raiseAmt >= ( stayInBet + 50 ) ) {
		stayInBet = raiseAmt;
		clearScreen();
	    }
	    else {
		System.out.println( "Your raise was too low!  Returning to action screen..." );
		prompt( p );
	    }
	    
	    p.playerBet = raiseAmt;		
	    p.balance -= stayInBet;
	    System.out.println( "Raise - current bet amount is now " + stayInBet);
	    pool += stayInBet;
	}
	    
	// FOLD
	else if ( action == 3 ){
	    p.setInRound( false );
	    System.out.println( "You are now out of this round." );
	    System.out.println( "Updated balance: " + p.getBalance() );
	    System.out.println();
	}

    }

    public void prompt2 ( Player p ){//This method is called after the cards are dealt

	System.out.println( "========== Player " + p.getName() + "'s turn ==========" );
	System.out.println("The current cards are: " + tableCards);
	System.out.println( "Your cards are " + p.getHand() );
		    
	System.out.println( "Your balance is " + p.getBalance() );
	System.out.println( "The current pool is " + pool );
	System.out.println( "Your current bet is " + p.playerBet );
	System.out.println( "The bet required to stay in the round is: " + stayInBet );
	System.out.println();
	System.out.println( "Would you like to 1. Call, 2. Raise, 3. Fold, or 4. Check" );
	System.out.println( "Please type the integer that corresponds to your decision" );

	int action = Keyboard.readInt();
	clearScreen();

	// CALL
	if ( action == 1 ) {
	    double ogPlayerBet = p.playerBet;//if someone raises the stayInBet from 100 to 200, and you already bet 100 you just need to add 100 to your original bet
	    if (p.balance < stayInBet){
		System.out.println("You don't have enough money to call, All In'd instead!");
		p.playerBet = p.balance;
		p.balance -= p.balance;
		pool = pool + p.balance - ogPlayerBet;
		System.out.println( "Updated balance: " + p.getBalance() );
	    }
	    else {
		p.playerBet = stayInBet;
		p.balance = p.balance - stayInBet + ogPlayerBet;
		pool = pool + stayInBet - ogPlayerBet;
		System.out.println( "You called." );
	    }
 
	}

	// RAISE
	else if ( action == 2 ) {

	    System.out.println( "Your balance is " + p.getBalance() );
	    System.out.println( "The current pool is " + pool );
	    System.out.println( "The bet required to stay in the round is: " + stayInBet );
	    System.out.println( "How much would you like to raise by? ( Must be at least " + (stayInBet + 50) + " )" ); // add in 50 increments
	    double raiseAmt = Keyboard.readDouble();
	    if ( raiseAmt >= ( stayInBet + 50 ) ) {
		stayInBet = raiseAmt;
		clearScreen();
	    }
	    else {
		System.out.println( "Your raise was too low!  Returning to action screen..." );
		prompt( p );
	    }
	    
	    p.playerBet = raiseAmt;
	    p.balance -= raiseAmt;
	    System.out.println( "Raise - current bet amount is now " + stayInBet);
	    pool += raiseAmt;

	}
	    
	// FOLD
	else if ( action == 3 ){
	    p.setInRound( false );
	    System.out.println( "You are now out of this round." );
	    System.out.println( "Updated balance: " + p.getBalance() );
	    System.out.println();
	}

	

    }

    // Returns true if there is no winner yet.
    // Returns false if exactly one player is in the game.
    public boolean hasNoWinner( ArrayList<Player> players ) {
	boolean retBool = true;
	int counter = 0;
	for ( int i = 0 ; i < players.size() ; i++ ) {
	    if ( players.get(i).isInRound() ) counter++;
	}
	if ( counter == 1 ) retBool = false;
	return retBool;
    }

    /*
    public void removeLosers( ArrayList<Player> players ) {
	for ( Player p : players ) {
	    if ( p.balance < 0.0 ) {
		p.setInRound( false );
	    }
	}
    }
    */
    
    public void playRound(){

	// Reset tableCards
	for ( int i = 0 ; i < tableCards.size() ; i++ ) {
	    tableCards.remove(0);
	}

	// Creates new deck for the round, copy of DECK.
	_deck = new String[DECK.length];
	for( int i = 0; i < DECK.length; i++ ){
	    _deck[i]=  DECK[i];
	}

	stayInBet = 100; // Starting bet
	
	j = 0;
	while( j < players.size() ){
	    players.get(j).giveCards( getCard(),getCard() );
	    if (players.get(j).isInRound() == true){
	    prompt( players.get(j) );
	    }
	    if ( (j == players.size() - 1) && (numRaises > 0 ) ) {// resets the loop
		j = 0; // resets i 
		numRaises--;
	    }
	    else {j++;}
	}

	//removeLosers( players );
	
	if ( !hasNoWinner( players ) ) {
	    String winner = "";
	    for ( int i = 0 ; i < players.size() ; i++ ) {
		if( players.get(i).isInRound() ) winner = players.get(i).getName();
	    }
	    System.out.println();
	    System.out.println( "===========================" );
	    System.out.println( "The winner of the round is " + winner );
	    System.out.println( "===========================" );
	    return;
	    }

	// Print out remaining players
	System.out.println( "===========================" );
	System.out.println( "Players still in the round:" );
	for(int k = 0; k < players.size(); k++){
	    if ( players.get(k).isInRound() ) {
		System.out.println(players.get(k).getName()); // Prints names of each player
	    }
	}
	System.out.println( "===========================" );

	
	tableCards.add( getCard() );
	tableCards.add( getCard() );
	//Since the additionalTurns while loop deals a card, we only add 2 table cards since the initial setup is 3 cards
	    
	// For future turns
	int additionalTurns = 0;
	while ( additionalTurns < 3 && hasNoWinner( players ) ) {
	    //removeLosers( players );
	    clearScreen();
	    for( int i = 0; i < players.size(); i++ ){
		players.get(i).playerBet = 0;
	    }//needs to reset playerBet because it's > 0 right now
	    stayInBet = 0;
	    tableCards.add( getCard() );
	    System.out.println( "[DEALER] Current cards: " + tableCards );
	    j = 0;
	    while( j < players.size() ){
		if (players.get(j).isInRound() == true){
		    prompt2( players.get(j) );
		  }
		if ( (j == players.size() - 1) && (numRaises > 0 ) ) {// resets the loop
		    j = 0; // resets i 
		    numRaises--;
		}
		else {j++;}
	    }


	    additionalTurns++;
	    if ( !hasNoWinner( players ) ) {
		String winner = "";
		for ( int i = 0 ; i < players.size() ; i++ ) {
		    if( players.get(i).isInRound() ) winner = players.get(i).getName();
		}
		System.out.println();
		System.out.println( "================================" );
		System.out.println( "The winner of the round is " + winner );
		System.out.println( "================================" );
		return;
	    }
	}
	
    } // end playRound()
    
} // end Table

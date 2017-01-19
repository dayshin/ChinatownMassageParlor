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
    public ArrayList<String> tableCards;
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

	_deck = new String[DECK.length];
	for( int i = 0; i < DECK.length; i++ ){	 // copy deck	
	    _deck[i]=  DECK[i];
	}

	players = new ArrayList<Player>();

	for ( int i = 1 ; i <= numPlayers ; i += 1 ) {
	    System.out.println( "What is Player " + i + "'s name?" );
	    String playerName = Keyboard.readString();
	    Player p = new Player();
	    p.setName( playerName );
	    players.add( p );
	} // Codeblock idea from http://stackoverflow.com/questions/22335279/creating-multiple-objects-based-on-user-input

    }
	//playerName = name;
    /* public static String retArray(String [] arr){
	String retStr = "";
	for(String array : arr){
	    retStr += array + "\n";
	}
	return retStr;
	}*/ //Diag

   
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
    

    /*
    public void expand() 
    {
	String _data2[] = new String[tableCards.length + 1];
	for (int i = 0; i < tableCards.length; i++){
	    
	    _data2[i] = tableCards[i];
	}
        tableCards = _data2;
    }
    */


    public void playRound(){

	for ( Player p : players ) {
	    p.giveCards( getCard(),getCard() );
	    System.out.println( p );
	}
	// DEAL CARDS TO PLAYERS HERE

	int choice1 = 0;
	int choice2 = 0;
	
	
        tableCards = new ArrayList<String>();
	tableCards.add( getCard() );
	tableCards.add( getCard() );
	tableCards.add( getCard() );
    
	//System.out.print(retArray(_deck)); Diag
	System.out.println("===== Table Cards =====");
	System.out.println(getTC());
	System.out.println();

	/*
	System.out.println("Player1's cards: ");
	System.out.println(getPC1());	
	System.out.println("Player2's cards: ");
	System.out.println(getPC2());	// END TESTING ZONE

	while (tableCards.length < 5){
	    System.out.println("\nPlayer one, please enter 1 if you want call, or 2 if you want to fold.");
	    choice1 = Keyboard.readInt();
	    if (choice1 == 1){
		System.out.println("Player two, please enter 1 if you want call, or 2 if you want to fold.");
		choice2 = Keyboard.readInt();		
		if(choice2 == 1){
		    expand();
		    tableCards[tableCards.length - 1] = getCard();
		    playRound();
		}
		else{
		    System.out.println("Round over");
		    break;		    
		}
	    }
	    else{
		System.out.println("Round over");
		break;		
	    }
	   
	}
	*/
    }//end playRound()

    /*
    public void playGame() {
	
	

    } // end playGame()
    */

}

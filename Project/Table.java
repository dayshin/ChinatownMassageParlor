// Team mandarinOranges
// Bryan Chan, Eric Chen, Datian Zhang
// APCS1 pd3
import java.util.ArrayList;

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

    private ArrayList<String> _deck;

    private ArrayList<Players> _players;

    public Table(  ) {

	_players = new ArrayList<Players>[2];
	_players[0] = new Player( getCard(),getCard(),0.0,0.0 );
	_players[1] = new Player( getCard(),getCard(),0.0,0.0 );

	_deck = new ArrayList<String>();
	
	for( int i = 0; i < DECK.length; i++ ){		
	    _deck.add( DECK[i] );
	}

    } // end constructor

    public String getCard(){

	int randInt = (int)( Math.random() * _deck.size() );
	String retStr = _deck.get( randInt );
	_deck.remove( randInt );
	return retStr;
	
    }

    public ArrayList getDeck() {
	return _deck;
    }

}

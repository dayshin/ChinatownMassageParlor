// Team mandarinOranges
// Bryan Chan, Eric Chen, Datian Zhang
// APCS1 pd3

public class Table {

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
	"KD","KC","KH","KS"
	"AD", "AC", "AH", "AS",
	}


    //allocates memory for _deck based on size of DECK(see class Slots)
	public Table(){

	    _deck = new String[DECK.length];

	    for( int i = 0; i < _deck.length; i++ ){		
		_deck[i] = DECK[i]
	    }
	}//end constructor

    public String getCard(){

	
    }
	/*public static void main ( String [] args ){
	for (int i = 1; i < 2; i++ ){
	    System.out.print( "\"" + "K" + "D" + "\",");
	    System.out.print( "\"" + "K" + "C" + "\",");
	    System.out.print( "\"" + "K" + "H" + "\",");
	    System.out.println( "\"" + "K" + "S" + "\",");	       	    
	}
	}*/

}

// Team mandarinOranges
// APCS1 pd3
// Final Project -- Texas Hold'Em
import cs1.Keyboard;

public class Woo {

    public static void main ( String [] arg )
    {
	
	System.out.println( "=====================" );
	System.out.println( "    Texas Hold'Em    " );
	System.out.println( "=====================" );

	System.out.println( "Please specify how many players there are:" );
	int numPlayers = Keyboard.readInt();

	if ( numPlayers > 4 ) System.out.println( "Whoa, you're popular!" );

	System.out.println( "Creating game with " + numPlayers + " players..." );

	Table game = new Table( numPlayers ); // Create new game
	
        
	/*
	Table game = new Table();
	System.out.println("Cards of the table");
	/* DIAG
	System.out.println(game._deck.length);
	for(int i = 0; i < game. _deck.length; i++){
	    System.out.print(game._deck[i] + " ");
	    }*/
	/*System.out.println(game.getTC());
	System.out.println();
	System.out.println("Player1's cards: ");
	System.out.println(game.getPC1());	
	System.out.println("Player2's cards: ");
	System.out.println(game.getPC2());      */


	game.playRound();			   
   
    }//main
    
}

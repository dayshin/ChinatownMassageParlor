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

	/*
	System.out.println( "Please specify how many players there are:" );
	int numPlayers = Keyboard.readInt();

	System.out.println( "Creating game with " + numPlayers + " players..." );

	Table game = new Table( numPlayers ); // Create new game
	*/

	Table game = new Table();
<<<<<<< HEAD
	System.out.println("Cards of the table");
	System.out.println(game.getTC());
	System.out.println();
	System.out.println("Player1's cards: ");
	System.out.println(game.getPC1());	
	System.out.println("Player2's cards: ");
	System.out.println(game.getPC2());	// END TESTING ZONE
=======
       System.out.println( game.getCard() );
	System.out.println( game.getDeck() );

	System.out.println(game._setUp);
	
	// FOR TESTING PURPOSES ONLY, REMOVE AFTER

	System.out.println( game.getCard() );
	System.out.println( game.getDeck() );

	// END TESTING ZONE
>>>>>>> 97773da2708e171eeb6fbe99086d0ed8702cf5ce


    }
    
}

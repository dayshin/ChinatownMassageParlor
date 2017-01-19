// Team mandarinOranges
// Bryan Chan, Eric Chen, Datian Zhang
// APCS1 pd3

import cs1.Keyboard;

public class Player implements Comparable {

    public String name;
    public String Card1;
    public String Card2;
    public double balance;
    public float playerBet;

    public Player() {
	balance = 1000.00;
	name = "Player";
    }

    //public Player( float bigBlind, float smallBlind){
	//Card1=firstCard;
	//Card2=secondCard;
    //}

    public String getName() {
	return name;
    }

    public String setName( String newName ) {
	String oldName = name;
	name = newName;
	return oldName;
    }

    public String toString(){
	return Card1 + " " + Card2;
    }

    public void giveCards( String card1, String card2 ) {
	Card 1 = card1;
	Card 2 = card2;
    }
    /*
      public float playerAction(float Amt){
	if(Amt <= playerBet){
	    System.out.println(
			       "Welcome to Poker! I'm a bunny.\n " );
	    //  option[0] + option[1] + option[2])	
		}
	return Keyboard.readFloat();
    }
    */
    public int compareTo(Player a){
	// object instanceof Type
        if (Card1.substring(0,1) == (Card2.substring(0,1))){
	    return 1;
	}
	return 0;
    }
    /*  public static void main(String[] args){
	Player Datian = new Player("AD", "AS",0,0);
	Player Brien = new Player("5D", "3S",0,0);
	System.out.println(Datian);
	System.out.println(Brien.compareTo(Datian));
	}*/
}

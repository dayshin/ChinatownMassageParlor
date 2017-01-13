// Team mandarinOranges
// Bryan Chan, Eric Chen, Datian Zhang
// APCS1 pd3

import cs1.Keyboard;

public class Player implements Comparable {
    public String[] hand;
    private float playerBet;

    public Player( float bigBlind, float smallBlind ){
	hand = new String[2];
	hand[0]= getCard();
	hand[1]= getCard();
	playerBet=bigBlind+smallBlind;
    }
    public String[] getHand(){
	return hand;
    }
    public String toString(){
	return hand[0] + " " + hand[1];
    }
    public float playerAction(float Amt){
	if(Amt <= playerBet){
	    System.out.println(
			       "Welcome to Poker! I'm a bunny.\n " );
	    //  option[0] + option[1] + option[2])	
		}
	return Keyboard.readFloat();
    }
    public int compareTo(Player a){
	// object instanceof Type
	System.out.println(a.getHand()[0]);	
	return 0;
    }
    /*  public static void main(String[] args){
	Player Datian = new Player("AD", "AS",0,0);
	Player Brien = new Player("5D", "3S",0,0);
	System.out.println(Datian);
	System.out.println(Brien.compareTo(Datian));
	}*/
}

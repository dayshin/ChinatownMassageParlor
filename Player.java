// Team mandarinOranges
// Bryan Chan, Eric Chen, Datian Zhang
// APCS1 pd3

import cs1.Keyboard;
import java.util.ArrayList;


public class Player /*implements Comparable*/ {

    public String name;
    public String Card1;
    public String Card2;
    public String hand;
    public double balance;
    public double playerBet; // playerBet for every round - resets to 0 after every round
    public double totalBet; // totalBet is for all 3 rounds

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

    public String getHand(){
	return hand;
    }

    public String getBalance(){
	return balance + "";
    }
    public void setRB(double betAmount){ // set player bet to 0 after every round, to bigblind/100 other times
	playerBet=betAmount;
    }

    public void setName( String newName ) {
	name = newName;
    }

    public void giveCards( String card1, String card2 ) {
	Card1 = card1;
	Card2 = card2;
	hand = card1 + " " + card2;
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

    // Returns how much they call by, ie. if they don't have enough, it just returns their current balance.
    // Raise the same way
    public double callRaise( double stayInBet ) {
	if( stayInBet == 0 ){ // fold or check, no more money put inside
	    return 0;
	}
	 // raise or call doesn't matter from player end
	if ( stayInBet >= balance){
	    double retDouble = balance;
	    playerBet += balance; // always adding balance, player could've bet before
	    return retDouble;
	}
	
	balance= balance - stayInBet + playerBet; // add what player already bet that round, subtract how much it takes to stay in bet for that round
	return stayInBet; // how much total bet is
    }     




    public int card1Val(){

	if ( Card1.substring(0,1) == "J" ){
	    return 11;
	}
	if ( Card1.substring(0,1) == "Q" ){
	    return 12;
	}
	if ( Card1.substring(0,1) == "K" ){
	    return 13;
	}
	return Integer.parseInt(Card1.substring(0,1));
    }	
    public int card2Val(){

	if ( Card2.substring(0,1) == "J" ){
	    return 11;
	}
	if ( Card2.substring(0,1) == "Q" ){
	    return 12;
	}
	if ( Card2.substring(0,1) == "K" ){
	    return 13;
	}
	return Integer.parseInt(Card1.substring(0,1));
    }
    public String card1suit(){
	return Card1.substring(1);
    }
    public String card2suit(){
	return Card2.substring(1);
    }
    public ArrayList<String> allCards(ArrayList<String> tableCards){
	// arranges sorted array of ints - values as well as suites to make it easily manipulated? or just check for each specific thing
	// royal flush -> four of a kind (suit irrelevant) --> full house (suite irrelevant)  --> flush (suite and number relevant) --> straight
	tableCards.add(Card1);
	tableCards.add(Card2);
	int maxNum;
	int maxInd;
	//	for(int i=0; i<tableCards.length;i++){

	    // sort all 7 in an array and then list
	    /*  public int compareTo(Player a){
	// object instanceof Type
	// return highest number
        
	}*/
    /*  public static void main(String[] args){
	Player Datian = new Player("AD", "AS",0,0);
	Player Brien = new Player("5D", "3S",0,0);
	System.out.println(Datian);
	System.out.println(Brien.compareTo(Datian));
	}*/
	return tableCards;
    }
}

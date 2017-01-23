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
    public boolean inRound;

    public Player() {
	balance = 1000.00;
	name = "Player";
	inRound = true;
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

    public boolean isInRound() {
	return inRound;
    }
    
    /*public void setRB( double betAmount ) { // set player bet to 0 after every round, to bigblind/100 other times
	playerBet = betAmount;
	}*/

    public void setName( String newName ) {
	name = newName;
    }

    public void setInRound( boolean newBool ) {
	inRound = newBool;
    }

    public void giveCards( String card1, String card2 ) {
	Card1 = card1;
	Card2 = card2;
	hand = card1 + " " + card2;
    }

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
	
	balance = balance - stayInBet + playerBet; // add what player already bet that round, subtract how much it takes to stay in bet for that round
	return stayInBet; // how much total bet is
    }     




    public int cardVal(String card){
	if ( card.substring(0,1).equals("J") ){
	    return 11;
	}
	if ( card.substring(0,1).equals("Q") ){
	    return 12;
	}
	if ( card.substring(0,1).equals("K") ){
	    return 13;
	}
	return Integer.parseInt(card.substring(0,1));
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

    // sortCards - returns arraylist sorted by card value
    public ArrayList<String> sortCards(ArrayList<String> cards){
	String holder;
	for(int j=0;j<cards.size();j++){
	    for(int i=1;i<cards.size();i++){
		if(cardVal(cards.get(i))<cardVal(cards.get(i-1))){
		    holder = cards.get(i);
		    cards.set(i, cards.get(i-1));
		    cards.set(i-1,holder);
		}
	    }
	}
	return cards;
    }
    public static void main(String[] args){
	Player datian= new Player();
	ArrayList<String> lolCards=new ArrayList<String>();
	lolCards.add("5D");
	lolCards.add("JB");
	lolCards.add("3A");
	lolCards.add("4D");
	lolCards.add("KD");	
	System.out.println(datian.sortCards(lolCards));
    }
}

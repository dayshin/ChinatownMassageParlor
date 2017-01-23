

                                 Texas Hold'em

Created by mandarinOranges ( Bryan Chan, Datian Zhang, Eric Chen )

Launch Instructions:

 1. Clone our files: git clone git@github.com:dayshin/mandarinOranges.git
 2. Compile using: $ javac Woo.java
 3. Run our program using: $ java Woo
 4. When prompted, enter the number of players.
 5. Upon progression of game, input 1, 2, 3, 4 to choose whether to call, raise, fold, or check.

Thing(s) to note:

1. If your current bet is less than the bet required to stay in the round, you have to call or raise.
2. It is expected that you raise an amount greater than the current stayInBet.
3. If you all in'd, the only option you should choose is check, or call in the first round.
4. D stands for diamonds, C for Clubs, H for Hearts, and S for Spades

Description:
    Our project is a Texas Hold'em Poker Game.  The user will be able to designate the number of players playing in one game, and each player will take turns to either call, raise, fold or check.
    When someone is out of money, they will be removed from the list of players. The game will end when one player remains, and that player will be the winner.

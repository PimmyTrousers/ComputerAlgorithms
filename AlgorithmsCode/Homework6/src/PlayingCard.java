package Homework6;

import java.util.Iterator;
import java.util.Random;

public class PlayingCard implements Comparable<PlayingCard> {
	
	public enum  Rank { Two, Three, Four, Five, Six,
		Seven, Eight, Nine, Ten, Jack, Queen, King, Ace }
	
	public enum Suit { Clubs, Diamonds, Hearts, Spades }

	private Rank _r;
	private Suit _s;
	
	public PlayingCard(Rank r, Suit s) {
		this._r=r;
		this._s=s;
	}
	
	public Rank rank() {

		return this._r;
	}
	
	public Suit suit() {

		return this._s;
	}
	
	/***
	 * 
	 * @return an Iterator over a set of 52 PlayingCard objects in 
	 * their natural order
	 */
	public static Iterator<PlayingCard> OrderedDeck() {
		// TODO complete this for assignment
		return null;
	}
	
	/***
	 * 
	 * @return an Iterator over a set of 52 PlayingCard objects 
	 *  in a randomized order
	 */
	public static Iterator<PlayingCard> ShuffledDeck() {
		//TODO complete this for assignment
		return null;
	}
	
	/***
	 * asssumptions for natural ordering:
	 *   Rank:  Two < Three < ..Ten < Jack < Queen < King < Ace
	 *   Suit: Clubs < Diamonds < Hearts < Spades
	 */
	@Override
	public int compareTo(PlayingCard o) {
		// TODO complete this for assignment
		return 0;
	}

}

package com.cpjd.poker;

import com.cpjd.models.Card;
import com.cpjd.models.Number;
import com.cpjd.models.Suit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.*;

public class HandValueTest {

    @Test
    public void distinguish() {
        ArrayList<Card> sam = cards(card(Suit.HEARTS, Number.THREE), card(Suit.DIAMONDS, Number.FIVE), card(Suit.HEARTS, Number.TWO), card(Suit.CLUBS, Number.TWO), card(Suit.DIAMONDS, Number.FIVE));
        ArrayList<Card> will = cards(card(Suit.HEARTS, Number.FOUR), card(Suit.DIAMONDS, Number.FIVE), card(Suit.HEARTS, Number.TWO), card(Suit.CLUBS, Number.TWO), card(Suit.DIAMONDS, Number.FIVE));

        HandValue samHand = new HandValue(sam, HandValue.Category.TWO_PAIR);
        HandValue willHand = new HandValue(will, HandValue.Category.TWO_PAIR);


        assertTrue(HandValue.distinguish(willHand, samHand) > 0);
    }

    // Utils

    private Card card(Suit suit, Number number) {
        return new Card(suit, number);
    }

    private ArrayList<Card> cards(Card... cards) {
        if (cards == null) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(cards));
    }
}
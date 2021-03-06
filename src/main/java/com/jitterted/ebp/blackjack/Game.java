package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {

  private final Deck deck;

  private final Hand dealerHand = new Hand();
  private final Hand playerHand = new Hand();
  private int playerBalance;
  private int playerBet;

  public static void main(String[] args) {
    Game game = new Game();

    System.out.println(ansi()
                           .bgBright(Ansi.Color.WHITE)
                           .eraseScreen()
                           .cursor(1, 1)
                           .fgGreen().a("Welcome to")
                           .fgRed().a(" Jitterted's")
                           .fgBlack().a(" BlackJack"));


    game.initialDeal();
    game.play();

    System.out.println(ansi().reset());
  }

  public Game() {
    deck = new Deck();
    playerBalance = 100;
  }

  public void initialDeal() {

    // deal first round of cards, players first
    dealCardTo(playerHand);
    dealCardTo(dealerHand);

    // deal next round of cards
    dealCardTo(playerHand);
    dealCardTo(dealerHand);
  }

  private void dealCardTo(Hand hand) {
    hand.add(deck.draw());
  }

  public void play() {
    // get Player's decision: hit until they stand, then they're done (or they go bust)
    playerTurn();

    // Dealer makes its choice automatically based on a simple heuristic (<=16, hit, 17>stand)
    if (!playerHand.busted()) {
      dealerTurn();
    }

    displayFinalGameState();

    displayWinner();
  }

  private void displayWinner() {
    if (playerHand.busted()) {
      System.out.println("You Busted, so you lose.  💸");
    } else if (dealerHand.busted()) {
      System.out.println("Dealer went BUST, Player wins! Yay for you!! 💵");
    } else if (playerHand.beats(dealerHand)) {
      System.out.println("You beat the Dealer! 💵");
    } else if (playerHand.tiesWith(dealerHand)) {
      System.out.println("Push: The house wins, you Lose. 💸");
    } else {
      System.out.println("You lost to the Dealer. 💸");
    }
  }

  private void dealerTurn() {
    while (dealerHand.value() <= 16) {
      dealCardTo(dealerHand);
    }
  }

  private void playerTurn() {
    boolean playerBusted = false;
    while (!playerBusted) {
      displayGameState();
      String playerChoice = inputFromPlayer().toLowerCase();
      if (playerChoice.startsWith("s")) {
        break;
      }
      if (playerChoice.startsWith("h")) {
        dealCardTo(playerHand);
        playerBusted = playerHand.busted();
      } else {
        System.out.println("You need to [H]it or [S]tand");
      }
    }
  }

  private String inputFromPlayer() {
    System.out.println("[H]it or [S]tand?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private void displayGameState() {
    displayDealerHand();
    displayPlayerHand();
  }

  private void displayFinalGameState() {
    System.out.print(ansi().eraseScreen().cursor(1, 1));
    System.out.println("Dealer has: ");
    dealerHand.displayHand();
    System.out.println(" (" + dealerHand.value() + ")");

    displayPlayerHand();
  }

  private void displayDealerHand() {
    System.out.print(ansi().eraseScreen().cursor(1, 1));
    System.out.println("Dealer has: ");
    System.out.println(dealerHand.displayTopCard()); // first card is Face Up

    // second card is the hole card, which is hidden
    displayBackOfCard();
  }

  private void displayPlayerHand() {
    System.out.println();
    System.out.println("Player has: ");
    playerHand.displayHand();
    System.out.println(" (" + playerHand.value() + ")");
  }

  private void displayBackOfCard() {
    System.out.print(
        ansi()
            .cursorUp(7)
            .cursorRight(12)
            .a("┌─────────┐").cursorDown(1).cursorLeft(11)
            .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
            .a("│░ J I T ░│").cursorDown(1).cursorLeft(11)
            .a("│░ T E R ░│").cursorDown(1).cursorLeft(11)
            .a("│░ T E D ░│").cursorDown(1).cursorLeft(11)
            .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
            .a("└─────────┘"));
  }

  public int playerBalance() {
    return playerBalance;
  }

  public void playerBets(int betAmount) {
    playerBet = betAmount;
    playerBalance -= betAmount;
  }

  public void playerWins() {
    playerBalance += playerBet * 2;
  }

  public void playerLoses() {
    playerBalance += playerBet * 0;
  }

  public void playerTies() {
    playerBalance += playerBet * 1;
  }

  public void playerWinsBlackjack() {
    playerBalance += playerBet * 2.5;
  }
}

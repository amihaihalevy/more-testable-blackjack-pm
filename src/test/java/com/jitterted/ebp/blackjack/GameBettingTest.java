package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingTest {

  @Test
  public void gameStartsWithPlayerBalanceOf100Bucks() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }

  @Test
  public void playerBets35PlayerBalanceIs65() throws Exception {
    Game game = new Game();

    game.playerBets(35);

    assertThat(game.playerBalance())
        .isEqualTo(65);
  }

  @Test
  public void playerBets45AndWinsPlayerHas145() throws Exception {
    Game game = new Game();
    game.playerBets(45);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 45 + (45 * 2));
  }

  @Test
  public void playersBets45AndLosesPlayerHas55() throws Exception {
    Game game = new Game();
    game.playerBets(45);

    game.playerLoses();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 45);
  }

  @Test
  public void playersBets80AndGetBlackjackPlayerHas220() throws Exception {
    Game game = new Game();
    game.playerBets(80);

    game.playerWinsBlackjack();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 80 + (int) (80 * 2.5));
  }

  @Test
  public void playerBets45TiesAndBetIsReturned() throws Exception {
    Game game = new Game();
    game.playerBets(45);

    game.playerTies();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }
}

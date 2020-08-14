package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void newWalletAdd10BucksResultsInWalletNotBeingEmpty() throws Exception {
    Wallet wallet = new Wallet();

    wallet.add(10);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletAdd7BucksResultsInBalanceOf7Bucks() throws Exception {
    Wallet wallet = new Wallet();

    wallet.add(7);

    assertThat(wallet.balance())
        .isEqualTo(7);
  }

  @Test
  public void walletWith13BucksAdd9BucksResultsInBalanceOf22Bucks() throws Exception {
    Wallet wallet = new Wallet();
    wallet.add(13);

    wallet.add(9);

    assertThat(wallet.balance())
        .isEqualTo(13 + 9);
  }

  @Test
  public void walletWith16BucksBetting19BucksThrowsException() throws Exception {
    Wallet wallet = new Wallet();
    wallet.add(13);

    assertThatThrownBy(() -> {
      wallet.bet(19);
    })
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void walletWith15BucksBetting15BucksResultsInBalanceOf0Bucks() throws Exception {
    Wallet wallet = new Wallet();
    wallet.add(15);

    wallet.bet(15);

    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void walletWith18BucksBetting12BucksResultsInBalanceOf6Bucks() throws Exception {
    Wallet wallet = new Wallet();
    wallet.add(18);

    wallet.bet(12);

    assertThat(wallet.balance())
        .isEqualTo(18 - 12);
  }

  @Test
  public void newWalletCanBeLoadedWith100Bucks() throws Exception {
    Wallet wallet = new Wallet(100);

    assertThat(wallet.balance())
        .isEqualTo(100);
  }
}

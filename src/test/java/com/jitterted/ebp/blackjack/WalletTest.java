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

    wallet.addMoney(10);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletAdd7BucksResultsInBalanceOf7Bucks() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(7);

    assertThat(wallet.balance())
        .isEqualTo(7);
  }

  @Test
  public void walletWith13BucksAdd9BucksResultsInBalanceOf22Bucks() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(13);

    wallet.addMoney(9);

    assertThat(wallet.balance())
        .isEqualTo(13 + 9);

  }
}

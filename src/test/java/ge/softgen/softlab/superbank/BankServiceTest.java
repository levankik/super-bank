package ge.softgen.softlab.superbank;

import ge.softgen.softlab.superbank.entity.Balance;
import ge.softgen.softlab.superbank.service.BankServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class BankServiceTest {

    final BalanceRepository balanceRepository;
    final BankServiceImpl bankService = new BankServiceImpl(balanceRepository);

    @Test
    void getBalance() {
        final Balance balance = bankService.getBalance(1L);
        assertEquals(balance, BigDecimal.TEN);
    }

//    @Test
//    void getBalance_of_null() {
//        final Balance balance = bankService.getBalance(null);
//        assertEquals(balance, null);
//    }

    @Test
    void addMoney() {
        final Balance balance = bankService.addMoney(1L, BigDecimal.ONE);
        assertEquals(balance, BigDecimal.valueOf(11));
    }
}
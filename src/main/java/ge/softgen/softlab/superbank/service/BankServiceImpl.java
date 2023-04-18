package ge.softgen.softlab.superbank.service;

import ge.softgen.softlab.superbank.BalanceRepository;
import ge.softgen.softlab.superbank.DTO.TransferBalance;
import ge.softgen.softlab.superbank.entity.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService{

    private final BalanceRepository balanceRepository;

    @Override
    public Balance getBalance(Long accountId) {
        return balanceRepository.findByAccountId(accountId);
    }

    @Override
    public Balance addMoney(Long to, BigDecimal amount) {
        Balance newBalance = new Balance();
        Balance currentBalance = balanceRepository.findByAccountId(to);
        if (currentBalance == null) {
            newBalance.setAccountId(to);
            newBalance.setAmount(amount);
            newBalance.setLastUpdated(LocalDateTime.now());
            return balanceRepository.save(newBalance);
        } else {
            currentBalance.setAmount(amount);
            currentBalance.setLastUpdated(LocalDateTime.now());
            return balanceRepository.save(currentBalance);
        }
    }

    @Override
    public void makeTransfer(TransferBalance transferBalance) {
        
        Balance fromBalance = balanceRepository.findByAccountId(transferBalance.getFrom());
        Balance toBalance = balanceRepository.findByAccountId(transferBalance.getTo());
        if (fromBalance == null || toBalance == null)
            throw new IllegalArgumentException("At least one of id does not exist");
        if (transferBalance.getAmount().compareTo(toBalance.getAmount()) > 0)
            throw new IllegalArgumentException("There is no enough money to transfer");

        fromBalance.setAmount(fromBalance.getAmount().subtract(transferBalance.getAmount()));
        toBalance.setAmount(toBalance.getAmount().add(transferBalance.getAmount()));
        balanceRepository.save(fromBalance);
        balanceRepository.save(toBalance);
    }
}

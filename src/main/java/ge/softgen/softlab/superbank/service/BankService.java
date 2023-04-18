package ge.softgen.softlab.superbank.service;

import ge.softgen.softlab.superbank.DTO.TransferBalance;
import ge.softgen.softlab.superbank.entity.Balance;

import java.math.BigDecimal;

public interface BankService {
     Balance getBalance(Long accountId);

     Balance addMoney(Long to, BigDecimal amount);

     void makeTransfer(TransferBalance transferBalance);
}

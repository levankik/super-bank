package ge.softgen.softlab.superbank;

import ge.softgen.softlab.superbank.DTO.TransferBalance;
import ge.softgen.softlab.superbank.entity.Balance;
import ge.softgen.softlab.superbank.service.BankService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/balance")
@AllArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/{accountId}")
    public Balance getBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);
    }

    @PostMapping("/add")
    public Balance addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    @PostMapping ("/transfer")
    public void transfer (@RequestBody TransferBalance transferBalance ) {
          bankService.makeTransfer(transferBalance);
    }

}

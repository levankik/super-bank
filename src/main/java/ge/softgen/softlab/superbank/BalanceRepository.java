package ge.softgen.softlab.superbank;

import ge.softgen.softlab.superbank.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository <Balance, Integer> {
    Balance findByAccountId(Long accountId);
}

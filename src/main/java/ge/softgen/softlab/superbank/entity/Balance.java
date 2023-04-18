package ge.softgen.softlab.superbank.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "balance")
@SequenceGenerator(name = "balanceIdGenerator", sequenceName = "balance_id_seq", allocationSize = 1)
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balanceIdGenerator")
    @Column(name = "id")
    private Integer id;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "created", updatable = false)
    private LocalDateTime created;
    @Column(name = "last_updated", nullable  = false)
    private LocalDateTime lastUpdated;
    @PrePersist
    public void prePersist () {
        created = LocalDateTime.now();
    }
}




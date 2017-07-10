package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by CGQ-PC on 2017/7/7.
 */
@Entity
public class Weekly {
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private long id;
    /**
     * 累计放款金额
     */
    private BigDecimal totalBorrow_Amount;
    /**
     * 信贷累计放款金额
     */
    private BigDecimal totalBorrow_CreditAmount;
    /**
     * 分期累计放款金额
     */
    private BigDecimal totalBorrow_PhaseAmount;
    /**
     * 累计已还款金额
     */
    private BigDecimal totalRepamented_Amount;
    /**
     * 累计逾期金额
     */
    private BigDecimal totalRepament_LagAmount;
    /**
     * 累计逾期已还金额
     */
    private BigDecimal totalRepamented_LagAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    /**
     * 累计放款金额
     */
    public BigDecimal getTotalBorrow_Amount() {
        return totalBorrow_Amount;
    }
    /**
     * 累计放款金额
     */
    public void setTotalBorrow_Amount(BigDecimal totalBorrow_Amount) {
        this.totalBorrow_Amount = totalBorrow_Amount;
    }

    public BigDecimal getTotalBorrow_CreditAmount() {
        return totalBorrow_CreditAmount;
    }

    public void setTotalBorrow_CreditAmount(BigDecimal totalBorrow_CreditAmount) {
        this.totalBorrow_CreditAmount = totalBorrow_CreditAmount;
    }

    public BigDecimal getTotalBorrow_PhaseAmount() {
        return totalBorrow_PhaseAmount;
    }

    public void setTotalBorrow_PhaseAmount(BigDecimal totalBorrow_PhaseAmount) {
        this.totalBorrow_PhaseAmount = totalBorrow_PhaseAmount;
    }

    public BigDecimal getTotalRepamented_Amount() {
        return totalRepamented_Amount;
    }

    public void setTotalRepamented_Amount(BigDecimal totalRepamented_Amount) {
        this.totalRepamented_Amount = totalRepamented_Amount;
    }

    public BigDecimal getTotalRepament_LagAmount() {
        return totalRepament_LagAmount;
    }

    public void setTotalRepament_LagAmount(BigDecimal totalRepament_LagAmount) {
        this.totalRepament_LagAmount = totalRepament_LagAmount;
    }

    public BigDecimal getTotalRepamented_LagAmount() {
        return totalRepamented_LagAmount;
    }

    public void setTotalRepamented_LagAmount(BigDecimal totalRepamented_LagAmount) {
        this.totalRepamented_LagAmount = totalRepamented_LagAmount;
    }

    @Override
    public String toString() {
        return "Weekly{" +
                "id=" + id +
                ", totalBorrow_Amount=" + totalBorrow_Amount +
                ", totalBorrow_CreditAmount=" + totalBorrow_CreditAmount +
                ", totalBorrow_PhaseAmount=" + totalBorrow_PhaseAmount +
                ", totalRepamented_Amount=" + totalRepamented_Amount +
                ", totalRepament_LagAmount=" + totalRepament_LagAmount +
                ", totalRepamented_LagAmount=" + totalRepamented_LagAmount +
                '}';
    }
}

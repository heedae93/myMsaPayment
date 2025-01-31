package com.mymsapayment.banking.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;


@Entity
@Table(name = "request_firmbanking")
@Data
@ToString
public class RequestFirmBankingJpaEntity {

    @Id
    @GeneratedValue
    private  String requestFirmBankingId;
    private  String fromBankName;
    private  String fromBankAccountNumber;
    private  String toBankName;
    private  String toBankAccountNumber;
    private int moneyAmount;
    private int firmBankingStatus;
    private String uuid;

    public RequestFirmBankingJpaEntity( String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmBankingStatus, UUID uuid) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.firmBankingStatus = firmBankingStatus;
        this.uuid = uuid.toString();
    }
}

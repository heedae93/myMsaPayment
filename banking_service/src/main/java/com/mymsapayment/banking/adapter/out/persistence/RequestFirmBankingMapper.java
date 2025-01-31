package com.mymsapayment.banking.adapter.out.persistence;

import com.mymsapayment.banking.domain.FirmBankingRequest;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestFirmBankingMapper {
    public FirmBankingRequest mapToDomainEntity(
            RequestFirmBankingJpaEntity requestFirmBankingJpaEntity, UUID uuid) {

        return FirmBankingRequest.generateFirmBankingRequest(
                new FirmBankingRequest.FirmBankingRequestId(requestFirmBankingJpaEntity.getRequestFirmBankingId()),
                new FirmBankingRequest.FromBankName(requestFirmBankingJpaEntity.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(requestFirmBankingJpaEntity.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(requestFirmBankingJpaEntity.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(requestFirmBankingJpaEntity.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(requestFirmBankingJpaEntity.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(requestFirmBankingJpaEntity.getFirmBankingStatus()),
                uuid

        );
    }
}

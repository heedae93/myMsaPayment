package com.mymsapayment.banking.application.port.out;

import com.mymsapayment.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mymsapayment.banking.adapter.out.persistence.RequestFirmBankingJpaEntity;
import com.mymsapayment.banking.domain.FirmBankingRequest;
import com.mymsapayment.banking.domain.RegisterBankAccount;


public interface RequestFirmBankingPort {

    RequestFirmBankingJpaEntity createFirmBankingRequest(
        FirmBankingRequest.FromBankName fromBankName,
        FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
        FirmBankingRequest.ToBankName toBankName,
        FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
        FirmBankingRequest.MoneyAmount moneyAmount,
        FirmBankingRequest.FirmBankingStatus firmBankingStatus
    );

    RequestFirmBankingJpaEntity modifyFirmBankingRequest(
        RequestFirmBankingJpaEntity requestFirmBankingJpaEntity
    );
}

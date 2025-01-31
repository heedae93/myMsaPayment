package com.mymsapayment.banking.adapter.out.persistence;


import com.mymsapayment.banking.application.port.out.RegisteredBankAccountPort;
import com.mymsapayment.banking.application.port.out.RequestFirmBankingPort;
import com.mymsapayment.banking.domain.FirmBankingRequest;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import com.mymsapayment.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@PersistenceAdapter
class RequestFirmBankingPersistenceAdapter implements RequestFirmBankingPort {

    private final SpringDataRequestFirmBankingRepository springDataRequestFirmBankingRepository;

    @Override
    public RequestFirmBankingJpaEntity createFirmBankingRequest(FirmBankingRequest.FromBankName fromBankName, FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmBankingRequest.ToBankName toBankName, FirmBankingRequest.ToBankAccountNumber toBankAccountNumber, FirmBankingRequest.MoneyAmount moneyAmount, FirmBankingRequest.FirmBankingStatus firmBankingStatus) {
        RequestFirmBankingJpaEntity requestFirmBankingJpaEntity = springDataRequestFirmBankingRepository.save(
                new RequestFirmBankingJpaEntity(
                    fromBankName.getFromBankName(),
                    fromBankAccountNumber.getFromBankAccountNumber(),
                    toBankName.getToBankName(),
                    toBankAccountNumber.getToBankAccountNumber(),
                    moneyAmount.getMoneyAmount(),
                    firmBankingStatus.getFirmBankingStatus(),
                    UUID.randomUUID()
                )
        );
        return requestFirmBankingJpaEntity;
    }

    @Override
    public RequestFirmBankingJpaEntity modifyFirmBankingRequest(RequestFirmBankingJpaEntity requestFirmBankingJpaEntity) {
        return springDataRequestFirmBankingRepository.save(requestFirmBankingJpaEntity);

    }
}
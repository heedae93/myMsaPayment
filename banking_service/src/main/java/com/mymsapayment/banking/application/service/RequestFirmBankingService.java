package com.mymsapayment.banking.application.service;

import com.mymsapayment.banking.adapter.out.external.bank.BankAccount;
import com.mymsapayment.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.mymsapayment.banking.adapter.out.external.bank.FirmBankingResult;
import com.mymsapayment.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.mymsapayment.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mymsapayment.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.mymsapayment.banking.adapter.out.persistence.RequestFirmBankingJpaEntity;
import com.mymsapayment.banking.adapter.out.persistence.RequestFirmBankingMapper;
import com.mymsapayment.banking.application.port.in.FirmBankingRequestCommand;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountCommand;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountUseCase;
import com.mymsapayment.banking.application.port.in.RequestFirmBankingUseCase;
import com.mymsapayment.banking.application.port.out.RegisteredBankAccountPort;
import com.mymsapayment.banking.application.port.out.RequestBankAccountInfoPort;
import com.mymsapayment.banking.application.port.out.RequestExternalFirmBankingPort;
import com.mymsapayment.banking.application.port.out.RequestFirmBankingPort;
import com.mymsapayment.banking.domain.FirmBankingRequest;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import com.mymsapayment.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmBankingPort   requestFirmBankingPort;

    private final RequestFirmBankingMapper requestFirmBankingMapper;

    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;


    @Override
    public FirmBankingRequest requestFirmBanking(FirmBankingRequestCommand registerBankAccountCommand) {


        RequestFirmBankingJpaEntity requestFirmBankingJpaEntity = requestFirmBankingPort.createFirmBankingRequest(
                new FirmBankingRequest.FromBankName(registerBankAccountCommand.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(registerBankAccountCommand.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(registerBankAccountCommand.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(registerBankAccountCommand.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(registerBankAccountCommand.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(0)
        );

        // 외부 은행에 펌뱅킹 요청
        FirmBankingResult firmBankingResult = requestExternalFirmBankingPort.requestExternalFirmBanking(new ExternalFirmBankingRequest(
                registerBankAccountCommand.getFromBankName(),
                registerBankAccountCommand.getFromBankAccountNumber(),
                registerBankAccountCommand.getToBankName(),
                registerBankAccountCommand.getToBankAccountNumber()
        ));

        UUID radonUUID =  UUID.randomUUID();
        requestFirmBankingJpaEntity.setUuid(radonUUID.toString());

        if (firmBankingResult.getResultCode() == 0) {

            requestFirmBankingJpaEntity.setFirmBankingStatus(1);
        } else {
            requestFirmBankingJpaEntity.setFirmBankingStatus(2);
        }

        // 결과를 리턴하기 전에 바뀐 상태값을 다시 save
        RequestFirmBankingJpaEntity request  = requestFirmBankingPort.modifyFirmBankingRequest(requestFirmBankingJpaEntity);
        return requestFirmBankingMapper.mapToDomainEntity(request, radonUUID);
    }
}

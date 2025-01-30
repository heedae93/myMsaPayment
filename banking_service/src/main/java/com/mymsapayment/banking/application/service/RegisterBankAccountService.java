package com.mymsapayment.banking.application.service;

import com.mymsapayment.banking.adapter.out.external.bank.BankAccount;
import com.mymsapayment.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.mymsapayment.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mymsapayment.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountCommand;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountUseCase;
import com.mymsapayment.banking.application.port.out.RegisteredBankAccountPort;
import com.mymsapayment.banking.application.port.out.RequestBankAccountInfoPort;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import com.mymsapayment.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisteredBankAccountPort registeredBankAccountPort;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    private final RegisteredBankAccountMapper registeredBankAccountMapper;


    @Override
    public RegisterBankAccount registerBankAccount(RegisterBankAccountCommand registerBankAccountCommand) {

        registerBankAccountCommand.getBankName();
        registerBankAccountCommand.getBankAccountNumber();

        // 실제 외부의 은행 계좌 정보를 get
        BankAccount bankAccount =  requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(registerBankAccountCommand.getBankName(),registerBankAccountCommand.getBankAccountNumber()));
        boolean accountIsValid = bankAccount.isValid();

        if (accountIsValid) {

            // 등록 정보 저장
            RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity =  registeredBankAccountPort.createRegisteredBankAccount(
                   new RegisterBankAccount.MembershipId(registerBankAccountCommand.getMembershipId()),
                   new RegisterBankAccount.BankName(registerBankAccountCommand.getBankName()),
                    new RegisterBankAccount.BankAccountNumber(registerBankAccountCommand.getBankAccountNumber()),
                    new RegisterBankAccount.LinkedStatusIsValid(registerBankAccountCommand.isLinkedStatusIsValid())
            );

            return registeredBankAccountMapper.mapToDomainEntity(registeredBankAccountJpaEntity);
        } else {
            return null;
        }

    }
}

package com.mymsapayment.banking.adapter.out.persistence;

import com.mymsapayment.banking.domain.RegisterBankAccount;

import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {
    public RegisterBankAccount mapToDomainEntity(
            RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {

        return RegisterBankAccount.generateRegisterBankAccount(
                new RegisterBankAccount.RegisteredBankAccountId(registeredBankAccountJpaEntity.getMembershipId()+""),
                new RegisterBankAccount.MembershipId(registeredBankAccountJpaEntity.getMembershipId()),
                new RegisterBankAccount.BankName(registeredBankAccountJpaEntity.getBankName()),
                new RegisterBankAccount.BankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber()),
                new RegisterBankAccount.LinkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
        );
    }
}

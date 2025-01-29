package com.mymsapayment.banking.adapter.out.persistence;


import com.mymsapayment.banking.application.port.out.RegisteredBankAccountPort;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import com.mymsapayment.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class RegisteredBankAccountPersistenceAdapter implements RegisteredBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository springDataRegisteredBankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisterBankAccount.MembershipId membershipId, RegisterBankAccount.BankName bankName, RegisterBankAccount.BankAccountNumber bankAccountNumber, RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return springDataRegisteredBankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkedStatusIsValid.isLinkedStatusIsValid()
                )
        );

    }
}
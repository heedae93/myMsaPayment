package com.mymsapayment.banking.adapter.out.external.bank;


import com.mymsapayment.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.mymsapayment.banking.application.port.out.RequestBankAccountInfoPort;
import com.mymsapayment.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ExternalSystemAdapter
class BankAccountAdapter implements RequestBankAccountInfoPort {

    private final SpringDataRegisteredBankAccountRepository springDataRegisteredBankAccountRepository;
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest getBankAccountRequest) {
        return new BankAccount(getBankAccountRequest.getBankName(),getBankAccountRequest.getBankAccountNumber(),true);
    }
}
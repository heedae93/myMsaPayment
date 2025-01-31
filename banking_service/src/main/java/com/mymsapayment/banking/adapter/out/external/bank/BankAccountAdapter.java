package com.mymsapayment.banking.adapter.out.external.bank;


import com.mymsapayment.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.mymsapayment.banking.application.port.out.RequestBankAccountInfoPort;
import com.mymsapayment.banking.application.port.out.RequestExternalFirmBankingPort;
import com.mymsapayment.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ExternalSystemAdapter
class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {

    private final SpringDataRegisteredBankAccountRepository springDataRegisteredBankAccountRepository;
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest getBankAccountRequest) {
        return new BankAccount(getBankAccountRequest.getBankName(),getBankAccountRequest.getBankAccountNumber(),true);
    }

    @Override
    public FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest externalFirmBankingRequest) {
        // 실제 외부 은행에 http 통신을 통해서 펌뱅킹 요청을 하고
        // 그 결과를 FirmBankingResult에 매핑
        FirmBankingResult result =  new FirmBankingResult('0');
        return result;
    }
}
package com.mymsapayment.banking.application.port.out;


import com.mymsapayment.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.mymsapayment.banking.adapter.out.external.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {
    FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest externalFirmBankingRequest);
}

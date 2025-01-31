package com.mymsapayment.banking.adapter.out.external.bank;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExternalFirmBankingRequest {
        private String fromBankName;
        private String fromBankAccountNumber;
        private String toBankName;
        private String toBankAccountNumber;



}

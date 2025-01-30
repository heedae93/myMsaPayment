package com.mymsapayment.banking.adapter.out.external.bank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class GetBankAccountRequest {
        private String bankName;
        private String bankAccountNumber;



}

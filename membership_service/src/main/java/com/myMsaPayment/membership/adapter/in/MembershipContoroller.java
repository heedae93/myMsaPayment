package com.myMsaPayment.membership.adapter.in;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MembershipContoroller {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}

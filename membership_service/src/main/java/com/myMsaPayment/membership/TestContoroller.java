package com.myMsaPayment.membership;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestContoroller {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}

package com.jobayerms.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
public class FraudCheckController
{
    @Autowired
    private FraudCheckService fraudCheckService;

    @GetMapping("customer/{customerId}")
    public FraudCheckHistory isTheUserIsFraud(@PathVariable("customerId") Integer customerId){
        FraudCheckHistory fraudCheckHistory = fraudCheckService.isTheCustomerIsFraud(customerId);
        return fraudCheckHistory;
    }

}

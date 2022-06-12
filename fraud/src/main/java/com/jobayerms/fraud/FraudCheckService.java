package com.jobayerms.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService
{
    @Autowired
    private FraudCheckRepository fraudCheckRepository;

    public FraudCheckHistory isTheCustomerIsFraud(Integer customerId)
    {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();
        fraudCheckRepository.save(fraudCheckHistory);
        return fraudCheckHistory;

    }
}

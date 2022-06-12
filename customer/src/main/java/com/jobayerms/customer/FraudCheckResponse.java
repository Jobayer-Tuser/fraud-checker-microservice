package com.jobayerms.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudCheckResponse {
    private Long id;
    private int customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}


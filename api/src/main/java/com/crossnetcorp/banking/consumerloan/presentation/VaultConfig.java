package com.crossnetcorp.banking.consumerloan.presentation;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@ConfigurationProperties("consumerload")
public class VaultConfig {
    private String host;
    private String username;
    private String password;
}

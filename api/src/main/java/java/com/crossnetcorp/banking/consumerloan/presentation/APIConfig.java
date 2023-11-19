package com.crossnetcorp.banking.consumerloan.presentation;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author ccolome
 */
@Configuration
@ComponentScan(basePackages = "com.crossnetcorp.banking.consumerloan.application.*,com.crossnetcorp.banking.consumerloan.domain.*,com.crossnetcorp.banking.consumerloan.infrastructure.*")
@EnableJpaRepositories(basePackages = {"com.crossnetcorp.banking.consumerloan.infrastructure.*"})
@EntityScan("com.crossnetcorp.banking.consumerloan.infrastructure.*")
public class APIConfig {
    
}

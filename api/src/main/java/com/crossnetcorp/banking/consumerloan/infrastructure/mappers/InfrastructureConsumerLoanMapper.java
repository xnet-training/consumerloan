package com.crossnetcorp.banking.consumerloan.infrastructure.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

import com.crossnetcorp.banking.consumerloan.domain.model.ConsumerLoan;
import com.crossnetcorp.banking.consumerloan.infrastructure.model.mysql.ConsumerLoanTable;

/**
 *
 * @author ianache
 */
@Mapper(componentModel = "spring")
public interface InfrastructureConsumerLoanMapper {

    /**
     * map ConsumerLoan to ConsumerLoanTable
     * @param consumerLoan
     * @return ConsumerLoanTable
     */
    ConsumerLoanTable translateConsumerLoanToConsumerLoanTable(ConsumerLoan consumerloan);

    /**
     * map ConsumerLoanTable to ConsumerLoan
     * @param consumerLoan
     * @return ConsumerLoan
     */
    ConsumerLoan translateConsumerLoanTableToConsumerLoan(ConsumerLoanTable consumerloan);

    /**
     * map List:ConsumerLoan to List:ConsumerLoanTable
     * @param consumerLoans
     * @return List:ConsumerLoanTable
     */
    default List<ConsumerLoanTable> translateConsumerLoansToConsumerLoansTable(List<ConsumerLoan> consumerloans) {
        return consumerloans.stream().map(v -> translateConsumerLoanToConsumerLoanTable(v))
                .collect(Collectors.toList());
    }

    /**
     * map List:ConsumerLoanTable to List:ConsumerLoan
     * @param consumerLoans
     * @return List:ConsumerLoan
     */
    default List<ConsumerLoan> translateConsumerLoansTableToConsumerLoans(List<ConsumerLoanTable> consumerloans) {
        return consumerloans.stream().map(v -> translateConsumerLoanTableToConsumerLoan(v))
                .collect(Collectors.toList());
    }
    
}

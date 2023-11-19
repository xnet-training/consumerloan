package com.crossnetcorp.banking.consumerloan.presentation.mappers;

import com.crossnetcorp.banking.consumerloan.application.model.ConsumerLoanDTO;
import com.crossnetcorp.banking.consumerloan.presentation.views.PrestamoConsumoPignoraticioRequest;
import com.crossnetcorp.banking.consumerloan.presentation.views.ResourceId;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author ianache
 */
@Mapper(componentModel = "spring")
public interface PresentationConsumerLoanMapper {

    /**
     * map PrestamoConsumoPignoraticioRequest to ConsumerLoanDTO
     * @param newConsumerLoanRequest
     * @return ConsumerLoanDTO
     */
    ConsumerLoanDTO newConsumerLoanRequestToConsumerLoanDTO(PrestamoConsumoPignoraticioRequest newConsumerLoanRequest);

    /**
     * map ConsumerLoan to NewConsumerLoanView
     * @param consumerLoan
     * @return NewConsumerLoanView
     */
    @Mappings({
        @Mapping(target = "id", source = "id")
    })
    ResourceId toNewConsumerLoanView(ConsumerLoanDTO consumerLoan);

    /**
     * map ListConsumerLoanDTO to ListConsumerLoanView
     * @param consumerLoan
     * @return ListConsumerLoanView
     */
    //ListConsumerLoanView toListConsumerLoanView(ConsumerLoanDTO consumerLoans);

    /**
     * map List:ConsumerLoan to List:ListConsumerLoanView
     * @param consumerLoan
     * @return List:ListConsumerLoanView
     */
    //default List<ListConsumerLoanView> toListConsumerLoansView(List<ConsumerLoanDTO> consumerLoan) {
    //    return consumerLoan.stream().map(nv -> toListConsumerLoanView(nv))
    //            .collect(Collectors.toList());
   // }
}

package com.crossnetcorp.banking.consumerloan.application.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

import com.crossnetcorp.banking.consumerloan.application.model.ConsumerLoanDTO;
import com.crossnetcorp.banking.consumerloan.domain.model.ConsumerLoan;

/**
 *
 * @author ianache
 */
@Mapper(componentModel = "spring")
public interface ApplicationConsumerLoanMapper {

    /**
     * Traduce a DTO desde Dominio
     * @param ConsumerLoan
     * @return ConsumerLoanDTO
     */
    ConsumerLoanDTO toConsumerLoanDTO(ConsumerLoan consumerLoan);
    
    /**
     * Traduce a Dominio desde DTO
     * @param ConsumerLoan
     * @return 
     */
    default ConsumerLoan fromConsumerLoanDTO(ConsumerLoanDTO dto) {;
        return ConsumerLoan.builder()
            .clienteId(dto.getClienteId())
            .productoId(dto.getProductoId())
            .solicitudId(dto.getSolicitudId())
            .cuotas(dto.getCuotas())
            .ammount(dto.getAmmount())
            .build();        
    }

    /**
     * Traduce a lista de consumerloan DTO
     * @param consumerloan
     * @return 
     */
    default List<ConsumerLoanDTO> toConsumerLoanDTO(List<ConsumerLoan> consumerloan) {
        return consumerloan.stream().map(nv -> toConsumerLoanDTO(nv))
                .collect(Collectors.toList());
    }
}

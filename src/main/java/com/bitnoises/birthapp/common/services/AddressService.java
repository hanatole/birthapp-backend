package com.bitnoises.birthapp.common.services;

import com.bitnoises.birthapp.common.entity.Address;
import com.bitnoises.birthapp.common.repository.IAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressService {
    private final IAddressRepository addressRepository;

    public Address create(Address address) {
        return addressRepository.save(address);
    }
}

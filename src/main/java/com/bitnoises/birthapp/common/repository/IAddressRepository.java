package com.bitnoises.birthapp.common.repository;

import com.bitnoises.birthapp.common.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}

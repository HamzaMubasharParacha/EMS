package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.EmsCustomer;

public interface EmsCustomerRepository extends JpaRepository<EmsCustomer, Long> {
}

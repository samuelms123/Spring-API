package fi.metropolia.samuelms.Spring_API.repositories;

import fi.metropolia.samuelms.Spring_API.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
}

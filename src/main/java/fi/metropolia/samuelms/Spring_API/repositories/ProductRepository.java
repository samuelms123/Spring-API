package fi.metropolia.samuelms.Spring_API.repositories;

import fi.metropolia.samuelms.Spring_API.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

package fi.metropolia.samuelms.Spring_API.repositories;

import fi.metropolia.samuelms.Spring_API.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.name like :keyword%")
    List<Product> findProductsByKeyword(@Param("keyword") String keyword);
}

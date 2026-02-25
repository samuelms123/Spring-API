package fi.metropolia.samuelms.Spring_API.repositories;

import fi.metropolia.samuelms.Spring_API.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

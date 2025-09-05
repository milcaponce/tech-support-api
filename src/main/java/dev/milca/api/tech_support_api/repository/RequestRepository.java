package dev.milca.api.tech_support_api.repository;

import dev.milca.api.tech_support_api.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}

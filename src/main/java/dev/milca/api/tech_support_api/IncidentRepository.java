package dev.milca.api.tech_support_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByApplicantNameContainingIgnoreCase(@Param("name") String name);
}

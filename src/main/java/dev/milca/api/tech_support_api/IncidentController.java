package dev.milca.api.tech_support_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepository;

    // Endpoint para obtener todos los incidentes
    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    // Endpoint para obtener un incidente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        Incident incident = incidentRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Incidente no encontrado con ID: " + id));
        return ResponseEntity.ok(incident);
    }

    // Endpoint para crear un nuevo incidente
    @PostMapping
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
        incident.setLastEditedDate(new Date());
        Incident newIncident = incidentRepository.save(incident);
        return ResponseEntity.ok(newIncident);
    }
}

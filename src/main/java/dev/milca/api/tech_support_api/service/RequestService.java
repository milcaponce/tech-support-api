package dev.milca.api.tech_support_api.service;

import dev.milca.api.tech_support_api.model.Request;
import dev.milca.api.tech_support_api.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    
    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    
    public Optional<Request> updateRequest(Long id, Request updatedRequest) {
        return requestRepository.findById(id).map(request -> {
            request.setApplicantName(updatedRequest.getApplicantName());
            request.setSubject(updatedRequest.getSubject());
            request.setDescription(updatedRequest.getDescription());
            request.setLastEditedDate(LocalDateTime.now());
            return requestRepository.save(request);
        });
    }

    
    public boolean deleteRequest(Long id) {
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (requestOptional.isPresent() && requestOptional.get().getIsAttended()) {
            requestRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
    public Optional<Request> attendRequest(Long id, String attendedBy) {
        return requestRepository.findById(id).map(request -> {
            request.setIsAttended(true);
            request.setAttendedBy(attendedBy);
            request.setAssistanceDate(LocalDateTime.now());
            return requestRepository.save(request);
        });
    }
}
package dev.milca.api.tech_support_api.controller;

import dev.milca.api.tech_support_api.model.Request;
import dev.milca.api.tech_support_api.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestService requestService;

    
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }


    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request newRequest = requestService.createRequest(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }
}


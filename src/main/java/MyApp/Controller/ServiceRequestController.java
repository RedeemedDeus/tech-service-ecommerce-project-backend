package MyApp.Controller;

import MyApp.Model.ServiceRequest;
import MyApp.Service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceRequestController {
    ServiceRequestService serviceRequestService;

    @Autowired
    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    /**
     * 1. As a user I should be able to submit a service request
     * POST localhost:9000/request
     */
    @PostMapping("request")
    public ServiceRequest postRequest(@RequestBody ServiceRequest serviceRequest) {
        return serviceRequestService.addRequest(serviceRequest);
    }

    /**
     * 2.As a user, I should be able to see all service requests
     * GET localhost:9000/request
     */
    @GetMapping("request")
    public List<ServiceRequest> getAllRequests() {
        return serviceRequestService.getAllRequests();
    }
}

package MyApp.Controller;

import MyApp.Model.ServiceRequest;
import MyApp.Service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
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


    /**
     * 3.As a company worker I should be able to see any unfulfilled service requests
     * GET localhost:9000/request?fulfilled={true/false}
     */
    @GetMapping(value = "request", params = "fulfilled")
    public List<ServiceRequest> getAllRequestsFulfilled(@RequestParam(name = "fulfilled") boolean fulfilled) {
        return serviceRequestService.getAllRequestsFulfilled(fulfilled);
    }

    /**
     * 4. As a company worker I should be able to look up service requests by id
     * GET localhost:9000/request/{id}
     */
    @GetMapping("request/{id}")
    public ServiceRequest getRequestById(@PathVariable long id) {
        return serviceRequestService.getRequestById(id);
    }

    /**
     * 5. As a company worker I should be able to look and fulfill service requests
     * PATCH localhost:9000/request/{id} - with request body {fulfilled="true"}
     */
    @PatchMapping("request/{id}")
    public ServiceRequest changeRequestStatus(@RequestBody ServiceRequest request, @PathVariable long id) {
        return serviceRequestService.changeRequestStatus(id,request);
    }



}

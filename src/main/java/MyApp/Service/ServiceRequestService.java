package MyApp.Service;

import MyApp.Model.ServiceRequest;
import MyApp.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceRequestService {
    ServiceRequestRepository serviceRequestRepository;

    @Autowired
    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }
    public ServiceRequest addRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    public List<ServiceRequest> getAllRequests() {
        return  serviceRequestRepository.findAll();
    }
}

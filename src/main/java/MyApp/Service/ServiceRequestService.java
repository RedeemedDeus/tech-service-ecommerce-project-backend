package MyApp.Service;

import MyApp.Model.ServiceRequest;
import MyApp.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public ServiceRequest getRequestById(long id) {
        return  serviceRequestRepository.findById(id).get();
    }
}

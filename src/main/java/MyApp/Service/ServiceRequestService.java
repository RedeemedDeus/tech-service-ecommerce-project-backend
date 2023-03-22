package MyApp.Service;

import MyApp.Model.ServiceRequest;
import MyApp.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public List<ServiceRequest> getAllRequestsFulfilled(boolean fulfilled) {
        return serviceRequestRepository.getRequestsByFulfilled(fulfilled);
    }

    public ServiceRequest getRequestById(long id) {
        Optional<ServiceRequest> requestOptional = serviceRequestRepository.findById(id);

        return requestOptional.get();
    }

    public ServiceRequest changeRequestStatus(long id, ServiceRequest request) {
        ServiceRequest request1 = serviceRequestRepository.findById(id).get();
        request1.setFulfilled(request.isFulfilled());
        serviceRequestRepository.save(request1);
        return request1;

    }
}

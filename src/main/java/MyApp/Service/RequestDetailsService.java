package MyApp.Service;

import MyApp.Model.RequestDetails;
import MyApp.Model.ServiceRequest;
import MyApp.Repository.RequestDetailsRepository;
import MyApp.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestDetailsService {
    RequestDetailsRepository requestDetailsRepository;
    ServiceRequestRepository serviceRequestRepository;

    @Autowired
    public RequestDetailsService(RequestDetailsRepository requestDetailsRepository, ServiceRequestRepository serviceRequestRepository){
        this.requestDetailsRepository = requestDetailsRepository;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    /**
     * add a request
     */
    public RequestDetails saveRequestDetails(long id, RequestDetails requestDetails){
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).get();
        requestDetails.setServiceRequest(serviceRequest);
        serviceRequest.getRequestDetails().add(requestDetails);
        return requestDetailsRepository.save(requestDetails);
    }

    /**
     * get all requests
     */
    public List<RequestDetails> getAllRequestDetails(){
        return requestDetailsRepository.findAll();
    }

    public RequestDetails getRequestDetailsById(long id){ return requestDetailsRepository.findById(id).get(); }

    /**
     * update a request
     * @param id
     * @param updatedRequestDetails
     * @return requestDetails
     */
    public RequestDetails updateRequestDetails(long id, RequestDetails updatedRequestDetails){
        RequestDetails oldRequestDetails = requestDetailsRepository.findById(id).get();

        //set all changes
        oldRequestDetails.setCustomerName(updatedRequestDetails.getCustomerName());
        oldRequestDetails.setComment(updatedRequestDetails.getComment());
        oldRequestDetails.setHours(updatedRequestDetails.getHours());
        oldRequestDetails.setTotalPrice(updatedRequestDetails.getTotalPrice());

        return requestDetailsRepository.save(oldRequestDetails);
    }

    public RequestDetails deleteRequestDetails(long id){
        RequestDetails requestDetails = requestDetailsRepository.findById(id).get();
        requestDetailsRepository.delete(requestDetails);
        return requestDetails;
    }
}

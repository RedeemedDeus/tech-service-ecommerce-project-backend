package MyApp.Service;

import MyApp.Model.RequestDetails;
import MyApp.Repository.RequestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDetailsService {
    RequestDetailsRepository requestDetailsRepository;

    @Autowired
    public RequestDetailsService(RequestDetailsRepository requestDetailsRepository){
        this.requestDetailsRepository = requestDetailsRepository;
    }

    /**
     * add a request
     */
    public RequestDetails saveRequest(RequestDetails requestDetails){
        return requestDetailsRepository.save(requestDetails);
    }

    /**
     * get all requests
     */
    public List<RequestDetails> getAllRequests(){
        return requestDetailsRepository.findAll();
    }


}

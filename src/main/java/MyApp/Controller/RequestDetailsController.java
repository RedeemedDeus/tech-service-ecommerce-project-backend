package MyApp.Controller;

import MyApp.Model.RequestDetails;
import MyApp.Service.RequestDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestDetailsController {

    RequestDetailsService requestDetailsService;

    @Autowired
    public RequestDetailsController(RequestDetailsService requestDetailsService){
        this.requestDetailsService = requestDetailsService;
    }

    /**
     * localhost:9000/details
     * {
     *   "customerName": "user",
     *   "comment": "a comment here",
     *   "hours": 1,
     *   "totalPrice": 10.00
     * }
     * @param requestDetails
     * @return a new request
     */
    @PostMapping("details")
    public RequestDetails postRequest(@RequestBody RequestDetails requestDetails){
        return requestDetailsService.saveRequest(requestDetails);
    }

    @GetMapping("details")
    public List<RequestDetails> getAllRequests(){
        return requestDetailsService.getAllRequests();
    }


}

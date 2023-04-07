package MyApp.Controller;

import MyApp.Model.RequestDetails;
import MyApp.Service.RequestDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RequestDetailsController {

    RequestDetailsService requestDetailsService;

    @Autowired
    public RequestDetailsController(RequestDetailsService requestDetailsService){
        this.requestDetailsService = requestDetailsService;
    }

    /**
     * POST localhost:9000/request/{id}/details
     * {
     *   "customerName": "user",
     *   "comment": "a comment here",
     *   "hours": 1,
     *   "totalPrice": 10
     * }
     * @param requestDetails
     * @return a new RequestDetails object
     */
    @PostMapping("request/{id}/details")
    public RequestDetails postRequestDetails(@PathVariable long id, @RequestBody RequestDetails requestDetails){
        return requestDetailsService.saveRequestDetails(id, requestDetails);
    }

    /**
     * GET localhost:9000/details
     * @return a list of requestDetail objects
     */
    @GetMapping("details")
    public List<RequestDetails> getAllRequestDetails(){
        return requestDetailsService.getAllRequestDetails();
    }

    @GetMapping("details/{id}")
    public RequestDetails getRequestDetailsById(@PathVariable long id){
        return requestDetailsService.getRequestDetailsById(id);
    }

    /**
     * PATCH localhost:9000/details/{id}
     * {
     *  "customerName": "user", -> "alice"
     *  "comment": "a comment here", -> "I would like to do this..."
     *  "hours": 1, -> 2
     *  "totalPrice": 10 -> 20
     * }
     * @param id
     * @param requestDetails
     * @return requestDetails object
     */
    @PatchMapping("details/{id}")
    public RequestDetails updateRequestDetails(@PathVariable long id, @RequestBody RequestDetails requestDetails){
        return requestDetailsService.updateRequestDetails(id, requestDetails);
    }

    /**
     * DELETE localhost:9000/details/{id}
     * @param id
     * @return deleted requestDetails
     */
    @DeleteMapping("details/{id}")
    public RequestDetails deleteRequestDetails(@PathVariable long id){
        return requestDetailsService.deleteRequestDetails(id);
    }
}

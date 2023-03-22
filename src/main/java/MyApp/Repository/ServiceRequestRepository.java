package MyApp.Repository;

import MyApp.Model.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    List<ServiceRequest> getRequestsByFulfilled(boolean fulfilled);
}

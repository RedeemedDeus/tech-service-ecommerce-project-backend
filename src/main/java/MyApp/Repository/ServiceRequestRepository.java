package MyApp.Repository;

import MyApp.Model.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
}

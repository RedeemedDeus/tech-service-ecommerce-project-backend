package MyApp.Repository;

import MyApp.Model.RequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Long> {
}

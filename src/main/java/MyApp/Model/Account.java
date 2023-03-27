package MyApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Account - the details for each customer
 * Login information: username, password
 * email - might save for extra feature
 * request details - a list of request detail objects representing the customer's list of requests
 */

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    private boolean isEngineer;

    private long secureToken;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="requestFK")
    private ServiceRequest serviceRequest;

}

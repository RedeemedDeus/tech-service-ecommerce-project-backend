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

    @Column
    private String username;

    @Column
    private String password;

    //@Column
    //private String email;

    /**
     * One to Many - Each customer can have multiple requests
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    private List<RequestDetails> requestDetails;
}

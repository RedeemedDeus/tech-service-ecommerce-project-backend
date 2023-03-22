package MyApp.Model;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

//import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String serviceType;

    /*@OneToMany(fetch = FetchType.EAGER)
    //@JsonBackReference
    //private List<RequestDetails> requestDetails;
    private Account customerAccount;*/
}

package MyApp.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column
    private boolean fulfilled = false;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="requestFK")
    private List<RequestDetails> requestDetails;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="requestFK")
    private List<Account> accounts;

}

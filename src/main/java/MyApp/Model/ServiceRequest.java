package MyApp.Model;

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
    @JoinColumn(name="workoutFK")
    private List<RequestDetails> requestDetails;
//    private Account customerAccount;
}

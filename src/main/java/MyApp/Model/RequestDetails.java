package MyApp.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

/**
 * RequestDetail - like a receipt of what a customer requested
 * customerName - who's making the request
 * comment - a message from the customer (optional)
 * hours - how long the service will take
 * totalPrice - the cost of the service maybe depending on time
 * serviceRequest - the type of request the customer chose
 */
@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class RequestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String customerName;

    @Column
    private String serviceType;

    @Column
    private String comment;

    @Column
    private int hours;

    @Column
    private double totalPrice;

    /**
     * Many to One - each account can have multiple requests
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="accountId")
    private Account account;


}

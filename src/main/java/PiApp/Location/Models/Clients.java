package PiApp.Location.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter

@Entity

public class Clients {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "")
        @EqualsAndHashCode.Include
        private Long clientId ;
        @NonNull
        private String Nom;
        @NonNull
        private String Prenom;
        @NonNull
        private Integer Telephone;
        @NonNull
        private String Email;
        @NonNull
        private Integer CIN;
        @NonNull
        private String Login;
        @NonNull
        private String Password;

        @JsonManagedReference(value = "location-clients")
        @OneToMany(mappedBy = "clients", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
        private Set<Locations> locations=new HashSet<>();

//        @ManyToOne
//        @JoinColumn(name ="reservation_code")
//        private Locations reservation;

//        @ManyToMany (cascade=CascadeType.ALL)
//        @JoinTable(name ="client_velos",
//                joinColumns=
//                @JoinColumn(name ="client_code",referencedColumnName = "id"),
//
//                inverseJoinColumns=
//                @JoinColumn(name ="velos_code",referencedColumnName ="code")
//        )
//
//        private Set<Velos> velos=new HashSet<>();
//

    }


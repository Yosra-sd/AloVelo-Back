package PiApp.Location.Models;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Velos {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long veloId ;
        @NonNull
        private Integer Reference;
        @NonNull
        private String Name;
        @NonNull
        private Integer Stock;
        @NonNull
        private String Couleur;
        @NonNull
        private String Taille;
        @NonNull
        private String Type;
        @NonNull
        private String Description;
        @Lob
        private byte[] Photos;
        @NonNull
        private Integer Prix;

//        @ManyToMany(mappedBy = "velos", cascade=CascadeType.ALL)
//        private Set<Clients> clients_velos=new HashSet<>();

    @JsonManagedReference(value = "location-velo")
    @OneToMany(mappedBy = "velos", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<Locations> locations=new HashSet<>();

    public Velos(@NonNull Integer reference, @NonNull String name, @NonNull String couleur, @NonNull String type, @NonNull Integer prix) {
        Reference = reference;
        Name = name;
        Couleur = couleur;
        Type = type;
        Prix = prix;
    }
}


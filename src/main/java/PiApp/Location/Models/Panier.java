package PiApp.Location.Models;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity

public class Panier {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long numc;

        @NonNull
        private Integer prix;
        @Lob
        private byte[] article;

        public Panier(@NonNull Integer prix, byte[] article) {
            this.prix = prix;
            this.article = article;
        }
    }


package PiApp.Location.Models;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Embeddable

public class LocationId implements Serializable {

    @Column(name= "id_velo")
    private Long VeloId;
    @Column(name ="id_client")
    private Long ClientId;


}

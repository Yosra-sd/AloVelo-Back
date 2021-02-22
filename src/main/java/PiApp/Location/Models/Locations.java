package PiApp.Location.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@ToString
public class Locations {


        public enum CommandType{Traitée, EnAttente, Annulé}

        @EmbeddedId
        private LocationId id_location ;
        @NonNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
        private LocalDateTime date_res ;
        @NonNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
        private LocalDateTime date_retour ;
        @NonNull
        private Integer prix ;
        @NonNull
        private String lieu ;
        @NonNull
        private Integer nbre_heures ;

        @Enumerated(EnumType.STRING)
        private CommandType Etat;


        @ManyToOne
        @MapsId("veloId")
        @JoinColumn(name = "id_velo")
        @JsonBackReference(value = "location-velo")
        private Velos velos;

        @MapsId("clientId")
        @ManyToOne
        @JoinColumn(name = "id_client")
        @JsonBackReference(value = "location-clients")
        private Clients clients;

        public LocationId getId_location() {
                return id_location;
        }

        public void setId_location(LocationId id_location) {
                this.id_location = id_location;
        }

        public LocalDateTime getDate_res() {
                return date_res;
        }

        public void setDate_res(LocalDateTime date_res) {
                this.date_res = date_res;
        }

        public LocalDateTime getDate_retour() {
                return date_retour;
        }

        public void setDate_retour(LocalDateTime date_retour) {
                this.date_retour = date_retour;
        }

        public Integer getPrix() {
                return prix;
        }

        public void setPrix(Integer prix) {
                this.prix = prix;
        }

        public String getLieu() {
                return lieu;
        }

        public void setLieu(String lieu) {
                this.lieu = lieu;
        }

        public Integer getNbre_heures() {
                return nbre_heures;
        }

        public void setNbre_heures(Integer nbre_heures) {
                this.nbre_heures = nbre_heures;
        }

        public CommandType getEtat() {
                return Etat;
        }

        public void setEtat(CommandType etat) {
                Etat = etat;
        }

        public Velos getVelos() {
                return velos;
        }

        public void setVelos(Velos velos) {
                this.velos = velos;
        }

        public Clients getClients() {
                return clients;
        }

        public void setClients(Clients clients) {
                this.clients = clients;
        }


//        @OneToMany(mappedBy="reservation", cascade=CascadeType.ALL)
//        private Set<Clients> clients=new HashSet<>();//????


//        public Locations(@NonNull LocalDateTime date_res, @NonNull LocalDateTime date_retour, @NonNull Integer prix, @NonNull String lieu, @NonNull Integer nbre_heures) {
//            this.date_res = date_res;
//            this.date_retour = date_retour;
//            this.prix = prix;
//            this.lieu = lieu;
//            this.nbre_heures = nbre_heures;
//        }
    }


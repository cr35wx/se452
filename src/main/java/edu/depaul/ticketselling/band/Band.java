package edu.depaul.ticketselling.band;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.depaul.ticketselling.backend.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@Entity
@Table(name = "bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bandId;

    @Column(nullable = false, length = 50, unique = true)
    private String bandName;

    @Column(nullable = false, length = 50)
    private String genre;

    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BandMember> members;

    @JsonIgnore
    @OneToOne(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Event event;

    public boolean isSingularArtist() {
        return members.size() == 1;
    }

    @Override
    public String toString() {
        return bandName;
    }
}

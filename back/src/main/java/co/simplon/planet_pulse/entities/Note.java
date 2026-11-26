package co.simplon.planet_pulse.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name= "t_notes")
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idNote;

    // Date générée par PostgreSQL lors de l'insertion
    // Hibernate récupère ensuite la valeur grâce à @Generated
    @Generated(event = EventType.INSERT)
    @Column(name="creation_date", insertable=false, updatable=false )
    private Instant creationDate;
    private String title;
    @Column(name="date_report")
    private LocalDate dateReport;
    private String content;
    @Column(name="id_country")
    private Integer idCountry;

    public Note() {}   // Required for ORM


    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateReport() {
        return dateReport;
    }

    public void setDateReport(LocalDate dateReport) {
        this.dateReport = dateReport;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }
}

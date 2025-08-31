package dev.milca.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicant_name", nullable = false)
    private String applicantName;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "is_attended")
    private Boolean isAttended = false;

    @Column(name = "attended_by")
    private String attendedBy;

    @Column(name = "assistance_date")
    private LocalDateTime assistanceDate;

    @Column(name = "last_edited_date")
    private LocalDateTime lastEditedDate;

    
    @PrePersist
    protected void onCreate() {
        this.requestDate = LocalDateTime.now();
    }
}

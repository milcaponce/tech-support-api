package dev.milca.api.tech_support_api;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String applicantName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;

    @Column(nullable = false)
    private String subject;

    @Column(length = 1000)
    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean isAttended;

    private String attendedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date assistanceDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEditedDate;

    
    public Incident() {
        this.requestDate = new Date();
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }
    public Date getRequestDate() { return requestDate; }
    public void setRequestDate(Date requestDate) { this.requestDate = requestDate; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean getIsAttended() { return isAttended; }
    public void setIsAttended(boolean isAttended) { this.isAttended = isAttended; }
    public String getAttendedBy() { return attendedBy; }
    public void setAttendedBy(String attendedBy) { this.attendedBy = attendedBy; }
    public Date getAssistanceDate() { return assistanceDate; }
    public void setAssistanceDate(Date assistanceDate) { this.assistanceDate = assistanceDate; }
    public Date getLastEditedDate() { return lastEditedDate; }
    public void setLastEditedDate(Date lastEditedDate) { this.lastEditedDate = lastEditedDate; }
}

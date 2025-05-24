package app.nanaBank.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 * @author Jonathan
 */
@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    @Column(updatable = false)
    private String createdBy;
    
    
    @Column(insertable = false)
    private LocalDateTime updatedAt;
    
    @Column(insertable = false)
    private String updatedBy;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;

/**
 *
 * @author oracle
 */
@Entity
public class IqjbLog extends IqjbEntity implements Serializable {

    private String message;
    private LocalDateTime instant;

    public IqjbLog() {
    }

    public IqjbLog(String message, LocalDateTime instant) {
        this.message = message;
        this.instant = instant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public void setInstant(LocalDateTime instant) {
        this.instant = instant;
    }

    @Override
    public String toString() {
        return "IqjbLog{" + "message=" + message + ", instant=" + instant + '}';
    }
    
    
}

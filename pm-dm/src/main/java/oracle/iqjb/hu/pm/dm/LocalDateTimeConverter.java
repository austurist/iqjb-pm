/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author oracle
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locdate) {
        return (locdate == null ? null : Timestamp.valueOf(locdate));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
    	return (dbData == null ? null : dbData.toLocalDateTime());
    }

    
}

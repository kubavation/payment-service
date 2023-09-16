package com.durys.jakub.paymentservice.api;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

class XmlConversionUtils {

    public static LocalDate to(XMLGregorianCalendar calendar) {
        return LocalDate.of(calendar.getYear(), calendar.getMonth(), calendar.getDay());
    }
}

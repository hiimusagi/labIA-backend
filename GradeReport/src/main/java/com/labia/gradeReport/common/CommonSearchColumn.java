package com.labia.gradeReport.common;
import org.hibernate.query.NativeQuery;
public class CommonSearchColumn {
    public void setParameterInteger(NativeQuery<?> query, String parameter, Integer value) {
        if (value != null) {
            query.setParameter(parameter, value);
        }
    }
}

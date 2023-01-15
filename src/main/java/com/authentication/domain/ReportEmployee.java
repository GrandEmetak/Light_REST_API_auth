package com.authentication.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 *
 */
@Data
public class ReportEmployee {

    private int id;

    private String name;

    private Timestamp created;

    private Employee employee;

    /**
     * r.created = new Timestamp(System.currentTimeMillis());
     * т.е. при каждом запросе на формирование отчета у нас будет генерироваться новый отчет
     * с новой датой.
     *
     * @param id
     * @param name
     * @param employee
     * @return
     */
    public static ReportEmployee of(int id, String name, Employee employee) {
        ReportEmployee r = new ReportEmployee();
        r.id = id;
        r.name = name;
        r.employee = employee;
        r.created = new Timestamp(System.currentTimeMillis());
        return r;
    }
}

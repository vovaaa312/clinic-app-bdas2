package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.views.Employee;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("ID_ZAMESTNANEC"));
        employee.setJmeno(rs.getString("JMENO"));
        employee.setPrijmeni(rs.getString("PRIJMENI"));
        employee.setDatumNarozeni(rs.getDate("DATUM_NAROZENI"));
        employee.setCisloTelefonu(rs.getInt("CISLO_TELEFONU"));
        employee.setPracovniZkusenosti(rs.getInt("PRACOVNI_ZKUSENOSTI"));
        employee.setIdAdresa(rs.getInt("ID_ADRESA"));
        employee.setPsc(rs.getInt("PSC"));
        employee.setAdresa(rs.getString("ADRESA"));
        employee.setMesto(rs.getString("MESTO"));
        employee.setZeme(rs.getString("ZEME"));
        return employee;
    }
}


package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.views.Employee;
import com.clinicappbdas2.model.views.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() {
        String sql = "SELECT Z.ID_ZAMESTNANEC, Z.JMENO, Z.PRIJMENI, Z.DATUM_NAROZENI, Z.CISLO_TELEFONU, Z.PRACOVNI_ZKUSENOSTI, " +
                "A.ID_ADRESA, A.PSC, A.ADRESA, A.MESTO, A.ZEME " +
                "FROM ZAMESTNANCI Z JOIN ADRESY A ON Z.ID_ADRESA = A.ID_ADRESA";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    public void createEmployee(Employee employee) {
        String sqlInsertAddress = "INSERT INTO ADRESY (ID_ADRESA, PSC, ADRESA, MESTO, ZEME) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsertAddress, employee.getIdAdresa(), employee.getPsc(), employee.getAdresa(), employee.getMesto(), employee.getZeme());

        String sqlInsertEmployee = "INSERT INTO ZAMESTNANCI (ID_ZAMESTNANEC, JMENO, PRIJMENI, DATUM_NAROZENI, CISLO_TELEFONU, PRACOVNI_ZKUSENOSTI, ID_ADRESA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsertEmployee, employee.getId(), employee.getJmeno(), employee.getPrijmeni(), employee.getDatumNarozeni(),
                employee.getCisloTelefonu(), employee.getPracovniZkusenosti(), employee.getIdAdresa());
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT Z.ID_ZAMESTNANEC, Z.JMENO, Z.PRIJMENI, Z.DATUM_NAROZENI, Z.CISLO_TELEFONU, Z.PRACOVNI_ZKUSENOSTI, " +
                "A.ID_ADRESA, A.PSC, A.ADRESA, A.MESTO, A.ZEME " +
                "FROM ZAMESTNANCI Z JOIN ADRESY A ON Z.ID_ADRESA = A.ID_ADRESA " +
                "WHERE Z.ID_ZAMESTNANEC = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeMapper());
    }

    public void updateEmployee(Employee employee) {
        String sqlUpdateEmployee = "UPDATE ZAMESTNANCI SET JMENO = ?, PRIJMENI = ?, DATUM_NAROZENI = ?, " +
                "CISLO_TELEFONU = ?, PRACOVNI_ZKUSENOSTI = ? WHERE ID_ZAMESTNANEC = ?";
        jdbcTemplate.update(sqlUpdateEmployee, employee.getJmeno(), employee.getPrijmeni(), employee.getDatumNarozeni(),
                employee.getCisloTelefonu(), employee.getPracovniZkusenosti(), employee.getId());

        String sqlUpdateAddress = "UPDATE ADRESY SET PSC = ?, ADRESA = ?, MESTO = ?, ZEME = ? WHERE ID_ADRESA = ?";
        jdbcTemplate.update(sqlUpdateAddress, employee.getPsc(), employee.getAdresa(), employee.getMesto(), employee.getZeme(), employee.getIdAdresa());
    }

    public void deleteEmployee(int id) {
        String sqlDelete = "DELETE FROM ZAMESTNANCI WHERE ID_ZAMESTNANEC = ?";
        jdbcTemplate.update(sqlDelete, id);
    }
}


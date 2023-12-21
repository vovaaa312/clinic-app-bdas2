package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.mapper.NavstevaPacientaMapper;
import com.clinicappbdas2.model.views.NavstevaPacienta;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class NavstevyPacientuRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<NavstevaPacienta> getAll(){
        String sql = "SELECT * FROM NAVSTEVY_PACIENTU_VIEW";
        return jdbcTemplate.query(sql, new NavstevaPacientaMapper());
    }

    public NavstevaPacienta getByNavstevaId(Long id) {
        String sql = "SELECT * FROM NAVSTEVY_PACIENTU_VIEW WHERE ID_NAVSTEVA = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new NavstevaPacientaMapper());
    }

    public List<NavstevaPacienta>getAllByPacientId(Long id){
        String sql = "SELECT * FROM NAVSTEVY_PACIENTU_VIEW WHERE ID_PACIENT = ?";
        return jdbcTemplate.query(sql,new Object[]{id}, new NavstevaPacientaMapper());
    }

    public List<NavstevaPacienta>getAllByZamestnanecId(Long id){
        String sql = "SELECT * FROM NAVSTEVY_PACIENTU_VIEW WHERE ID_ZAMESTNANEC = ?";
        return jdbcTemplate.query(sql,new Object[]{id}, new NavstevaPacientaMapper());
    }
    public List<NavstevaPacienta>getAllByOddeleniId(Long id){
        String sql = "SELECT * FROM NAVSTEVY_PACIENTU_VIEW WHERE ID_ODDELENI = ?";
        return jdbcTemplate.query(sql,new Object[]{id}, new NavstevaPacientaMapper());
    }

    public void createNavsteva(NavstevaPacienta navsteva){
        String sql = "CALL VLOZ_NAVSTEVU(?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                navsteva.getDatum(),
                navsteva.getIdPacient(),
                navsteva.getIdZamestnanec(),
                navsteva.getProblem(),
                navsteva.getRekomendace(),
                navsteva.getIdStatus()
        );
    }

    public void updateNavsteva(NavstevaPacienta navsteva){
        String sql = "UPDATE_NAVSTEVU(?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                navsteva.getDatum(),
                navsteva.getIdPacient(),
                navsteva.getIdZamestnanec(),
                navsteva.getProblem(),
                navsteva.getRekomendace(),
                navsteva.getIdStatus()

        );
    }


    public void deleteById(Long id) {
        String sql = "CALL ODEBER_NAVSTEVU(?)";
        jdbcTemplate.update(sql,id);
    }
}
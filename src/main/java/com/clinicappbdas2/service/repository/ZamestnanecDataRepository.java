package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.views.ZamestnanecData;
import com.clinicappbdas2.model.mapper.ZamestnanecDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ZamestnanecDataRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<ZamestnanecData> getAllZamestnanci() {
        String sql = "SELECT * FROM ZAMESTNANCI_VIEW";
        return jdbcTemplate.query(sql, new ZamestnanecDataMapper());
    }

    public void createZamestnanec(ZamestnanecData zamestnanecData) {
        String sql = "CALL VLOZ_ZAMESTNANCE(?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                zamestnanecData.getJmeno(),
                zamestnanecData.getPrijmeni(),
                zamestnanecData.getDatumNarozeni(),
                zamestnanecData.getCisloTelefonu(),
                zamestnanecData.getPracovniZkusenosti(),
                zamestnanecData.getNazevOddeleni(),
                zamestnanecData.getZeme(),
                zamestnanecData.getMesto(),
                zamestnanecData.getAdresa(),
                zamestnanecData.getPsc());
    }

    public ZamestnanecData getZamestnanecById(Integer id) {
        String sql = "SELECT * FROM ZAMESTNANCI_VIEW WHERE ID_ZAMESTNANEC = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new ZamestnanecDataMapper()
        );
    }

    public void updateZamestnanec(ZamestnanecData zamestnanecData) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("UPDATE_ZAMESTNANEC_DATA");

        MapSqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_zamestnanec", zamestnanecData.getIdZamestnanec())
                .addValue("p_jmeno", zamestnanecData.getJmeno())
                .addValue("p_prijmeni", zamestnanecData.getPrijmeni())
                .addValue("p_datum_narozeni", zamestnanecData.getDatumNarozeni())
                .addValue("p_cislo_telefonu", zamestnanecData.getCisloTelefonu())
                .addValue("p_pracovni_zkusenosti", zamestnanecData.getPracovniZkusenosti())

                .addValue("p_id_adresa", zamestnanecData.getIdAdresa())
                .addValue("p_zeme", zamestnanecData.getZeme())
                .addValue("p_mesto", zamestnanecData.getMesto())
                .addValue("p_adresa", zamestnanecData.getAdresa())
                .addValue("p_psc", zamestnanecData.getPsc())

                .addValue("p_id_oddeleni", zamestnanecData.getIdOddeleni());

        simpleJdbcCall.execute(in);
    }

    public void deleteZamestnanec(Integer id){
        String sql = "DELETE FROM ZAMESTNANCI WHERE ID_ZAMESTNANEC = ?";
        jdbcTemplate.update(sql, id);
    }
}

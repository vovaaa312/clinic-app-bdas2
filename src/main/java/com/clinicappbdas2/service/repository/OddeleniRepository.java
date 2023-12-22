package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.Oddeleni;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OddeleniRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(Oddeleni oddeleni) {
        String sql = "INSERT INTO ST64550.ODDELENI " +
                "(  NAZEV_ODDELENI) " +
                "VALUES (  ?)";
        jdbcTemplate.update(sql, oddeleni.getNazevOddeleni());
    }

    public List<Oddeleni> getAll() {
        return jdbcTemplate.query("SELECT * from ODDELENI",
                BeanPropertyRowMapper.newInstance(Oddeleni.class));
    }

    public Integer getIdByNazev(String nazev) {
        Oddeleni odd =  jdbcTemplate.queryForObject("SELECT ID_ODDELENI FROM ODDELENI WHERE NAZEV_ODDELENI =?",
                BeanPropertyRowMapper.newInstance(Oddeleni.class), nazev);
        return odd.getIdOddeleni();
    }

//    public Double calculateAverageStayDuration(Integer oddeleniId) {
//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withProcedureName("calculate_average_stay_duration")
//                .declareParameters(
//                        new SqlParameter("p_oddeleni_id", Types.INTEGER),
//                        new SqlOutParameter("p_average_duration", Types.NUMERIC)
//                );
//
//        Map<String, Object> inParams = new HashMap<>();
//        inParams.put("p_oddeleni_id", oddeleniId);
//
//        Map<String, Object> result = jdbcCall.execute(inParams);
//
//        if (result != null && result.containsKey("p_average_duration")) {
//            return (Double) result.get("p_average_duration");
//        } else {
//            throw new RuntimeException("Failed to calculate average stay duration");
//        }
//    }

//    public Integer calculateAverageStayDuration(Integer oddeleniId) {
//        String procedureCall = "{call calculate_average_stay_duration(?, ?)}";
//        Map<String, Object> inParams = new HashMap<>();
//        inParams.put("p_oddeleni_id", oddeleniId);
//
//        // Зарегистрируйте выходной параметр как Types.NUMERIC
//        jdbcTemplate.execute(procedureCall, (CallableStatementCallback<Object>) cs -> {
//            cs.setInt(1, oddeleniId);
//            cs.registerOutParameter(2, Types.NUMERIC);
//            cs.execute();
//            return cs.getDouble(2); // Получаем значение из выходного параметра
//        });
//
//
//        // Получите значение из выходного параметра
//        Double result = (Double) inParams.get("p_average_duration");
//
//        if (result != null) {
//            // Преобразуйте Double в Integer
//            return result.intValue();
//        } else {
//            throw new RuntimeException("Failed to calculate average stay duration");
//        }
//    }








}

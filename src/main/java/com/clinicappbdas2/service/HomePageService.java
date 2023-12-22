package com.clinicappbdas2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;

@Service
@RequiredArgsConstructor
public class HomePageService {
    private final JdbcTemplate jdbcTemplate;
    public Number calculateAverageAge(
            java.sql.Date asOfDate,
            Integer ageGroupMin,
            Integer ageGroupMax,
            String gender
    ) {
        // Вызовите процедуру и верните значение
        String sql = "{ ? = call vypocitat_prumerny_vek_pacientu(?, ?, ?, ?) }";
        return jdbcTemplate.execute(
                sql,
                (CallableStatementCallback<Number>) cs -> {
                    cs.registerOutParameter(1, Types.NUMERIC);
                    cs.setDate(2, asOfDate);
                    cs.setInt(3, ageGroupMin != null ? ageGroupMin : 0);
                    cs.setInt(4, ageGroupMax != null ? ageGroupMax : 100);
                    cs.setString(5, gender);
                    cs.execute();
                    return cs.getInt(1); // Может потребоваться изменить, в зависимости от типа возвращаемого значения
                }
        );
    }

}

package biz.gsign.dataMapper;

import biz.gsign.dto.Employer;
import com.miragesql.miragesql.SqlManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static biz.gsign.sqlUtil.SqlUtil.sql;

@RequiredArgsConstructor
@Repository
public class EmployerDataMapper {
    private final SqlManager sqlManager;
    private final SequenceDataMapper sequenceDataMapper;

    public long check(String username, String password) {
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);
        Employer employer = sqlManager.getSingleResult(Employer.class, sql("sql/emp_get.sql"), param);
        if(employer!=null)
             return 1;
        else {
            return 0;
        }
    }

    public Long create(String username, String password) {
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);

        sqlManager.executeUpdate(sql("sql/emp_create.sql"), param);
        return sequenceDataMapper.getCurrentValue("employer");
    }

}

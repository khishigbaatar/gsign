package biz.gsign.dataMapper;

import com.miragesql.miragesql.SqlManager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static biz.gsign.sqlUtil.SqlUtil.sql;

@Repository
public class SequenceDataMapper {
    private final SqlManager sqlManager;

    public SequenceDataMapper(SqlManager sqlManager) {
        this.sqlManager = sqlManager;
    }

    public long getCurrentValue(String tableName) {
        Map<String, Object> param = new HashMap<>();
        param.put("sequenceName", tableName + "_id_seq");
        return sqlManager.getSingleResult(Long.class, sql("sql/sequence_getCurrentValue.sql"), param);
    }

    public long getNextValue(String sequenceName) {
        Map<String, Object> param = new HashMap<>();
        param.put("sequenceName", sequenceName);
        return sqlManager.getSingleResult(Long.class, sql("sql/sequence_getNextValue.sql"), param);
    }

}

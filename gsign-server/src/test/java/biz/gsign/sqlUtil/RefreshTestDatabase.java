package biz.gsign.sqlUtil;

import com.miragesql.miragesql.SqlManager;
import com.miragesql.miragesql.StringSqlResource;

public class RefreshTestDatabase {

    public static void truncateAllTablesFromDB(SqlManager sqlManager) {
        sqlManager.executeUpdate(new StringSqlResource("TRUNCATE TABLE employer CASCADE"));
        sqlManager.executeUpdate(new StringSqlResource("TRUNCATE TABLE emp_performance CASCADE"));
    }
}

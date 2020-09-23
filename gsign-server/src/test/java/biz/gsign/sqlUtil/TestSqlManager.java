package biz.gsign.sqlUtil;

import com.miragesql.miragesql.SqlManager;
import com.miragesql.miragesql.SqlManagerImpl;
import com.miragesql.miragesql.dialect.PostgreSQLDialect;
import com.miragesql.miragesql.provider.DataSourceConnectionProvider;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

public class TestSqlManager {

    private static SqlManager sqlManager;

    public static SqlManager setUp() {
        if (sqlManager != null) return sqlManager;

        String testDbUrl = "jdbc:postgresql://localhost/empdb";
        System.out.println("testDbUrl = " + testDbUrl);
        String workerName = "1";
        System.out.println(workerName);
        if("1".equals(workerName) || workerName == null){
            workerName = "";
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(testDbUrl + workerName);
        dataSource.setUsername("pivotal");

        Properties properties = new Properties();
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "utf8");
        dataSource.setConnectionProperties(properties);

        DataSourceConnectionProvider connectionProvider = new DataSourceConnectionProvider();
        connectionProvider.setDataSource(dataSource);
        sqlManager = new SqlManagerImpl();
        sqlManager.setConnectionProvider(connectionProvider);
        sqlManager.setDialect(new PostgreSQLDialect());

        return sqlManager;
    }

}

package biz.gsign.config;

import com.miragesql.miragesql.SqlManager;
import com.miragesql.miragesql.SqlManagerImpl;
import com.miragesql.miragesql.dialect.PostgreSQLDialect;
import com.miragesql.miragesql.integration.spring.SpringConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class SqlManagerConfig {

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Bean
    public SqlManager sqlManager() {
        SqlManager sqlManager = new SqlManagerImpl();
        SpringConnectionProvider connectionProvider = new SpringConnectionProvider();
        connectionProvider.setTransactionManager(transactionManager);
        sqlManager.setConnectionProvider(connectionProvider);
        sqlManager.setDialect(new PostgreSQLDialect());
        return sqlManager;
    }

}

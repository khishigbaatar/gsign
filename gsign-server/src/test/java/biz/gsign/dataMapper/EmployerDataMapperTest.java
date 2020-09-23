package biz.gsign.dataMapper;
import biz.gsign.dto.Employer;
import biz.gsign.fixture.EmployerFixture;
import biz.gsign.sqlUtil.TestSqlManager;
import com.miragesql.miragesql.SqlManager;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static biz.gsign.sqlUtil.RefreshTestDatabase.truncateAllTablesFromDB;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class EmployerDataMapperTest {
    private static SqlManager sqlManager;
    private EmployerDataMapper employerDataMapper;

    @Mock
    private SequenceDataMapper sequenceDataMapper;

    @BeforeClass
    public static void setUpOnce() {
        sqlManager = TestSqlManager.setUp();
    }

    @Before
    public void setUp() throws Exception {
        employerDataMapper = new EmployerDataMapper(sqlManager, sequenceDataMapper);
        truncateAllTablesFromDB(sqlManager);
    }

    @Test
    public void test_getAll_returnList() {
        sqlManager.insertBatch(EmployerFixture.defaultDatabaseBuilder().build());

        Employer expected = EmployerFixture.defaultViewBuilder().build();

        List<Employer> result = employerDataMapper.getAll();

        MatcherAssert.assertThat(result.size(), equalTo(1));
        assertThat(result.get(0).getEmpCode(), equalTo(expected.getEmpCode()));
        assertThat(result.get(0).getFirstName(), equalTo(expected.getFirstName()));
        assertThat(result.get(0).getLastName(), equalTo(expected.getLastName()));

    }

    @Test
    public void test_get_returnEmployer() {
        sqlManager.insertBatch(EmployerFixture.defaultDatabaseBuilder().build());

        Employer expected = EmployerFixture.defaultViewBuilder().build();

        Employer result = employerDataMapper.get("100");

        assertThat(result.getEmpCode(), equalTo(expected.getEmpCode()));

    }

    @Test
    public void test_create() {
        Employer employer = EmployerFixture.defaultViewBuilder().build();

        Employer expected = EmployerFixture.defaultViewBuilder().build();

        employerDataMapper.create(employer);

        Employer result = employerDataMapper.get("100");

        assertThat(result.getEmpCode(), equalTo(expected.getEmpCode()));

    }

    @Test
    public void test_update() {
        sqlManager.insertBatch(EmployerFixture.defaultDatabaseBuilder().build());

        Employer employer = EmployerFixture.defaultViewBuilder().build();

        Employer expected = EmployerFixture.defaultViewBuilder().build();

        employerDataMapper.update(employer);

        Employer result = employerDataMapper.get("100");

        assertThat(result.getEmpCode(), equalTo(expected.getEmpCode()));

    }

    @Test
    public void test_delete() {
        sqlManager.insertBatch(EmployerFixture.defaultDatabaseBuilder().build());

        Employer employer = EmployerFixture.defaultViewBuilder().build();

        Employer expected = EmployerFixture.defaultViewBuilder().build();

        employerDataMapper.delete("100");

        Employer result = employerDataMapper.get("100");

        assertThat(result, equalTo(null));

    }

}

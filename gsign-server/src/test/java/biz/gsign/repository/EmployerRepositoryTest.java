package biz.gsign.repository;

import biz.gsign.dataMapper.EmployerDataMapper;
import biz.gsign.dto.Employer;
import biz.gsign.fixture.EmployerFixture;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.TimeZone;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployerRepositoryTest {
    private EmployerRepository employerRepository;

    @Mock
    private EmployerDataMapper employerDataMapper;

    @Before
    public void setUp() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        employerRepository = new EmployerRepository( employerDataMapper);

    }

    @Test
    public void test_get_callsDependencies() {

        List<Employer> employers = asList(EmployerFixture.defaultViewBuilder().build());
        when(employerDataMapper.getAll()).thenReturn(employers);

        employerRepository.getAll();

        verify(employerDataMapper, times(1)).getAll();
    }

    @Test
    public void test_get_returnListEmployer() {
        List<Employer> employers = asList(EmployerFixture.defaultViewBuilder().build());

        when(employerDataMapper.getAll()).thenReturn(employers);

        List<Employer> result = employerRepository.getAll();

        assertThat(employers, CoreMatchers.equalTo(result));
    }

}
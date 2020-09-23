package biz.gsign.repository;

import biz.gsign.dataMapper.EmployerDataMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployerRepository {
    private final EmployerDataMapper employerDataMapper;

    public EmployerRepository(EmployerDataMapper employerDataMapper)
    {
        this.employerDataMapper = employerDataMapper;
    }

    public Long check(String username, String password) {

        return employerDataMapper.check(username, password);
    }

    public Long create(String username, String password) {

        return employerDataMapper.create(username, password);
    }

}

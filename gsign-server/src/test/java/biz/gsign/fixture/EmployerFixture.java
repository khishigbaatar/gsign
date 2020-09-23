package biz.gsign.fixture;

import biz.gsign.dto.Employer;
import biz.gsign.entity.DatabaseEmployerRecord;

public class EmployerFixture {
    public static Employer.EmployerBuilder defaultViewBuilder() {
        return Employer.builder()
                .id(1L)
                .empCode("100")
                .firstName("Khishig")
                .lastName("Sosor")
                ;
    }

    public static Employer.EmployerBuilder secondViewBuilder() {
        return Employer.builder()
                .id(2L)
                .empCode("200")
                .firstName("John")
                .lastName("Smith")
                ;
    }

    public static Employer.EmployerBuilder thirdViewBuilder() {
        return Employer.builder()
                .id(3L)
                .empCode("300")
                .firstName("Kate")
                .lastName("Lisa")
                ;
    }

    public static DatabaseEmployerRecord.DatabaseEmployerRecordBuilder defaultDatabaseBuilder() {
        return DatabaseEmployerRecord.builder()
                .id(1L)
                .empCode("100")
                .firstName("Khishig")
                .lastName("Sosor")
                ;
    }

    public static DatabaseEmployerRecord.DatabaseEmployerRecordBuilder secondDatabaseBuilder() {
        return DatabaseEmployerRecord.builder()
                .id(2L)
                .empCode("200")
                .firstName("John")
                .lastName("Smith")
                ;
    }

    public static DatabaseEmployerRecord.DatabaseEmployerRecordBuilder thirdDatabaseBuilder() {
        return DatabaseEmployerRecord.builder()
                .id(3L)
                .empCode("300")
                .firstName("Kate")
                .lastName("Lisa")
                ;
    }
}

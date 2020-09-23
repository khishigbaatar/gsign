-- Project Name : Pay pay challenge
-- Date/Time    : 2020/09/06 9:19:38
-- Author       : Khishigbaatar Sosorbaram
-- RDBMS Type   : PostgreSQL

drop table if exists employer cascade;
create table employer (
                         id bigserial not null
    , emp_code text not null
    , first_name text not null
    , last_name text not null
) ;

create unique index employer_ix1
    on employer(emp_code);

create unique index employer_pki
    on employer(id);

drop table if exists emp_performance cascade;
create table emp_performance (
                          id bigserial not null
    , emp_code text not null
    , performance text not null
    , reviewedBy text not null
) ;

create unique index emp_performance_pki
    on emp_performance(id);

-- Project Name : Pay pay challenge
-- Date/Time    : 2020/09/06 9:19:38
-- Author       : Khishigbaatar Sosorbaram
-- RDBMS Type   : PostgreSQL

drop table if exists employer cascade;
create table employer (
                         id bigserial not null
    , username text not null
    , password text not null

) ;

create unique index employer_pki
    on employer(id);


drop table if exists spring_session cascade;
create table spring_session
(
	session_id char(36) not null
		constraint spring_session_pk
			primary key,
	creation_time bigint not null,
	last_access_time bigint not null,
	max_inactive_interval integer not null,
	principal_name varchar(100)
) ;

create index spring_session_ix1
	on spring_session (last_access_time) ;

drop table if exists spring_session_attributes cascade;
create table spring_session_attributes
(
	session_id char(36) not null
		constraint spring_session_attributes_fk
			references spring_session
				on delete cascade,
	attribute_name varchar(200) not null,
	attribute_bytes bytea,
	constraint spring_session_attributes_pk
		primary key (session_id, attribute_name)
) ;

create index spring_session_attributes_ix1
	on spring_session_attributes (session_id) ;

#!/bin/sh

PGOPTIONS='--client-min-messages=warning' psql -U pivotal -d $1 -f ../gsign-server/src/main/resources/db/create_table_spring_session.sql 1>/dev/null
PGOPTIONS='--client-min-messages=warning' psql -U pivotal -d $1 -f ../gsign-server/src/main/resources/db/create_table_common.sql 1>/dev/null



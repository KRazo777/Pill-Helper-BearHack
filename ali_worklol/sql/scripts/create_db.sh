#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
#cs166_createdb $USER"bearhack_DB"
cs166_psql -p $PGPORT $USER"bearhack_DB" < $DIR/../src/create_tablesBH.sql
cs166_psql -p $PGPORT $USER"bearhack_DB" < $DIR/../src/load_dataBH.sql


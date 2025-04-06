#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
#cs166_createdb $USER"bearhack_DB"
#psql -p $PGPORT $USER"bearhack_DB" < $DIR/../src/create_tablesBH.sql
#psql -p $PGPORT $USER"bearhack_DB" < $DIR/../src/load_dataBH.sql
psql -p $PGPORT $USER"bearhack_DB" < $DIR/../src/queries.sql


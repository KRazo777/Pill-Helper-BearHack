#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

SRC_DIR="$DIR/../src"
CLASS_DIR="$DIR/../classes"
LIB_DIR="$DIR/../lib"

javac -cp "$LIB_DIR/jSerialComm.jar:$LIB_DIR/pg73jdbc3.jar" -d "$CLASS_DIR" "$SRC_DIR"/*.java


java -cp "$CLASS_DIR:$LIB_DIR/jSerialComm.jar:$LIB_DIR/pg73jdbc3.jar" SerialConnector $USER"bearhack_DB" $PGPORT $USER

#!/bin/bash

bash child.sh $1 & > /dev/null

pid=$!

echo "waiting process $pid"

sleep $2

wait $pid

echo "Código de retorno do processo filho ($pid):" $?

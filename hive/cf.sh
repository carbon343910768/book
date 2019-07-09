#!/bin/bash

mysql -uroot --local-infile=0 -f cf.sql

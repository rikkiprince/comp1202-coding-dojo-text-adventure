#!/bin/bash

filename=$1;

if [ ! -e $filename ] || [ -z $filename ];
then
	echo "foo";
	exit;
fi

awk '{ FS="\t"; print "Room "$1" = new Room('"'"'"$2"'"'"', '"'"'"$3"'"'"');" }' $filename

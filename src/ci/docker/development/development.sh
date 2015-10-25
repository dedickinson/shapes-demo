#!/usr/bin/env bash

docker-machine create --driver=virtualbox development
docker-machine start development
docker-machine env

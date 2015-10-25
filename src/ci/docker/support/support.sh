#!/usr/bin/env bash

docker-machine create --driver=virtualbox support
docker-machine start support
docker-machine env

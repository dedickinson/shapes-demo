#!/usr/bin/env bash

docker run -d -p 5000:5000 --restart=always -v `pwd`/data:/var/lib/registry --name registry registry:2

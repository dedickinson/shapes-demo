# General work notes

## Work items:

1. Create a `ci` folder in `src/` with the following subdirs:
    * `docker` to house dockerfiles
    * `jobs` to house the Jenkins DSL files
2. Setup a custom `Dockerfile` in `src/ci/docker/jenkins` to prepare a suitable Jenkins container
3.

## Prerequisites

1. Download and install the Docker suite - I use [Docker Toolbox](http://www.docker.com/docker-toolbox).
    1. Start the docker host, probably using Kitematic or `docker-machine start default`

## Setting up Jenkins

See: `src/ci/docker/jenkins/Dockerfile`

To build:

    docker build -t shapes-demo-jenkins .

To run:

    docker run -p 8080:8080 -p 50000:50000 shapes-demo-jenkins

Notes:

* You'll need to access the port (`8080`) via the docker machine's IP address (e.g. `http://192.168.99.100:8080/`) - the `docker-machine ip default` will give you this.
* Port `50000` is used by Jenkins for slave agents.
* You can also change the info in the VM via the VirtualBox UI but that tends to be blown away every now and then so I'd suggest using the actual IP of the container.




    wget http://localhost:8080/jnlpJars/jenkins-cli.jar
    cat SeedJob.xml|java -jar jenkins-cli.jar -s http://localhost:8080/ create-job SeedJob
    java -jar jenkins-cli.jar -s http://localhost:8080/ build -s SeedJob

# General work notes

## Work items:

1. Create a `ci` folder in `src/` with the following subdirs:
    * `docker` to house dockerfiles
    * `jobs` to house the Jenkins DSL files
2. Setup a custom `Dockerfile` in `src/ci/docker/jenkins` to prepare a suitable Jenkins container
3.

## Prerequisites

Download and install the Docker suite - I use [Docker Toolbox](http://www.docker.com/docker-toolbox) and this is a good starter as it also contains VirtualBox.

Using `docker-machine` we'll create a new docker host named `development` and setup the terminal to use it. See the `src/ci/docker/development.sh` script.

## Docker and the Gradle build

Once you have the `development` host running you can now start a terminal from which to run Gradle.

First up, establish your environment with:

    eval "$(docker-machine env development)"

You can now use the Docker-based task in `build.gradle`:

    ./gradlew dockerBuildImage

This will use the `development` host to build the image. Inside the `development` host you can now run:

    docker run --rm groovytutorial/shapes-demo:1.0-SNAPSHOT

## Setup the supporting infrastructure

This work may not be something you do per-project as it'll be useful across a number of projects. We'll create a container environment that hosts the following items:

* [Docker Registry v2](https://docs.docker.com/registry/)
* [Apache Archiva](https://archiva.apache.org/index.cgi)
* [Jenkins](http://jenkins-ci.org/)

See the `src/ci/docker/support/support.sh` script.

## Setting up Jenkins

See: `src/ci/docker/jenkins/Dockerfile`

To build the Jenkins image:

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

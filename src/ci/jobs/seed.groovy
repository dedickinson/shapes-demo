job('seed') {
    scm {
        github 'https://github.com/dedickinson/shapes-demo.git'
    }
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        dsl {
            external 'src/ci/jobs/*-job.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }
}

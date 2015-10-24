job('seed') {
    scm {
        github 'https://github.com/dedickinson/shapes-demo.git'
    }
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        //gradle 'clean test'
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }
    publishers {
        //archiveJunit 'build/test-results/**/*.xml'
    }
}

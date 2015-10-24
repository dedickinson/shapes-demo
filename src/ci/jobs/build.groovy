def repo = 'https://github.com/dedickinson/shapes-demo.git'

job('build') {
    description('Performs a per check-in build')
    scm {
        git {
            remote {
                url(repo)
            }
            branches('master')
            createTag(false)
        }
    }
    triggers {
        scm('H/15 * * * *')
    }
    steps {
        shell('./gradlew clean test')
    }
}

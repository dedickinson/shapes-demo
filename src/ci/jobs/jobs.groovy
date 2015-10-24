def repo = 'https://github.com/dedickinson/shapes-demo.git'

job('CI Build') {
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

/*
job('Check') {
  description('Runs code-checking tools')
  triggers {
        upstream('CI Build', 'SUCCESS')
    }
  steps {
        shell('./gradlew check')
    }
}

job('Documentation') {
  description('Runs code documentation tools')
  triggers {
        upstream('CI Build', 'SUCCESS')
    }
  steps {
        shell('./gradlew groovydoc')
    }
}
*/

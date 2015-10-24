job('Check') {
    description('Runs code-checking tools')
    triggers {
        upstream('build', 'SUCCESS')
    }
    steps {
        shell('./gradlew check')
    }
}

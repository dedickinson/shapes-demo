job('doc') {
    description('Runs code documentation tools')
    triggers {
        upstream('build', 'SUCCESS')
    }
    steps {
        shell('./gradlew groovydoc')
    }
}

node {
    stage("BUILD THC") {
        try {
            sh "ls"
            sh "./gradlew clean build -x test"
            } catch (e) {
               error "Service update failed"
        }
    }
}
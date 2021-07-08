node {
    stage("BUILD THC") {
        try {
            sh "cd THC"
            sh "./gradlew clean build -x test"
            } catch (e) {
               error "Service update failed"
        }
    }
}
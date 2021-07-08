node {
    stage("BUILD THC") {
        try {
            sh "cd thc; gradle clean build -x test"
            } catch (e) {
               error "Service update failed"
        }
    }
}
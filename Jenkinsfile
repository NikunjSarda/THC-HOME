node {
    stage("BUILD THC") {
        try {
            sh "cd THC; gradle clean build -x test"
            } catch (e) {
               error "Service update failed"
        }
    }
}
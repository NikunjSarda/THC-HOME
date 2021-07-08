node {
    stage("BUILD THC") {
        try {
            sh "gradle clean build -x test"
            } catch (e) {
               error "Service update failed"
        }
    }
}
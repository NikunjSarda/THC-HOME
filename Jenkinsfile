node {
    stage("BUILD THC") {
        try {
            sh "ls && exit 1"
            sh "gradle clean build -x test"
            } catch (e) {
               error "Service update failed"
        }
    }
}
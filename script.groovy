def buildJar() {
    echo "Building"
    sh "mvn package"
}

def buildImage() {
    echo "Build docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {     
        sh 'docker build -t horikz/java-maven-app:jma-2.0 .'   
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push horikz/java-maven-app:jma-2.0'
    }
}

def deployApp() {
    echo "Deploying the app"
}

return this

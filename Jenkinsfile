pipeline {
    agent any
    tools {
        maven 'my-maven'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "Build"
                    sh 'mvn package'

                }
            }
        }
        
        stage("build image") {
            steps {
                script {
                    echo "Build docker image"
                      withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {     
                      sh 'docker build -t horikz/java-maven-app:jma-2.0 .'   
                      sh "echo $PASS | docker login -u $USER --password-stdin"
                      sh 'docker push horikz/java-maven-app:jma-2.0'
                      }
                }
            }
        }
    }
}
pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo "building"
        bat " mvn clean"
        bat "mvn test"
        sleep 10
      }
    }
    stage('Test') {
      steps {
        echo "testing"
        mvn 
        sleep 30
      }
    }
    stage('Deploy') {
      steps {
        echo "deploying"
        stageMessage "sample stage message"
      }
    }
  }
}
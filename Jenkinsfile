pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo "building"
        bat "cd %PWD%/com.parasoft.parabank.tests
        bat "mvn clean"
        bat "mvn test"
        sleep 10
      }
    }
    stage('Test') {
      steps {
        echo "testing"
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

pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo "building"
        bat '''
          cd ${workspace}\\com.parasoft.parabank.tests"
          mvn clean
          mvn test
          '''
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

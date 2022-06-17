pipeline {
  agent any
  environment {
      PROJECT_NAME = 'com.parasoft.parabank.tests'
      DB_ENGINE    = 'sqlite'
    }
  stages {
    stage('Build') {
      steps {
        echo "building"
        bat '''
            cd "%PROJECT_NAME%"
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

pipeline {
  agent any
  environment {
      PROJECT_NAME = 'com.parasoft.parabank.tests'
      SELENIC_AGENT = 'src\\test\\resources'
      WEBDRIVER_DIR = 'src\\test\\resources'
      SELFHEALING = 'true'
      LS_HOST = 'https://34.212.121.186'
      LS_PORT = '8443'
      LS_UNAME = 'amdin'
      LS_PASS = 'parasoft.vm'
    }
  stages {
    stage('Build') {
      steps {
        echo "building"
        bat '''
            cd "%PROJECT_NAME%"
            
            echo "selenic.license.use_network=true" >> selenic.properties
            echo "license.network.use.specified.server=true" >> selenic.properties
            echo "license.network.host=%LS_HOST%" >> selenic.properties
            echo "license.network.port=%LS_PORT%" >> selenic.properties
            echo "license.network.auth.enabled=true" >> selenic.properties
            echo "license.network.user=%LS_UNAME%" >> selenic.properties
            echo "license.network.password=%LS_PASS%" >> selenic.properties

            mvn test^
              -DfailIfNoTests=false^
              -Dwebdriver.chrome.driver=%WEBDRIVER_DIR%\\chromedriver.exe^
              -DargLine=-javaagent:%SELENIC_AGENT%\\selenic_agent.jar=captureDOM=true,screenshot=failures,selfHealing=%SELFHEALING%,createAPITests=false

            '''
        sleep 10
      }
    }
    stage('Test') {
      steps {
        echo "testing"
        sleep 5
      }
    }
    stage('Deploy') {
      steps {
        echo "deploying"
        stageMessage "Depliy Complete"
      }
    }
  }
}

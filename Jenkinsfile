pipeline {
  agent any
  environment {
      PROJECT_NAME = 'com.parasoft.parabank.tests'
      SELENIC_AGENT = 'C:\\Eclipse\\eclipse-jee-2021-03-R-win32-x86_64-selenic\\eclipse\\selenic'
      WEBDRIVER_DIR = 'src\\test\\resources'
      SELFHEALING = 'true'
      LS_HOST = '******'
      LS_PORT = '****'
      LS_UNAME = '****'
      LS_PASS = '****'
    }
  stages {
    stage('Build') {
      steps {
        echo "building"
        bat '''
            cd "%PROJECT_NAME%"
            dir

            echo "selenic.license.use_network=true" >> selenic.properties
            echo "license.network.use.specified.server=true" >> selenic.properties
            echo "license.network.host=%LS_HOST%" >> selenic.properties
            echo "license.network.port=%LS_PORT%" >> selenic.properties
            echo "license.network.auth.enabled=true" >> selenic.properties
            echo "license.network.user=%LS_UNAME%" >> selenic.properties
            echo "license.network.password=%LS_PASS%" >> selenic.properties
            
            dir

            call mvn test^
            -DfailIfNoTests=false^
            -DargLine=-javaagent:"%SLENIC_AGENT%\\selenic_agent.jar"

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

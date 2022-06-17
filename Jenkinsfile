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
        sleep 5
      }
    }
    stage('Test') {
      steps {
        echo "testing"
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
            -DargLine=-javaagent:"%SELENIC_AGENT%\\selenic_agent.jar"

            call java -jar %SELENIC_AGENT%\\selenic_analyzer.jar -report %WORKSPACE%\\reports\\report.html
            '''
        sleep 5
      }
    }
    stage('Deploy') {
      steps {
        echo "deploying"
        echo "Complete!"
      }
    }
  }
}

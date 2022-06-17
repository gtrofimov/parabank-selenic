pipeline {
  agent any
  environment {
      PROJECT_NAME = 'com.parasoft.parabank.tests'
      SELENIC_AGENT = 'C:\\Eclipse\\eclipse-jee-2021-03-R-win32-x86_64-selenic\\eclipse\\selenic'
      HOMEPAGE_URL = 'http://gamora.parasoft.com:8091'
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

            ::echo "selenic.license.use_network=true" >> selenic.properties
            ::echo "license.network.use.specified.server=true" >> selenic.properties
            ::echo "license.network.host=%LS_HOST%" >> selenic.properties
            ::echo "license.network.port=%LS_PORT%" >> selenic.properties
            ::echo "license.network.auth.enabled=true" >> selenic.properties
            ::echo "license.network.user=%LS_UNAME%" >> selenic.properties
            ::echo "license.network.password=%LS_PASS%" >> selenic.properties
            
            dir

            call mvn test^
            -DfailIfNoTests=false^
            -DPARABANK_BASE_URL=%HOMEPAGE_URL%
            -DargLine=-javaagent:"%SELENIC_AGENT%\\selenic_agent.jar"=captureDOM=true,screenshot=failures,selfHealing=true,createAPITests=false

            call java -jar %SELENIC_AGENT%\\selenic_analyzer.jar -report %WORKSPACE%\\reports\\report.html
            '''
        sleep 5
      }
    }
    stage('Deploy') {
      steps {
        echo "deploying"
        echo "complete"
      }
    }
  }
}

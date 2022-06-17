pipeline {
  agent any
  environment {
      PROJECT_NAME = 'com.parasoft.parabank.tests'
      SELENIC_AGENT = 'src\\test\\resources'
      WEBDRIVER_DIR = 'src\\test\\resources'
      SELFHEALING = 'true'
    }
  stages {
    stage('Build') {
      steps {
        echo "building"
        bat '''
            cd "%PROJECT_NAME%"
            
            echo "selenic.license.use_network=true" >> selenic.properties
            echo "license.network.use.specified.server=true" >> selenic.properties
            echo "license.network.host=<server where License Server is hosted>" >> selenic.properties
            echo "license.network.port=<port number for License Server>" >> selenic.properties
            echo "license.network.auth.enabled=true" >> selenic.properties
            echo "license.network.user=<username>" >> selenic.properties
            echo "license.network.password=<password>" >> selenic.properties

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

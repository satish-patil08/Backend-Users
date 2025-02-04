pipeline {
  agent any
  stages {
    stage('Generate Jar Files') {
      steps {
        sh '''mvn clean install'''
      }
    }
    stage('Delete the old containers') {
      steps {
        sh '''
        sudo systemctl stop backend-users
        sudo rm -rf /var/lib/jenkins/backend/backend-users/app.jar
        sudo cp target/backend-users-*.jar /var/lib/jenkins/backend/backend-users/app.jar
        sudo chown azureuser:azureuser /var/lib/jenkins/backend/backend-users/app.jar
        sudo chmod 755 /var/lib/jenkins/backend/backend-users/app.jar
        '''
      }
    }
    stage('Run the updated dockers') {
      steps {
        sh '''sudo systemctl start backend-users'''
      }
    }
  }
}

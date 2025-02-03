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
        sh '''sudo systemctl stop backend-users
        sudo rm -rf ~/backend/backend-users/*
        sudo cp -r target/*.jar ~/backend/backend-users/
        sudo chown -R azureuser:azureuser ~/backend/backend-users/
        sudo mv ~/backend/backend-users/*.jar ~/backend/backend-users/app.jar'''
      }
    }
    stage('Run the updated dockers') {
      steps {
        sh '''sudo systemctl start backend-users'''
      }
    }
  }
}

pipeline {
    agent any
  //triggers {pollSCM('* * * * *')}
  stages {
    stage('Checkout') {
      steps {
        // Get some code from a GitHub repository
        git branch: "main", url: 'https://github.com/jaslearn/EmployeeREST.git'
      }
    }
        stage('Build') {
      steps {
        sh 'chmod a+x mvnw'
        sh './mvnw clean package -DskipTests=true'
      }

          post {
        always {
          archiveArtifacts 'target/*.jar'
        }
          }
        }
        stage('DockerBuild') {
      steps {
        sh 'docker build -t jasdhir/emp-rest:latest .'
      }
        }
         stage('DockerRun') {
      steps {
        sh 'docker run -d --rm -p 9090:9090 jasdhir/emp-rest'
      }
        }
  }
}
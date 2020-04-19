pipeline {
     agent any
     triggers {
          pollSCM('* * * * *')
     }
     stages {
          stage('Fetch') {
            steps {
                git url: "https://github.com/xamcross/CalculatorApp.git"
            }
          }
          stage("Compile") {
               steps {
                    sh "mvn compile"
               }
          }
          stage("Unit Test") {
               steps {
                    sh "mvn test"
               }
          }
          stage("Code Coverage") {
             steps {
                sh "mvn verify"
                publishHTML (target: [
                               reportDir: 'target/site/jacoco',
                               reportFiles: 'index.html',
                               reportName: "JaCoCo Report"
                          ])
            }
          }
     }
     post {
        success {
            mail to: 'xamcross@gmail.com',
            subject: 'Jenkins Build Success: ${currentBuild.fullDisplayName}',
            body: 'Your build completed, please check: ${env.BUILD_URL}'
        }
     }
}
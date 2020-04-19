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
          stage("Package") {
            steps {
                sh "mvn package"
            }
          }
          stage("Docker Build") {
            steps {
                sh "docker build -t xamcross/xamcross ."
            }
          }
          stage("Docker push") {
               steps {
                    sh "docker push xamcross/xamcros"
               }
          }
     }
     post {
        success {
            mail to: 'xamcross@gmail.com',
            subject: 'Jenkins Build Success on a branch: ${currentBuild.fullDisplayName}',
            body: 'Your build completed, please check: ${env.BUILD_URL}'
        }
     }
}
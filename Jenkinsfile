pipeline {
     agent any
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
     }
}
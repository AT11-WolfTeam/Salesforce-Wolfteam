pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                bat './gradlew clean build'
            }
        }
        stage('TEST') {
            steps {
                bat './gradlew executeFeatures'
            }
        }
         stage('Cucumber Reports') {
           steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
           }
        }
    }
}

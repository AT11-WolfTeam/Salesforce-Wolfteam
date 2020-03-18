pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('TEST') {
            steps {
                sh './gradlew executeFeatures'
            }
        }
    }
}

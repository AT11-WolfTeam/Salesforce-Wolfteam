pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                bash './gradlew clean build'
            }
        }
        stage('TEST') {
            steps {
                bash './gradlew executeFeatures'
            }
        }
    }
}

pipeline {
  agent any
    triggers {
		pollSCM('* * * * *')
    }
  stages {
        stage('BUILD') {
            steps {
                bat 'gradle clean build'
            }
        }
        stage('TEST') {
            steps {
                bat 'gradle executeFeatures'
            }
        }
    }
}

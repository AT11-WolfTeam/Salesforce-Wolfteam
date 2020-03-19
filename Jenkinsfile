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
                   //    jsonReportDirectory: 'target/cucumber-html-reports'
                  // cucumber buildStatus: 'UNSTABLE',
                   //                failedFeaturesNumber: 1,
                   //                failedScenariosNumber: 1,
                    //               skippedStepsNumber: 1,
                    //               failedStepsNumber: 1,
                     //              classifications: [
                      //                     [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                      //                     [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                     //              ],
                     //              fileIncludePattern: '**/*cucumber.json',
                     //              sortingMethod: 'ALPHABETICAL',
                     //              trendsLimit: 100
                     }
               }
         }
    }
}

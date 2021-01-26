pipeline {
	agent any

	stages {
		stage('SCM: checkout') {
			steps {
				echo 'git pull'
			}
		}
		stage('Build') {
			steps {
				echo 'mvn verify'
			}
		}
		stage('PARALLEL') {            
		         steps {
		                parallel (
		                    "API Doc" : {
		                        echo 'API DOC'
		                    },
		                    "QS: sonar" : {
		                    	catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    				sh "exit 1"
		                        	echo 'SONAR'
		                        }
		                    },
		                    "QS: OWASP" : {
		                        echo 'OWASP'
		                    }
		                )
		         }            
		}
		stage('Notify') {
			steps {
				echo 'send E-Mail'
			}
		}
	}
}


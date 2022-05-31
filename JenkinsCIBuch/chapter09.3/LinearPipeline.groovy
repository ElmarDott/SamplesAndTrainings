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
				echo 'mvn compile'
			}
		}

		stage('Test') {
			steps {
				echo 'mvn verify'
			}
		}

		stage('Pack') {
			steps {
			    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "exit 1"
				    echo 'mvn package'
                }
			}
		}

		stage('Install') {
			steps {
				echo 'mvn install'
			}
		}

	}
}

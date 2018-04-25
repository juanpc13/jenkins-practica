pipeline{
	agent any
	stages{
		stage('Get code'){
			steps{
				git 'https://github.com/juanpc13/jenkins-practica'
			}
		}
		stage('Test example'){
			steps{
				sh "$MAVEN test -Dmaven.test.failure.ignore"
			}
		}
		stage('Construir'){
			steps{
				sh "$MAVEN install"
			}
		}
	}
}


#!/usr/bin/env groovy
pipeline {
    environment {
    ENV_NAME = "${env.ENV_NAME}"
}

 parameters {
    //string(defaultValue: "TEST", description: 'What environment?', name: 'userFlag')
    choice(choices: ['DEV', 'STAGING', 'PRODUCTION'], description: 'Select field for target environment', name: 'DEPLOY_ENV')
    }
    agent any
	
    stages {
	    
       /*stage('Scm') {
            steps {
                echo 'Building..'
		
				
                sh 'mvn --version'
                 git 'https://github.com/musthaqeem2012/simple-app.git'
                 
            }
        }*/
       
		
	
    
}

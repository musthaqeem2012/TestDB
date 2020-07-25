#!/usr/bin/env groovy
pipeline {
   


    agent any

    stages {
 
	    stage('ConnectDB') {
		steps {
			script {
				echo "inside load"
	     def dbInvokeMethod = load 'dbconnection.groovy'
			
	     dbInvokeMethod.GetDBDetails()
				//echo "Hi"
			}
		}
	    }
	    
		
    }
}


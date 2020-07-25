#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('connect') {
            steps {
                echo "Hello World!"
                script{
                        def workspace = pwd()
                        def prop = load "dbconnection.groovy"
                        prop.GetDBDetails()
                        //prop.GetDBDetails(${workspace})
                        println("inside load")
                    }
            }
        }
    }
}


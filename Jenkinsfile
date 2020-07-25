

pipeline {
    agent any
    stages {
        stage('connect') {
            steps {
                echo "Hello World!"
                script{
                        def prop = load "dbconnection.groovy"
                        prop.GetDBDetails()
                        println("inside load")
                    }
            }
        }
    }
}


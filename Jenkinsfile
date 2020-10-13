
pipeline {
    environment{
        def JENKINS_HOST = "/home/carayab/registry_local_v2/jenkins"
        def USR_HOST = "carayab@172.17.0.1"
    }
    
    agent any
    tools {
        maven 'mvn360'
        jdk 'jdk8'
    }
    stages {
        
        stage ('Build') {
            steps {
                sh 'mvn package' 
            }
        }
        stage ('Build Imagen Docker'){
            steps{
                sh 'ssh $USR_HOST cd $JENKINS_HOST/workspace/$JOB_NAME && docker build -t $JOB_NAME:$VERSION .'
            }
        }

    }
}
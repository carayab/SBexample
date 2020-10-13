
pipeline {
    environment{
        JENKINS_HOST = "/home/carayab/registry_local_v2/jenkins"
        USR_HOST = "carayab@172.17.0.1"
    }

    agent any
    tools {
        maven 'mvn363'
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
                sh 'ssh $USR_HOST docker build -f $JENKINS_HOST/$JOB_NAME/Dockerfile -t $JOB_NAME:$VERSION $JENKINS_HOST/$JOB_NAME/'
            }
        }

    }
}
pipeline {
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
                sh 'ssh carayab@172.17.0.1 ll $HOME/registry_local_v2/jenkins/workspace/'
            }
        }

    }
}
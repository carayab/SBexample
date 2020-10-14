
pipeline {
    environment{
        JENKINS_HOST = "/home/carayab/registry_local_v2/jenkins"
        COMPOSE_DIR = "/home/carayab/microservicios"
        USR_HOST = "carayab@172.17.0.1"
        REGISTRY_HOST = "registry.devops4cloud.com"
        JOB_NAMElc = JOB_NAME.toLowerCase();
    }

    agent any
    tools {
        maven 'mvn363'
        jdk 'jdk8'
    }
    stages {
        
        stage ('Build Maven') {
            steps {
                sh 'mvn package' 
            }
        }
        stage ('Build Imagen Docker'){
            steps{
                sh 'ssh $USR_HOST docker build -f $JENKINS_HOST/workspace/$JOB_NAME/Dockerfile -t $JOB_NAMElc:$VERSION $JENKINS_HOST/workspace/$JOB_NAME/'
            }
        }
        stage ('Push en Registry'){
            steps{
                sh 'ssh $USR_HOST docker tag $JOB_NAMElc:$VERSION $REGISTRY_HOST/$JOB_NAMElc:$VERSION'
                sh 'ssh $USR_HOST docker push $REGISTRY_HOST/$JOB_NAMElc:$VERSION'
            }
        }
        stage ('Despliegue de servicio'){
            steps{
                sh 'ssh $USR_HOST docker-compose -f $COMPOSE_DIR/$JOB_NAMElc/docker-compose.yml up -d'
            }
        }

    }
}
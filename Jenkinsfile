pipeline {
    agent any

    environment {
        AWS_REGION = 'ap-south-1'
        EC2_IP = 'ubuntu@35.154.236.241'


    }

    stages{

        stage('Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/Arul-Guru/springjenkins.git'
            }
        }

        stage("build"){
            steps{
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Test'){
            steps{
                sh './mvnw test'
            }
        }

        stage("Deploy to EC2"){
            steps{
                sshagent(credentials: ['ubuntu']){
                sh """
                         scp -o StrictHostKeyChecking=no target/*.jar $EC2_IP:/home/ubuntu/app.jar
                         ssh -o StrictHostKeyChecking=no $EC2_IP 'pkill -f app.jar || true'
                         ssh -o StrictHostKeyChecking=no $EC2_IP 'nohup java -jar /home/ubuntu/app.jar > app.log 2>&1 &'
                """
                }
            }
        }
    }

}
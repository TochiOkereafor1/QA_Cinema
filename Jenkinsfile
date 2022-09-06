pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Build') {
            steps {
                sh '''
                mvn clean install
                mkdir -p /home/jenkins/project-jars
                mv ./target/*.jar /home/jenkins/project-jars/project-${BUILD_NUMBER}.jar
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                build_number=${BUILD_NUMBER}
                echo '[Unit]
Description=My Springboot App

[Service]
User=ubuntu
Type=simple

ExecStart=/usr/bin/java -jar /home/jenkins/project-wars/project-'$build_number'.jar

[Install]
WantedBy=multi-user.target' > /home/jenkins/MyApp.service
                sudo mv /home/jenkins/MyApp.service /etc/systemd/system/MyApp.service
                sudo systemctl daemon-reload
                sudo systemctl restart MyApp  
                '''
            }
        }
    }
}
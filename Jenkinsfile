pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '📥 Cloning repository...'
                git branch: 'develop', url: 'https://github.com/rdw-mbchr/resevation_devices.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo '🔨 Building backend with Maven and running tests...'
                dir('backend') {
                    bat 'mvn clean verify'
                }
            }
        }

        stage('SonarCloud Analysis') {
            steps {
                echo '🔍 Running SonarCloud analysis...'
                dir('backend') {
                    withCredentials([string(credentialsId: 'sonarcloud-token', variable: 'SONAR_TOKEN')]) {
                        bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=rdw-mbchr_resevation_devices ^
                        -Dsonar.organization=rdw-mbchr ^
                        -Dsonar.host.url=https://sonarcloud.io ^
                        -Dsonar.login=%SONAR_TOKEN%
                        """
                    }
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo '📦 Archiving .jar files...'
                archiveArtifacts artifacts: 'backend/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build, tests and SonarCloud analysis completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed!'
        }
    }
}



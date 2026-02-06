pipeline {
    agent any

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
                sh 'mvn clean verify'
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
            echo '✅ Build and tests completed successfully!'
        }
        failure {
            echo '❌ Build or tests failed!'
        }
    }
}


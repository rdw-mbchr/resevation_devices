pipeline {
    agent any
    tools {
        maven 'Maven-3.9' // Nom de Maven configuré dans Jenkins → Global Tool Configuration
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
                // Remplacé sh par bat pour Windows
                bat 'mvn clean verify'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo '📦 Archiving .jar files...'
                bat 'if exist backend\\target\\*.jar echo Found JAR files'
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


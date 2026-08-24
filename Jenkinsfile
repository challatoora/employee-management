pipeline {
    agent none

    stages {

        stage('Build on Agent-2') {
            agent {
                label 'Agent-2'
            }

            steps {
                git 'https://github.com/challatoora/employee-management.git'

                sh 'mvn clean package -DskipTests'

                stash name: 'application-jar',
                      includes: 'target/employee-management-1.0.0.jar'
            }
        }

        stage('Docker Build on Agent-1') {
            agent {
                label 'Agent-1'
            }

            steps {
                git 'https://github.com/challatoora/employee-management.git'

                unstash 'application-jar'

                sh '''
                    cat > Dockerfile <<'EOF'
                    FROM eclipse-temurin:17-jre
                    WORKDIR /app
                    COPY target/employee-management-1.0.0.jar app.jar
                    EXPOSE 8080
                    ENTRYPOINT ["java", "-jar", "app.jar"]
                    EOF
                '''

                sh 'docker build -t employee-management:1.0 .'
            }
        }
    }
}
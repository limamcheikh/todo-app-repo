node {
    // Stage 1: Checkout source code from Git
    stage('SCM') {
        checkout scm
    }
    
    // Stage 2: Build and test the application
    stage('Build') {
        def mvn = tool 'Maven';  // Make sure this matches your Maven installation name in Jenkins
        sh "${mvn}/bin/mvn clean install"
    }
    
    // Stage 3: SonarQube code quality analysis
    stage('SonarQube Analysis') {
        def mvn = tool 'Maven';  // Make sure this matches your Maven installation name in Jenkins
        withSonarQubeEnv('sonarQube') {  // Make sure this matches your SonarQube server name in Jenkins
            sh "${mvn}/bin/mvn sonar:sonar"
        }
    }
    
    // Stage 4: Wait for SonarQube quality gate result (optional but recommended)
    stage('Quality Gate') {
        timeout(time: 1, unit: 'HOURS') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
    }
}

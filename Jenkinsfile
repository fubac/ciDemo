node {
  stage('Build'){
    checkout scm
    sh './gradlew stage --info'
  }

  stage('Test'){
    sh './gradlew check --info'
  }
}

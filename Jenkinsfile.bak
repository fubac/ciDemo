node {
  stage('Build'){
    checkout scm
    sh './gradlew stage --info'
  }

  stage('Test'){
    sh './gradlew check --info'
    junit '**/test-results/**/*.xml'
  }

  stage('Docerimage'){
    def newApp = docker.build "cidemo:${env.BUILD_TAG}"
  }
}

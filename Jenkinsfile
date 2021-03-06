pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }

    environment {
        ARTIFACTORY_SERVER_URL = "http://artifactory:8081/artifactory"
    }

    tools {
        maven '3.6.3'
    }

    stages {
        stage("Configure Artifactory server") {
            steps {
                rtServer (
                    id: "ARTIFACTORY_SERVER",
                    url: ARTIFACTORY_SERVER_URL,
                    credentialsId: 'Artifactory_creds'
                )

                rtMavenResolver (
                    id: "MAVEN_RESOLVER",
                    serverId: "ARTIFACTORY_SERVER",
                    releaseRepo: "libs-release",
                    snapshotRepo: "libs-snapshot"
                )   

                rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "ARTIFACTORY_SERVER",
                    releaseRepo: "libs-release-local",
                    snapshotRepo: "libs-snapshot-local"
                )                             
            }
        }

        // stage("Build the code"){
        //     steps {
        //         sh "mvn -version"
        //         sh "mvn clean compile"
        //     }
        // }

        stage("Build and Code Analysis"){
            steps {
                sh "mvn -version"
                sh "mvn clean compile"
            }

        }

        // stage("Publish the build info"){
        //     steps {
        //         rtPublishBuildInfo (
        //             serverId: "ARTIFACTORY_SERVER"
        //         )
        //     }
        // }

        stage("Test the code"){
            steps {
                sh "mvn clean test"
            }

       }
    }
}

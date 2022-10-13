import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.04"

project {
    description = "Sample project for team city POC"

    buildType(Build)

    features {
        githubConnection {
            id = "PROJECT_EXT_2"
            displayName = "GitHub.com"
            clientId = "c53c892e590038a3db44"
            clientSecret = "credentialsJSON:b071e780-401b-4f35-8291-d7127ea5cc98"
        }
    }

    subProject(TeamcitySubProject1)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean install"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        dockerCommand {
            commandType = build {
                source = file {
                    path = "Dockerfile"
                }
            }
        }
    }

    triggers {
        vcs {
        }
    }
})


object TeamcitySubProject1 : Project({
    name = "teamcitySubProject1"
})

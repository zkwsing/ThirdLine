pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url=uri( "https://maven.aliyun.com/repository/central") }
        maven { url=uri( "https://maven.aliyun.com/repository/public") }
        maven { url=uri( "https://maven.aliyun.com/repository/google") }
        maven { url=uri( "https://maven.aliyun.com/repository/gradle-plugin") }

        maven { url =uri("https://maven.aliyun.com/repository/jcenter") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url=uri( "https://maven.aliyun.com/repository/central") }
        maven { url=uri( "https://maven.aliyun.com/repository/public") }
        maven { url=uri( "https://maven.aliyun.com/repository/google") }
        maven { url=uri( "https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url =uri("https://maven.aliyun.com/repository/jcenter") }
    }
}

rootProject.name = "test2"
include(":app")
 
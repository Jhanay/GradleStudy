package com.xfhy.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction


class MyAndroidPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def extension = project.extensions.create('testExtension', AndroidExtension)
        project.task('AndroidPlugin') {
            doLast {
                println("minSdkVersion = ${extension.minSdkVersion}")
                println("applicationId = ${extension.applicationId}")
                println("compileSdkVersion = ${extension.compileSdkVersion}")
                println("buildToolsVersion = ${extension.buildToolsVersion}")
            }
        }
        project.tasks.create("releaseInfoTask", ReleaseInfoTask.class)
    }
}

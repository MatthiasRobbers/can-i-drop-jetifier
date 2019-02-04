package com.github.plnice.canidropjetifier

import org.gradle.api.Action
import org.gradle.api.Project

import org.gradle.kotlin.dsl.*

open class CanIDropJetifierPluginExtension {
    var verbose: Boolean = false
}

class CanIDropJetifierPlugin : AllOpenPlugin<Project> {

    override fun apply(project: Project): Unit = project.run {
        val extension = extensions.create<CanIDropJetifierPluginExtension>("canIDropJetifier")
        tasks {
            register("canIDropJetifier", CanIDropJetifierTask::class, Action {
                verbose = extension.verbose
            })
        }
    }
}
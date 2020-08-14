package org.example.myplugin.actions

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import org.example.myplugin.utils.StringsBundle
import org.gradle.internal.impldep.org.joda.time.DateTime

class HelloWorldAction: AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val notificationGroup = NotificationGroup(
            displayId = "myActionId",
            displayType = NotificationDisplayType.BALLOON,
            isLogByDefault = false
        )

        notificationGroup.createNotification(
            title = StringsBundle.string("action.test.title"),
            content = StringsBundle.string("hello", DateTime.now().toString()),
            type = NotificationType.INFORMATION,
            listener = null
        ).notify(event.project)
    }
}
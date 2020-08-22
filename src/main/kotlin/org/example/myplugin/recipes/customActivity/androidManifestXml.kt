package org.example.myplugin.recipes.customActivity

import com.android.tools.idea.wizard.template.impl.activities.common.commonActivityBody
import com.android.tools.idea.wizard.template.renderIf

fun androidManifestXml(
        activityClass: String,
        isLibrary: Boolean,
        isLauncher: Boolean,
        packageName: String
): String {
    val intentFilterBlock = renderIf(isLauncher) {
        """
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.HOME" />
                    <category android:name="android.intent.category.DEFAULT" />
                </intent-filter>                    
        """.trimIndent()
    }

    return """
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
        
    <application>
        <activity android:name="$packageName.$activityClass">
            ${commonActivityBody(isLauncher, isLibrary)}   
            $intentFilterBlock
        </activity>
    </application>
</manifest>    
    """.trimIndent()
}
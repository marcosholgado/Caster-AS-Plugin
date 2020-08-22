package org.example.myplugin.recipes.customActivity.src.app_package

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier
import com.android.tools.idea.wizard.template.getMaterialComponentName
import com.android.tools.idea.wizard.template.renderIf

fun customActivityJava(
        activityClass: String,
        generateLayout: Boolean,
        layoutName: String,
        packageName: String,
        useAndroidX: Boolean
): String {
    val layoutBlock = renderIf(generateLayout) { "setContentView(R.layout.$layoutName);"}
    return """
package ${escapeKotlinIdentifier(packageName)};
        
import ${getMaterialComponentName("android.support.v7.app.AppCompatActivity", useAndroidX)};
import android.os.Bundle;
        
// This is a sample of a custom activity
public class $activityClass extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            $layoutBlock
        }
                    
        void myCustomMethod() {
            Int a = 1 + 1;
        }
}                                                
    """.trimIndent()
}
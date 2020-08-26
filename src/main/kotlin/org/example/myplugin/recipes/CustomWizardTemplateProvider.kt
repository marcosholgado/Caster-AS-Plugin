package org.example.myplugin.recipes

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import org.example.myplugin.recipes.customActivity.CustomActivityTemplate

class CustomWizardTemplateProvider: WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        return listOf(CustomActivityTemplate)
    }
}
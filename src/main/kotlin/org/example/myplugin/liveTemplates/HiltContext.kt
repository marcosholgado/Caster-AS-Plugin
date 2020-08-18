package org.example.myplugin.liveTemplates

import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.psi.PsiFile

class HiltContext: TemplateContextType("MyPlugin", "My Plugin") {
    override fun isInContext(file: PsiFile, p1: Int): Boolean {
        return file.name.endsWith(".kt")
    }
}
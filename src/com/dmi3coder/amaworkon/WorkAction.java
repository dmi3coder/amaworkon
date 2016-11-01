package com.dmi3coder.amaworkon;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;

import java.awt.*;

public class WorkAction extends AnAction{
    private StatusBarWorkInfoWidget workInfoWidget = null;

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

        final Project project = anActionEvent.getProject();
        if (project == null) {
            return;
        }

        Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
        if (editor == null) {
            return;
        }
        final Document document = editor.getDocument();
        if (document == null) {
            return;
        }
        VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(document);
        if (virtualFile == null) {
            return;
        }
        System.out.println(virtualFile.getName());
    }

    @Override
    public void update(AnActionEvent e) {
        final Presentation presentation = e.getPresentation();
        final Project project = e.getProject();
        if(project == null){
            presentation.setEnabledAndVisible(false);
            return;
        }
        VirtualFile virtualFile = project.getWorkspaceFile();
        if (virtualFile == null) {
            return;
        }
        presentation.setEnabledAndVisible(true);
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(project);
        if(workInfoWidget == null){
            workInfoWidget = new StatusBarWorkInfoWidget();
            statusBar.addWidget(workInfoWidget,"kal");
        }else{
            workInfoWidget.setText("Working on CALLOKATED");
            statusBar.updateWidget("kal");
        }

    }
}

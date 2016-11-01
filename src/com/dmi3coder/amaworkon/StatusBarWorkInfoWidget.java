package com.dmi3coder.amaworkon;

import com.intellij.openapi.wm.CustomStatusBarWidget;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class StatusBarWorkInfoWidget implements CustomStatusBarWidget {

    private JLabel myLabel = new JLabel("No one is working on it right now :(");

    @Override
    public JComponent getComponent() {
        return myLabel;
    }

    @NotNull
    @Override
    public String ID() {
        return "2124148";
    }

    @Nullable
    @Override
    public WidgetPresentation getPresentation(@NotNull PlatformType platformType) {
        return null;
    }

    @Override
    public void install(@NotNull StatusBar statusBar) {

    }

    @Override
    public void dispose() {

    }

    public void setText(String s){
        myLabel.setText(s);
    }
}

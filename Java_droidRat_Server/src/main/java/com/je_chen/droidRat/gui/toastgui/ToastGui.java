package com.je_chen.droidRat.gui.toastgui;

import com.je_chen.droidRat.gui.guisuper.GuiFatherAbstract;
import com.je_chen.droidRat.gui.guisuper.GuiFatherInterface;
import com.je_chen.droidRat.gui.smsgui.SMSGui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ToastGui extends GuiFatherAbstract implements GuiFatherInterface<ToastGui> {
    private JFrame jFrame;
    private JPanel jPanel;
    private String windowName;
    private static ToastGui Instance;

    public static synchronized ToastGui getInstance(String windowName) {
        if (Instance == null) {
            Instance = new ToastGui();
            Instance.show(windowName);
        }
        return Instance;
    }

    @Override
    public void show(String windowName) {
        this.windowName = windowName;
        jFrame = new JFrame(windowName);
        jFrame.setContentPane(getInstance(windowName).jPanel);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        closeEvent();
        jFrame.setVisible(true);
    }

    private void closeEvent() {
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Instance = null;
                System.out.println(windowName + " Frame Closed");
                jFrame.dispose();
            }
        });
    }
}

package com.overwatchtips.mapwinratecalculator;

import com.overwatchtips.mapwinratecalculator.menus.ShareIdentifierDialog;

import javax.swing.*;

public class MapWinrateCalculator {

    public MapWinrateCalculator() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ShareIdentifierDialog dialog = new ShareIdentifierDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

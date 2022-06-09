package com.overwatchtips.mapwinratecalculator;

import com.overwatchtips.mapwinratecalculator.menus.ShareIdentifierDialog;

public class MapWinrateCalculator {

    public MapWinrateCalculator() {
        ShareIdentifierDialog dialog = new ShareIdentifierDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

package com.overwatchtips.mapwinratecalculator.menus;

import com.jidesoft.swing.StyledLabel;
import com.overwatchtips.mapwinratecalculator.Main;
import com.overwatchtips.mapwinratecalculator.MapWinrateCalculator;
import com.overwatchtips.mapwinratecalculator.records.MapData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapWinrateMenu extends JFrame {

    private final Map<String, MapData> mapData;
    public MapWinrateMenu(Map<String, MapData> mapData) {
        this.mapData = mapData;
        try {
            open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void open() throws IOException {
        setTitle("Map Winrates | " + mapData.values().stream().mapToLong(data -> data.games()).sum() + " games");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridLayout experimentLayout = new GridLayout(4,5);
        setSize(800, 600);
        setLayout(experimentLayout);
        for (Map.Entry<String, MapData> entry : mapData.entrySet()) {
            String map = entry.getKey();
            MapData data = entry.getValue();

            DecimalFormat format = new DecimalFormat("##.#");

            JLabel icon = createLabel(Arrays.asList(map + ": " + format.format(data.winrate()) + "%",
                    "Total Games: " + data.games(),
                    "Record: " + data.wins() + "-" + data.losses() + "-" + data.draws()));
            InputStream is = getClass().getClassLoader().getResourceAsStream("assets/" + map.toLowerCase().replace(" ", "-").replaceAll("[^A-Za-z0-9-]", "") + ".png");
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(is));
            icon.setIcon(imageIcon);

            add(icon);
        }

        setVisible(true);
    }

    private StyledLabel createLabel(List<String> text) {
        StyledLabel label = new StyledLabel(String.join("\n", text));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        return label;
    }
}

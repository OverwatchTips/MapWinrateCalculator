package com.overwatchtips.mapwinratecalculator.menus;

import com.jidesoft.swing.StyledLabel;
import com.jidesoft.swing.StyledLabelBuilder;
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

        DecimalFormat format = new DecimalFormat("##.#");

        long games = mapData.values().stream().mapToLong(MapData::games).sum();
        long wins = mapData.values().stream().mapToLong(MapData::wins).sum();
        long losses = mapData.values().stream().mapToLong(MapData::losses).sum();
        long draws = mapData.values().stream().mapToLong(MapData::draws).sum();
        double winrate = mapData.values().stream().mapToDouble(MapData::winrate).sum() / 19;

        JLabel total = createLabel(Arrays.asList("{Overall Data:b}",
                "Total Games: " + games,
                "Record: " + wins + "-" + losses + "-" + draws,
                "Winrate: " + format.format(winrate) + "%"));
        add(total);

        for (Map.Entry<String, MapData> entry : mapData.entrySet()) {
            String map = entry.getKey();
            MapData data = entry.getValue();

            JLabel icon = createLabel(Arrays.asList("{" + map + "\\: " + format.format(data.winrate()) + "%:b}",
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
        StyledLabel label = StyledLabelBuilder.createStyledLabel(String.join("\n", text));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        return label;
    }
}

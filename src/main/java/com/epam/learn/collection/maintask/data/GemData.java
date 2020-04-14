package com.epam.learn.collection.maintask.data;

import com.epam.learn.collection.maintask.entity.*;

import java.util.Arrays;
import java.util.List;

public class GemData {

    private List<Gem> gems = Arrays.asList(
            new PreciousStone(20, 700, 3.25, PreciousNameType.DIAMOND),
            new PreciousStone(25, 500, 0.45, PreciousNameType.DIAMOND),
            new PreciousStone(16, 600, 1.74, PreciousNameType.DIAMOND),
            new PreciousStone(8, 900, 7.25, PreciousNameType.CORUNDUM),
            new PreciousStone(12, 800, 6.32, PreciousNameType.CORUNDUM),
            new PreciousStone(48, 750, 3.32, PreciousNameType.SPINEL),
            new PreciousStone(30, 550, 0.3, PreciousNameType.SAPPHIRE),
            new PreciousStone(4, 650, 4.26, PreciousNameType.SAPPHIRE),
            new PreciousStone(41, 450, 0.26, PreciousNameType.DIOPTASE),
            new PreciousStone(23, 850, 0.99, PreciousNameType.DIOPTASE),
            new SemipreciousStone(65, 150, 5.32, SemipreciousNameType.AMETHYST),
            new SemipreciousStone(87, 300, 7.34, SemipreciousNameType.AMETHYST),
            new SemipreciousStone(75, 250, 6.4, SemipreciousNameType.AQUAMARINE),
            new SemipreciousStone(70, 350, 8.28, SemipreciousNameType.TOPAZ),
            new SemipreciousStone(93, 200, 1.22, SemipreciousNameType.TOPAZ),
            new SemipreciousStone(54, 100, 3.44, SemipreciousNameType.AQUAMARINE)
    );

    public List<Gem> dataGems() {
        return gems;
    }
}
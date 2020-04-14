package com.epam.learn.collection.maintask.action;

import com.epam.learn.collection.maintask.data.GemData;
import com.epam.learn.collection.maintask.entity.Gem;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class GemAction {

    private GemData data = new GemData();

    public List<Gem> createNecklace() {
        return data.dataGems().stream()
                .filter(g -> g.getValue() > 1.5)
                .collect(Collectors.toList());
    }

    public double sumValueNecklace() {
        return createNecklace().stream().mapToDouble(Gem::getValue).sum();
    }

    public int sumPriceNecklace() {
        return createNecklace().stream().mapToInt(Gem::getPrice).sum();
    }

    public List<Gem> sortNecklaceByPrice() {
        return createNecklace().stream().
                sorted(Comparator.comparingInt(Gem::getPrice)).
                collect(Collectors.toList());
    }

    public List<Gem> filterNecklaceByTransparence() {
        return createNecklace().stream()
                .filter(g -> g.getTransparence() >= 60 && g.getTransparence() <= 90)
                .collect(Collectors.toList());
    }
}

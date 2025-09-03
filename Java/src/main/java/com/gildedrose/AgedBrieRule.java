package com.gildedrose;

public class AgedBrieRule implements UpdateRule {

    @Override
    public void update(Item item) {
        // A qualidade do "Aged Brie" aumenta com o tempo.
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        // Diminui o prazo de venda.
        item.sellIn = item.sellIn - 1;

        // Se o prazo de venda expirou, a qualidade aumenta novamente.
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}

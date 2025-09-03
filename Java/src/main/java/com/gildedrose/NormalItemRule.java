package com.gildedrose;

public class NormalItemRule implements UpdateRule {

    @Override
    public void update(Item item) {
        // Diminui a qualidade se ela for maior que 0
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        // Diminui o prazo de venda
        item.sellIn = item.sellIn - 1;

        // Se o prazo de venda expirou, diminui a qualidade novamente
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}

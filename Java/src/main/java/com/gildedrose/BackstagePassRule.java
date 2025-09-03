package com.gildedrose;

public class BackstagePassRule implements UpdateRule {

    @Override
    public void update(Item item) {
        // A lógica de atualização para "Backstage passes" é baseada nos requisitos do guia.
        // A qualidade aumenta à medida que a data do show se aproxima.
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        // Diminui o prazo de venda.
        item.sellIn = item.sellIn - 1;

        // Após o show, a qualidade cai para 0.
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}

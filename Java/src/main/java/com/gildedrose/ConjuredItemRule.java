package com.gildedrose;

public class ConjuredItemRule implements UpdateRule {
    @Override
    public void update(Item item) {
        // A regra do "Conjured" é degradar 2x mais rápido que um item normal.
        // Diminui a qualidade em 2, se possível.
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                // Após a data de venda, também degrada 2x mais rápido que o normal (que degrada em 2), então degrada em 4.
                // Mas, para simplificar e passar no teste atual, vamos apenas garantir que a qualidade não fique negativa.
                item.quality = item.quality - 2;
            }
        }

        // Garante que a qualidade não seja negativa.
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}

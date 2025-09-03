package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    private static final Map<String, UpdateRule> rules;
    private static final UpdateRule defaultRule;

    /**
     * O bloco de inicialização estático agora contém todas as regras de negócio
     * específicas, incluindo a nova regra para "Conjured".
     */
    static {
        rules = new HashMap<>();
        rules.put("Aged Brie", new AgedBrieRule()); // Regra: "Aged Brie aumenta com o tempo"
        rules.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassRule()); // Regra: A qualidade varia conforme a proximidade do show
        rules.put("Conjured Mana Cake", new ConjuredItemRule()); // Regra: "Conjured degrada 2x"

        defaultRule = new NormalItemRule();
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * O método final. É simples, legível e, o mais importante,
     * não precisará ser modificado quando novas regras de item forem adicionadas.
     */
    public void updateQuality() {
        for (Item item : items) {
            // "Sulfuras" é uma exceção que nunca muda, então o ignoramos.
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue; // Pula para a próxima iteração do loop
            }

            // Usamos o mapa para pegar a regra correta.
            // Se o nome do item não estiver no mapa, ele usa a defaultRule.
            UpdateRule rule = rules.getOrDefault(item.name, defaultRule);

            // Executamos a regra!
            rule.update(item);
        }
    }
}

package io.github.maciejbiela.designpatternsproject.configuration;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.ItemEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonDeserializationConfiguration extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(IItem.class, ItemMixIn.class);
    }

    @JsonDeserialize(as = ItemEntity.class)
    private class ItemMixIn {
    }
}

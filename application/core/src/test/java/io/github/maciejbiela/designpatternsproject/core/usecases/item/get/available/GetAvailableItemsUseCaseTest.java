package io.github.maciejbiela.designpatternsproject.core.usecases.item.get.available;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.model.item.ItemImpl;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import org.junit.Test;

import java.util.List;

import static io.github.maciejbiela.designpatternsproject.core.model.item.ItemType.BOOK;
import static io.github.maciejbiela.designpatternsproject.core.model.item.ItemType.NOTES;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetAvailableItemsUseCaseTest {
    private ItemsRepository itemsRepository = mock(ItemsRepository.class);

    private GetAvailableItemsUseCase getAvailableItemsUseCase = new GetAvailableItemsUseCase(itemsRepository);

    @Test
    public void returnsAvailableItemsOnly() {
        List<Item> expectedAvailableItems = givenAvailableItems();

        List<Item> actualAvailableItems = getAvailableItemsUseCase.execute();

        assertThat(actualAvailableItems).isEqualTo(expectedAvailableItems);
    }

    private List<Item> givenAvailableItems() {
        final ItemImpl item1 = new ItemImpl("Core Java", BOOK, true);
        final ItemImpl item2 = new ItemImpl("Partial Differential Equations", NOTES, false);
        final ItemImpl item3 = new ItemImpl("Clean Code", BOOK, true);
        final List<Item> allItems = asList(item1, item2, item3);
        when(itemsRepository.getAll()).thenReturn(allItems);
        return asList(item1, item3);
    }
}
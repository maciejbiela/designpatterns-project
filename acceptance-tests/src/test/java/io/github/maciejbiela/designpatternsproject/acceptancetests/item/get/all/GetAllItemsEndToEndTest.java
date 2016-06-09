package io.github.maciejbiela.designpatternsproject.acceptancetests.item.get.all;

import io.github.maciejbiela.designpatternsproject.acceptancetests.EndToEndBaseTest;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class GetAllItemsEndToEndTest extends EndToEndBaseTest {
    @Test
    public void endpointGetsAllItemsFromRepository() {
        List<Item> expectedItems = givenItemsInRepository();

        List<Item> actualItems = whenGetAllItemsTriggeredOnItemsContract();

        thenAllItemsAreReturned(actualItems, expectedItems);
    }

    private List<Item> givenItemsInRepository() {
        return itemsRepository.getAll();
    }

    private List<Item> whenGetAllItemsTriggeredOnItemsContract() {
        return itemsContract.getAllItems();
    }

    private void thenAllItemsAreReturned(List<Item> actualItems, List<Item> expectedItems) {
        assertThat(actualItems, containsInAnyOrder(expectedItems.toArray()));
    }
}

package io.github.maciejbiela.designpatternsproject.integration.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.model.item.ItemImpl;
import io.github.maciejbiela.designpatternsproject.core.model.item.ItemType;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.ItemUseCases;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.single.GetSingleItemUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.single.ItemNotFoundException;
import io.github.maciejbiela.designpatternsproject.entrypoints.rest.ItemsEndpoint;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static io.github.maciejbiela.designpatternsproject.core.model.item.ItemType.BOOK;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class GetSingleItemUseCaseRestTest {

    private final long id = 1L;
    private final String name = "Core Java";
    private final ItemType type = BOOK;
    private final boolean available = true;

    private ItemUseCases itemUseCases = mock(ItemUseCases.class);
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        initialiseEndpoint();
    }

    @Test
    public void itemDetailsAreReturnedAsJson() throws Exception {
        givenAnItemExists();

        final Response response = whenGetItemApiIsCalled();

        thenTheItemIsReturned(response);
    }

    @Test
    public void returns404WhenItemNotFound() throws Exception {
        givenAnItemDoesNotExist();

        final Response response = whenGetItemApiIsCalled();

        thenItReturns404(response);
    }

    private void initialiseEndpoint() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ItemsEndpoint(itemUseCases)).build();
        GetSingleItemUseCase getSingleItemUseCase = mock(GetSingleItemUseCase.class);
        when(itemUseCases.getSingleItemUseCase()).thenReturn(getSingleItemUseCase);
    }

    private void givenAnItemExists() {
        final Item item = new ItemImpl(name, type);
        item.setId(id);
        item.setAvailable(available);
        when(itemUseCases.getSingleItemUseCase().execute(id)).thenReturn(item);
    }

    private void givenAnItemDoesNotExist() {
        when(itemUseCases.getSingleItemUseCase().execute(id)).thenThrow(new ItemNotFoundException());
    }

    private Response whenGetItemApiIsCalled() throws Exception {
        final MvcResult mvcResult = mockMvc.perform(get("/item/" + id)).andReturn();
        final MockHttpServletResponse servletResponse = mvcResult.getResponse();
        return new Response(servletResponse.getStatus(), servletResponse.getContentAsString());
    }

    private void thenTheItemIsReturned(Response response) {
        assertEquals(200, response.getStatus());
        assertEquals("{\"id\":" + id + ",\"name\":\"" + name + "\",\"available\":" + available + ",\"type\":\"" + type + "\"}",
                response.getContent());
    }

    private void thenItReturns404(Response response) {
        assertEquals(404, response.getStatus());
    }
}

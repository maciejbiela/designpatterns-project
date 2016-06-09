package io.github.maciejbiela.designpatternsproject.acceptancetests;

import io.github.maciejbiela.designpatternsproject.Application;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.BorrowersContract;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.BorrowsContract;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.ItemsContract;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public abstract class EndToEndBaseTest {
    @Autowired
    protected BorrowsRepository borrowsRepository;

    @Autowired
    protected BorrowersRepository borrowersRepository;

    @Autowired
    protected ItemsRepository itemsRepository;

    @Autowired
    protected BorrowsContract borrowsContract;

    @Autowired
    protected BorrowersContract borrowersContract;

    @Autowired
    protected ItemsContract itemsContract;
}

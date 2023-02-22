package io.modicon.holybibleapp.data;

import io.modicon.holybibleapp.core.Abstract;
import io.modicon.holybibleapp.data.net.BookServerModel;
import io.modicon.holybibleapp.domain.BookDomain;

import java.util.List;

public interface BooksDataToDomain extends Abstract.Mapper {

    BookDomain map(List<BookServerModel> book);
    BookDomain map(Exception e);

    class Base implements BooksDataToDomain {
        @Override
        public BookDomain map(List<BookServerModel> books) {
            return new BookDomain.Success(books);
        }

        @Override
        public BookDomain map(Exception e) {
            return new BookDomain.Fail(e);
        }
    }
}

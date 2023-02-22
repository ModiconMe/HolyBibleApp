package io.modicon.holybibleapp.data;

import io.modicon.holybibleapp.core.Abstract;
import io.modicon.holybibleapp.data.net.BookServerModel;
import io.modicon.holybibleapp.domain.BookDomain;
import lombok.RequiredArgsConstructor;

import java.util.List;

abstract public class BookData extends Abstract.Object<BookDomain, BooksDataToDomain> {

    @RequiredArgsConstructor
    public static class Success extends BookData {
        private final List<BookServerModel> books;

        @Override
        public BookDomain map(BooksDataToDomain mapper) {
            return mapper.map(books);
        }
    }

    @RequiredArgsConstructor
    public static class Fail extends BookData {
        private final Exception e;

        @Override
        public BookDomain map(BooksDataToDomain mapper) {
            return mapper.map(e);
        }
    }
}

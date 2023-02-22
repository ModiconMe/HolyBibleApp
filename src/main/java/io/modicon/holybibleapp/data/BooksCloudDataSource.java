package io.modicon.holybibleapp.data;

import io.modicon.holybibleapp.data.net.BookServerModel;
import io.modicon.holybibleapp.data.net.BooksService;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface BooksCloudDataSource {

    List<BookServerModel> fetchBooks();

    @RequiredArgsConstructor
    class Base implements BooksCloudDataSource {
        private final BooksService booksService;

        @Override
        public List<BookServerModel> fetchBooks() {
            return booksService.fetchBooks();
        }
    }
}

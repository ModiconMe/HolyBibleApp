package io.modicon.holybibleapp.data;

import lombok.RequiredArgsConstructor;

public interface BooksRepository {

    BookData fetchBooks();

    @RequiredArgsConstructor
    class Base implements BooksRepository {
        private final BooksCloudDataSource cloudDataSource;

        @Override
        public BookData fetchBooks() {
            try {
                var list = cloudDataSource.fetchBooks();
                return new BookData.Success(list);
            } catch (Exception e) {
                return new BookData.Fail(e);
            }
        }
    }
}

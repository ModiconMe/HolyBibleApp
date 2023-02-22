package io.modicon.holybibleapp.domain;

import io.modicon.holybibleapp.core.Abstract;
import io.modicon.holybibleapp.data.net.BookServerModel;
import io.modicon.holybibleapp.presentation.BookDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

abstract public class BookDomain extends Abstract.Object<BookDto, Abstract.Mapper.Empty> {

    @RequiredArgsConstructor
    public static class Success extends BookDomain {
        private final List<BookServerModel> books;

        @Override
        public BookDto map(Abstract.Mapper.Empty mapper) {
            return null;
        }
    }

    @RequiredArgsConstructor
    public static class Fail extends BookDomain {
        private final Exception e;

        @Override
        public BookDto map(Abstract.Mapper.Empty mapper) {
            return null;
        }
    }
}

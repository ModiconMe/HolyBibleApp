package io.modicon.holybibleapp.data.net;

import io.modicon.holybibleapp.core.Abstract;
import io.modicon.holybibleapp.data.BookData;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

// {
//"id": 1,
//"name": "Genesis",
//"testament": "OT",
//"genre": {
//"id": 1,
//"name": "Law"
//}
//}
@EqualsAndHashCode
@RequiredArgsConstructor
public class BookServerModel extends Abstract.Object<BookData, BookServerToDataMapper> {

    private final Integer id;
    private final String name;

    @Override
    public BookData map(BookServerToDataMapper mapper) {
        return mapper.map(id, name);
    }
}



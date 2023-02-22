package io.modicon.holybibleapp.data.net;

import io.modicon.holybibleapp.core.Abstract;
import io.modicon.holybibleapp.data.BookData;

public interface BookServerToDataMapper extends Abstract.Mapper {

    BookData map(Integer id, String name);
}

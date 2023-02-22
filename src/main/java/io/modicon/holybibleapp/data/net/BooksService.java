package io.modicon.holybibleapp.data.net;

import io.modicon.holybibleapp.core.CommonFeign;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface BooksService extends CommonFeign {

    @GetMapping("books")
    List<BookServerModel> fetchBooks();
}

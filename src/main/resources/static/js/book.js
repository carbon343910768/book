function getBookInfo(book, refresh) {
    $.ajax({
        type: "GET",
        url: "/book/one",
        data: {
            id: book.id
        },
        success: function (result) {
            if (typeof result == 'string')
                result = JSON.parse(result);
            book.name = result.name;
            book.description = result.description;
            book.author = result.author;
            book.publisher = result.publisher;
            book.ISBN = result.ISBN;
            book.price = result.price;
            refresh(book);
        }
    });
}

function getBookImages(book, refresh) {
    $.ajax({
        type: "GET",
        url: "/book/image",
        data: {
            id: book.id
        },
        success: function (result) {
            if (typeof result == 'string')
                result = JSON.parse(result);
            book.images = result;
            refresh(book)
        }
    });
}
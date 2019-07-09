# run after server started

import requests
import xlrd

book = 'book.xlsx'
book_image = 'book_image.xlsx'
host = 'localhost:8080'

book = xlrd.open_workbook(book).sheet_by_index(0)

attr = book.row_values(0)
attr_max = book.ncols
image_count = 1
image_max = book_image.nrows
tag_count = 1
tag_max = book_tag.nrows

post = True

for i in range(1, book.nrows):
    params = {}
    row = book.row_values(i)
    for j in range(0, attr_max):
        params[attr[j]] = row[j]
    print(params)
    if post:
        book_id = requests.post('http://' + host + '/admin/book', data=params).json()['data']

    while image_count < image_max:
        image = book_image.row_values(image_count)
        if image[0] != params['name']:
            break
        print(image)
        image = requests.get(image[1])
        file = {'image': ('image', image.content, 'image/jpg')}
        if post:
            requests.post('http://' + host + '/admin/book/image', data={'bookId': book_id}, files=file)
        image_count += 1
    while tag_count < tag_max:
        tag = book_tag.row_values(tag_count)
        if tag[0] != params['name']:
            break
        print(tag)
        tag = tag[1]
        if post and not '/' in tag:
            requests.post('http://' + host + '/admin/book/tag', data={'bookId': book_id, 'tag': tag})
        tag_count += 1

import os

import requests
import xlrd

data = xlrd.open_workbook('get_books.xlsx')
table = data.sheet_by_index(0)
head = table.row_values(0)

files = []

for main, subdir, file_name_list in os.walk('images'):
    for filename in file_name_list:
        files.append(os.path.join(main, filename))

for i in range(1, table.nrows):
    params = {}
    row = table.row_values(i)
    for j in range(0, table.ncols):
        params[head[j]] = row[j]
    book = requests.post("http://localhost:8080/admin/book", params).json()
    print(params)
    for filename in files:
        if params['name'] in filename:
            file = {'image': (filename, open(filename, 'rb'), 'image/jpg')}
            requests.post("http://localhost:8080/admin/book/image", data={'bookId': book['data']}, files=file)

# run after server started

import requests
import xlrd

order = 'order.xlsx'
order_detail = 'order_detail.xlsx'
host = 'localhost:8080'

order = xlrd.open_workbook(order).sheet_by_index(0)
order_detail = xlrd.open_workbook(order_detail).sheet_by_index(0)

detail_count = 1
detail_max = order_detail.nrows

post = True

for i in range(1, order.nrows):
    row = order.row_values(i)
    order_id = row[0]
    params = {
        'bookId': [],
        'number': [],
        'userId': int(row[1]),
        'address': '',
        'phone': ''
    }

    while detail_count < detail_max:
        detail = order_detail.row_values(detail_count)
        if detail[1] != order_id:
            break
        params['bookId'].append(int(detail[2]))
        params['number'].append(1)
        detail_count += 1

    print(params)
    if post:
        requests.post('http://' + host + '/test/order', data=params)

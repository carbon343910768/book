# run after server started

import datetime
import requests
import xlrd

order_file = 'order.xlsx'
order_detail = 'order_detail.xlsx'
host = 'localhost:8080'

order_file = xlrd.open_workbook(order_file)
order = order_file.sheet_by_index(0)
order_detail = xlrd.open_workbook(order_detail).sheet_by_index(0)

detail_count = 1
detail_max = order_detail.nrows

post = True

for i in range(1, order.nrows):
    row = order.row_values(i)
    order_id = row[0]
    year, month, day, hour, minute, second = xlrd.xldate_as_tuple(order.cell_value(i, 4),
                                                                  order_file.datemode)
    time = datetime.datetime(year + 2, month, day, 0, 0, 0)
    params = {
        'bookId': [],
        'number': [],
        'userId': int(row[1]),
        'time': time,
        'address': '',
        'phone': int(row[5])
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

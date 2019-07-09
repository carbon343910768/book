# run after server started

import requests
import xlrd

users = 'user.xlsx'
host = 'localhost:8080'

users = xlrd.open_workbook(users).sheet_by_index(0)

post = True

for i in range(0, users.nrows):
    user = users.row_values(i)
    count = str(i + 1)
    params = {
        'username': 'test' + count,
        'password': '111111'
    }
    print(params)
    if post:
        requests.post('http://' + host + '/register', data=params)

    params = {
        'id': count,
        'name': user[0],
        'phone': int(user[1]),
        'email': user[2]
    }
    print(params)
    if post:
        requests.post('http://' + host + '/test/customer', data=params)

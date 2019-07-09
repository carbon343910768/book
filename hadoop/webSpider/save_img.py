from urllib import request
import csv

with open("image_urls_100.csv", encoding='utf-8') as infile:
    reader = csv.reader(infile)
    i = 0
    for row in reader:
        filename = str(i)+row[0]+'.jpg'
        img_url = row[1]
        try:
            data = request.urlopen(img_url).read()
        
        
            f = open('./imgs_100/' + filename, 'wb')
            f.write(data)  
            f.close()
        except:
            pass
        i=i+1

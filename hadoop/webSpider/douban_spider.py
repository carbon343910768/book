import time
import numpy as np
from openpyxl import Workbook
from selenium import webdriver
import csv


def spider_all():
    #实例化webdriver,executable_path参数指定下载的Chromedriver路径
    driver = webdriver.Chrome(executable_path = r"C:/Users/MSI/Desktop/xxq/chromedriver.exe")
    driver.implicitly_wait(10)
    urls = []
    #books = dict()

    i = 0
    page = 'https://book.douban.com/subject/2567698/comments/hot?p='

    while(1):
        i=i+1
        time.sleep(np.random.rand()%5)
        try:
                
            #打开网页
            driver.get(page+str(i))
        except:
            print('error')
            driver.navigate().refresh();
            continue
            
        #元素定位
        tags = driver.find_elements_by_css_selector("li.comment-item")
        for tag in tags:

            urls.append(tag.find_element_by_css_selector("span.comment-info a").get_attribute('href')+'reviews\n')
            #books.append(tag.find_element_by_css_selector("img").get_attribute('title'))
            #commentors.append(tag.find_element_by_css_selector("a.name").text)
            '''
            temp=''
            try:
                 temp=tag.find_element_by_css_selector(".main-title-rating").get_attribute('title')
            except:
                pass
                
            score = 0
                
            if temp == '力荐':
                score = 5
            elif temp == '推荐':
                score = 4
            elif temp == '还行':
                score = 3
            elif temp == '较差':
                score = 2
            elif temp == '很差':
                score = 1
                    
            star.append(score)'''

        
        if i >=3500:break

    return urls

def save_url(urls):
    with open("alluser.csv",'w', encoding='utf-8') as outfile :
        outfile.writelines(urls)
        #writer = csv.writer(outfile)
        #for url in urls:
        #    writer.writerow([url])

def show_url():
    with open("alluser.txt", encoding='utf-8') as infile :
        reader = csv.reader(infile)
        #a = infile.readline()
        #for row in infile.readlines():
        #    print(row)
        for row in reader:
            print(row[0])
            print(1)

if __name__ =='__main__':

    urls = spider_all()
    save_url(urls)
    #show_url()
        


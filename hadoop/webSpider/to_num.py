import csv


books = dict()
users = dict()
i=100
j=20000
k = 0
with open("user_item_pref.csv", encoding='utf-8') as infile:
    with open("user_item_pref_allnum1.csv",'w', encoding='utf-8') as outfile1 :
        with open("user_item_pref_allnum.csv",'w', encoding='utf-8') as outfile2 :
            reader = csv.reader(infile)
            #writer = csv.writer(outfile)
            for row in reader :
                
                if row[0] in users:
                    pass
                else :
                    users[row[0]] = i
                    i = i+1

                if row[1] in books:
                    pass
                else:
                    books[row[1]] = j
                    j = j+1
                
                outfile1.write(str(users[row[0]])+','+str(books[row[1]])+','+row[2]+'\n')
                if k%4!=0:
                    outfile2.write(str(users[row[0]])+','+str(books[row[1]])+','+row[2]+'\n')
                k = k+1
                #row[1]+="reviews"
                #writer.writerow([row[1],])
                #print(row)



    
            

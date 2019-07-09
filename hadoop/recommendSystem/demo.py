#-*-coding:utf-8 -*-
import math
import numpy as np
import random 
#进行5折交叉验证，计算平均准确率和召回率

class ItemBasedCF:  
    def __init__(self,data_file):  
        self.data_file = data_file 

    #读取文件
    def splitData(self,k,M=5,seed=1):
        self.train_file = []
        self.test_file = []
        random.seed(seed)
        for line in open(self.data_file,encoding='gbk'):
            #print(line)

            if random.randint(0,M)==k:
                self.test_file.append(line)
            else:
                self.train_file.append(line)

    def getfile(self):
        self.train_file = []
        for line in open(self.data_file,encoding='gbk'):
            #print(line)
            self.train_file.append(line)

    def readData(self,file):  
        #读取列表，并生成用户-物品的评分表 
        self.data_dict = dict()     #用户-物品的评分表  
        for line in file:
            tmp = line.strip().split("\t")
            #print(tmp)
            if len(tmp)<3: continue
            user,score,item = tmp[:3]
            self.data_dict.setdefault(user,{})  
            self.data_dict[user][item] = int(float(score)) 
        return self.data_dict
    
    #计算相识度矩阵
    def ItemSimilarity(self):  
        C = dict()  
        N = dict()  
        for user,items in self.train.items():  
            for i in items.keys():
                #print(i)
                N.setdefault(i,0)  
                N[i] += 1  
                C.setdefault(i,{})  
                for j in items.keys():
                    #print(j)
                    if i == j : continue  
                    C[i].setdefault(j,0)  
                    #C[i][j] += 1  #基础算法
                    C[i][j] += 1/math.log(1+len(items)*1.0) #改进第一点

        #print ('N:',N)
        #print ('C:',C)
        for key in N:
            print(key,N[key])
            break

        #计算相似度矩阵  
        self.W = dict()  
        self.W_max = dict() #记录每一列的最大值
        for i,related_items in C.items():  
            self.W.setdefault(i,{})  

            for j,cij in related_items.items(): 
                self.W_max.setdefault(j,0.0)#
                self.W[i][j] = cij / (math.sqrt(N[i] * N[j]))  
                if self.W[i][j]>self.W_max[j]:#
                    self.W_max[j]=self.W[i][j] #记录第j列的最大值，按列归一化
        #print('W:',self.W)
        for i,related_items in C.items():  #
            for j,cij in related_items.items(): #
                self.W[i][j]=self.W[i][j] / self.W_max[j] #

        #print ('W_max:',self.W_max)
        #for k,v in self.W.items():
        #    print (k+':'+str(v))

        return self.W  


    #给用户user推荐  
    def Recommend(self,user,K=3,N=10):  
        rank = dict() #记录user的推荐物品（没有历史行为的物品）和兴趣程度
        action_item = self.train[user]     #用户user购买的物品和兴趣评分r_ui  
        for item,score in action_item.items():  
            for j,wj in sorted(self.W[item].items(),key=lambda x:x[1],reverse=True)[0:K]:  #使用与物品item最相似的K个物品进行计算
                if j in action_item.keys():  #如果物品j已经购买过，则不进行推荐
                    continue  
                rank.setdefault(j,0)  
                rank[j] += score * wj  #如果物品j没有购买过，则累计物品j与item的相似度*兴趣评分，作为user对物品j的兴趣程度
        return dict(sorted(rank.items(),key=lambda x:x[1],reverse=True)[0:N]) 
    

#声明一个ItemBased推荐的对象      
#uid_score_bid='/home/lady/tmp/liushuang/1.9Item-basedCF/data/buy_user_spu.1210_0109'
#uid_score_bid = '2382.csv'
uid_score_bid = '123.txt'    
Item = ItemBasedCF(uid_score_bid)#读取数据集
#Item.splitData(k,M,seed=1)
Item.getfile()
Item.train=Item.readData(Item.train_file)
Item.ItemSimilarity() #计算物品相似度矩阵 
'''
M=5
pre_lst=[]
rec_lst=[]
for k in range(M): #进行5次交叉验证
    Item.splitData(k,M,seed=1)
    Item.train=Item.readData(Item.train_file)
    Item.test=Item.readData(Item.test_file) 

    Item.ItemSimilarity() #计算物品相似度矩阵 
    recommedDic = dict()
    hit = 0
    n_pre = 0
    n_rec = 0
    print('训练集数量',len(Item.train))
    print('测试集数量',len(Item.test))

    for user in  Item.train.keys():
        #print(user)
        recommedDic[user] = Item.Recommend(user) #对于训练user生成推荐列表
        n_pre+=len(recommedDic[user])
        rec_item=set()
        for item in recommedDic[user]:
            rec_item.add(item)
        #测试user真实购买的商品
        buy_item=set()
        if user not in Item.test: continue
        for item in Item.test[user].keys():
            buy_item.add(item)
        #print(rec_item,buy_item)
        hit += len(rec_item & buy_item)
    for user in Item.test:
        n_rec += len(Item.test[user])
    pre = hit/(1.0*n_pre)
    rec = hit/(1.0*n_rec)
    pre_lst.append(pre)
    rec_lst.append(rec)
    print(k,' hit:',hit,'n_pre:',n_pre,'n_rec;',n_rec)
print(pre_lst,'平均：',np.mean(pre_lst))
print(rec_lst,'平均：',np.mean(rec_lst))
'''

result = Item.Recommend('菠菜')

print(result)

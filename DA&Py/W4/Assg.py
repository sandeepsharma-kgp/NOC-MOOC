def multpoly(p1,p2):
    l=[]
    d=dict()
    import operator


    for i in p1:
        for j in p2:
            x=i[0]*j[0] 
            y=i[1]+j[1]
            l.append((x,y))
    for i in l:
        d[i[1]]=0
    for i in l:
        d[i[1]]+=i[0]
    l=[(y,x) for x,y in d.items() if y!=0]
    
    l.sort(key=operator.itemgetter(1),reverse=True)
    return l

def addpoly(p1,p2):
    d=dict()
    import operator

    for i in p1:
        d[i[1]]=0
    for i in p2:
        d[i[1]]=0
    for i in p1:
        d[i[1]]+=i[0]
    for i in p2:
        d[i[1]]+=i[0]

    l=[(y,x) for x,y in d.items() if y!=0]
    
    l.sort(key=operator.itemgetter(1),reverse=True)
    d.clear()
    return l

def orangecap(d):
    x=set()
    for i in d:
        for j in d[i]:
            x.add(j)
            
    p=dict.fromkeys(x, 0)

    for i in d:
        for j in d[i]:
            p[j]+=d[i][j]   
    
    max=0
    for i,j in p.items():
        if j>max:
            max=j
            score=j
            player=i

    return("(\'"+player+"', "+str(score)+")")
    

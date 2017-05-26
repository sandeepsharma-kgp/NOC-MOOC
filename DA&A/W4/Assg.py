k = [int(x) for x in raw_input().split()]
a=[]
for i in range(k[0]):
    a.append([int(x) for x in raw_input().split()])


vis=[]
dis=[]
x=0
count=0
for i in range(k[0]):
    x+=a[i][1]
    if a[i][2]>count:
        count=a[i][2]
  
for i in range(count):
    vis.append(False)
    dis.append(x+1)


dis[0]=0
##print (vis)
l=[]

##def dist(s):
##    b=0
##    min=1000
##    for i in a:
##        if i[0]-1==s and vis[i[2]-1]==False:
##            print("vertex: " ,i[0],"to",i[2])
##            if i[1]<=min:
##                min=i[1]
##                b=i[2]-1
##
##        elif i[2]-1==s and vis[i[0]-1]==False:
##            print("vertex: " ,i[2],"to",i[0])
##            if i[1]<=min:
##                min=i[1]
##                b=i[0]-1
##                #print ("vertex: ",s,min,b)
##    vis[b]=True
##    vis[s]=True
##    return(b+1,min)
##
##for i in a:
##    print (i)
###if vis[i[0]-1]== False:
##    g=dist(i[0]-1)
##    print ("for: ",i[0],g)
##    print (vis)
###if vis[i[2]-1]==False:
##    g=dist(i[2]-1)
##    print ("for: ",i[2],g)
##    print (vis)
##
##        
##
##print (dis)
minm=1000
dest=k[2]
flag=1
short=x+1
##for i in range(count):
u=0
if vis[u]==False and dis[u]<1000:
##  print("Making True: ",u+1)
    vis[u]=True
    for j in a:
        v=j[2]-1
        w=j[1]
        if vis[v]==False and dis[v]>dis[u]+w:
            print("Connecting1: ",u+1,v+1)
            dis[v]=dis[u]+w
            if flag and v==dest-1:
                short=dis[v]

##    for j in a:
##        v=j[0]-1
##        w=j[1]
##        if vis[v]==False and dis[v]>dis[u]+w:
##            print("Connecting2: ",u+1,v+1)
##            dis[v]=dis[u]+w
##            if flag and v==dest-1:
##                short=dis[v]

            

print (vis)
print (dis)
if (short<x+1):
    print("YES")
    print(short)
else:
    print("NO")

            
        

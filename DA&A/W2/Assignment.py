k = [int(x) for x in raw_input().split()]
a = [int(x) for x in raw_input().split()]
b = [int(x) for x in raw_input().split()]
c = [int(x) for x in raw_input().split()]
d = [int(x) for x in raw_input().split()]
e = [int(x) for x in raw_input().split()]


f=a+b+c+d+e

g=set(f)

g=list(g)

h=dict.fromkeys(g, 0)
for i in range(0,len(a)):
    for j in range(0,len(g)):
        if a[i]==g[j]:
            h[g[j]]+=1       

for i in range(0,len(b)):
    for j in range(0,len(g)):
        if b[i]==g[j]:
            h[g[j]]+=1     
            
for i in range(0,len(c)):
    for j in range(0,len(g)):
        if c[i]==g[j]:
            h[g[j]]+=1
            
for i in range(0,len(d)):
    for j in range(0,len(g)):
        if d[i]==g[j]:
            h[g[j]]+=1

for i in range(0,len(e)):
    for j in range(0,len(g)):
        if e[i]==g[j]:
            h[g[j]]+=1

result=[]
for i in h:
    if h[i]>=3:
        result.append(i)

print (result)

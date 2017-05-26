def intreverse(n):
    m=0
    i=1
    while n:
        m=m*10+(n%10)
        n=n // 10
    return m

def matched(m):
    n=0
    j=0
    k=0
    l=[]
    for i in range(0,len(m)):
        if m[i]=='(' or m[i]==')':
            l.append(m[i])         
      
    for i in range(0,len(l)):
        if l[i]=='(':
            n+=1
    i=0
    while n and i<len(l):
        if(l[i]==')' and i):
            del l[i]
            del l[i-1]
            i=0
            n-=1
        else:
            i+=1
    return(not bool(len(l)))
       
def isprime(p):
    if p==1 or p<0:
        return False
    for i in range(2,int(p**0.5)+1):
        if p%i==0:
            return False
    return True
    
def sumprimes(a):
    n=0
    for x in a:
        if isprime(x):
            n+=x
    return n

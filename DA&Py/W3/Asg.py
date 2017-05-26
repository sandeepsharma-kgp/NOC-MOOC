def matmult(X,Y):
    c=[[0] * len(X) for i in range(len(Y[0]))]
    for i in range(len(X)):
        for j in range(len(Y[0])):
            for k in range(len(Y)):
                c[i][j] += X[i][k] * Y[k][j]
            
    return c

def descending(s):
    flag=0
    for end in range(0,len(s)):
        pos=end
        while pos>0 and s[pos]>s[pos-1]:
            (s[pos],s[pos-1])=(s[pos-1],s[pos])
            flag=1
            pos=pos-1          
    return (not bool(flag))

def alternating(s):
    l=0
    if len(s)<=1:
        return True
    
    if s[0]>s[1] :
        l=1
    elif s[1]>s[0]:
        l=0
    else:
        return False
    
    
    for i in range(1,len(s)-1):
        if s[i]>s[i+1] :
                if l==0:
                    l=1
                    continue
                else:
                    return False
        elif s[i]<s[i+1]:
                if l==1:
                    l=0
                    continue
                else:
                    return False

        else:
                return False
    return True

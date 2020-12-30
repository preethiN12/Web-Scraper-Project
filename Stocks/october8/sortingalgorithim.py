index = [15,23,45,12,4,78,23,56,89,34,21,46,100,32,666,1234,43,4235,2324,7865, 243652, 2626, 6, 2, 3, 1, 23,0]

def listsort(index):
    cpass = 0
    while True:
        ipass = 0
        i=0
        badcounter=0
        while i < len(index)-1:
            if index[i]>index[i+1]:
                index[i]+=index[i+1]
                index[i+1]=index[i]-index[i+1]
                index[i]-=index[i+1]
                badcounter+=1
                ipass+=1
            i+=1
        if badcounter==0:
            print(index)
            break


def bruteforcesearch(search):
    exists=False
    for x in index:
        if x == search:
            print("we have some of that")
            exists=True
    if exists==False:
        print("no")

def binarysearch():
    print()

listsort(index)
bruteforcesearch(int(input("enter a number:")))

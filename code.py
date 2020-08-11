print("bubble sort")
#introducing code refaactoring
#chaning bubble sort algorithm 
#with quick sort
arr=[3,1,5,1,11,1]
n=6
for i in range(n):
	for j in range(0,n-i-1):
		if arr[j] > arr[j+1] :
			arr[j], arr[j+1] = arr[j+1], arr[j]
#the above loops 
#and condition statements 
#should change

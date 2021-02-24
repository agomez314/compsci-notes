def recursive_sum(arr, sum, idx):
	if idx == len(arr):
		return sum;
	return recursive_sum(arr, sum+arr[idx], idx+1)

print recursive_sum([1,2,3,4,5,6,7,8,9,10],0,0) 

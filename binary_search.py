def binary_search(list, item):
	low = 0
	high = len(list)-1
	while low <= high:
		mid = (high + low) // 2
		guess = list[mid]
		if guess == item:
			return mid
		if guess > item:
			high = mid-1
		else:
			low = mid+1
	return None

my_list = [1,3,5,7,9]
# print binary_search(my_list, 3)
# print binary_search(my_list, -1)
   

def recursive_binary_search(list, item, low, high):	
	mid = (high + low) // 2
	guess = list[mid]
	if low == high:	
		return None
	if item == guess:
		return mid
	if guess > item:
		return recursive_binary_search(list, item, low, mid-1)
	else:
		return recursive_binary_search(list, item, mid+1, high)

print recursive_binary_search(my_list,3, 0, len(my_list)-1)
print recursive_binary_search(my_list,-1, 0, len(my_list)-1)

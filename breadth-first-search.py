from collections import deque

def person_is_seller(person):
	return person[-1] == 'm'  

def search(name, graph):
	search_queue = deque()
	search_queue += graph[name]
	searched = []
	while search_queue:
		person = search_queue.pop()
		if not person in searched:
			if person_is_seller(person):
				print person + " is a mango seller!"
				return True
			else:	
				search_queue += graph[person]
				searched += person
	return False

graph = {}
graph["you"] = ["alice", "bob", "claire"]
graph["bob"] = ["anuj", "peggy"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "johnny"]
graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["johnny"] = []
 
search("you", graph)

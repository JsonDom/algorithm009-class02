学习笔记

# 深度优先搜索、广度优先搜索的实现和特性

## 遍历搜索

在树（图/状态集）中寻找特点结点



## 搜索-遍历

- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限
  - 深度优先：depth first search
  - 广度优先：breadth first search
  - 优先级优先：自定义搜索，更适用于现实中的业务场景，一般称为启发式搜索

# DFS代码模板

## 递归写法

```python
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

## 非递归写法

```python
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 
	# other processing work 
	...
```

## BFS代码模板

```python
# Python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```

# 贪心的实现和特性

## 贪心算法 Greedy

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有利)的选择，从而希望导致结果是全局最好或最优的算法。

贪心算法与动态规划的不同在于他对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

- 贪心：当下做局部最优判断
- 回溯：能够回退
- 动态规划：最优判断 + 回退



贪心算法：只适用于存在整除关系，因为每次都用最大的来解决



## 适用贪心算法的场景

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解成为最优子结构。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。





# 二分查找的实现、特性

## 二分查找的前提

1。目标函数单调性(单调递增或递减)

2.存在上下界(bounded)

3.能够通过索引访问(index accessible)

## 代码模块

```python
# Python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```


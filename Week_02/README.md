学习笔记

# 哈希表、映射、集合的实现与特性

## 1.Hash table

哈希表(Hash table)，也叫散列表，是根据关键码值（Key value）而直接进行访问的数据。

它通过把关键码值映射到表中一个位置来访问记录，以加速查找的速度。

这个映射函数叫作散列函数（Hash Function），存放记录的数组叫作哈希表（或散列表）。

### 1.1.工程实践

- 电话号码簿
- 用户信息表
- 缓存（LRU Cache）
- 键值对存储（Redis）

1.2.Hash Function

![image-20200526090207693](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200526090207693.png)



Hash 碰撞

![image-20200526090302663](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200526090302663.png)

对于不同的要存储的数据，经过哈希函数之后会得到一个相同的值，如图中例子，都是429，那么对应的下标都是在9这个位置，9这个位置要存多个元素，这是需要在增加一个维度，这个位置不止存一个数，即在这个位置存储一个链表，此方法成为拉链式解决冲突法。

当没有冲突的情况下，一个数值进来，通过哈希获得对应下标的值，整个操作是O(1)，即O(1)可以查询到它的位置。但当很多个元素累计在同一位置，此时它的查询事件就要遍历链表，操作退化为O(n)。一般情况下如果hash设计的好的话，碰撞的概率会很小，所以一般为O(n)

### 1.2.完整结构

![image-20200526091150157](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200526091150157.png)



### 1.3.复杂度分析

![image-20200526091659789](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200526091659789.png)

HashTable 查询、添加、删除的时间复杂度度都是O(1)

最坏情况：哈希函数选的非常不好或者哈希表的整个size太小，导致经常发生冲突，一旦发生冲突就会退化成一个链表，复杂度也退化成O(n)

### 1.4.Java code

#### Map：key-value对，key不重复

- new HashMap() / new TreeMap()
- map.set(key, value)
- map.get(key)
- map.has(key)
- map.size()
- map.clear()

#### Set:   不重复元素的集合

- new HashSet() / new TreeSet()
- set.add(value)
- set.delete(value)
- set.hash(value)

### 1.5.源码

#### Interface Set<E>

- 可实现类：AbastractSet,ConcurrentHashMap,KeySetView,HashSet,ConcurrentSkipListSet（跳表），TreeSet（用的不是哈希表实现，而是二叉搜索树(红黑树)来实现）等

#### HashSet

底层就是hashmap，对应方法add就是map的put方法



# 树、二叉树、二叉搜索树的实现和特性

## 1.概念

### 1.1.树

![image-20200530161600705](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200530161600705.png)

### 1.2.二叉树

![image-20200530161638433](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200530161638433.png)

### 1.3.如果形成环的话，则称之为图Graph

![image-20200530161830505](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200530161830505.png)



### 1.4.Linked List是特殊化的Tree，Tree是特殊化的Graph



## 2.二叉树遍历

#### 2.1.*前序  (Pre-order)：根-左-右*

#### 2.2.*中序  (In-order)：左-根-右*

#### 2.3.*后序  (Post-order)：左-右-根*

#### 2.4.实例代码：

public class TreeNode{

​		public int val;

​		public TreeNode left,right;

​		public TreeNode(int val){

​				this.val = val;

​				this.left = null;

​				this.right = null;

​		}

}



## 3.二叉搜索树

### 3.1.定义

二叉搜索树，也称二叉排序树，有序二叉树、排序二叉树，是指一棵空树或者具有下列性质的二叉树：

#### 3.1.1.左子树上所有结点的值均小于它的根结点的值；

#### 3.1.2.右子树上所有结点的值均大于它的根结点的值；

#### 3.1.3.以此类推：左、右子树也分别为二叉查找树。（这就是 重复性！）

中序遍历：升序排列



## 4.二叉搜索树常见操作

二叉搜索树CRUD的复杂度都是O(log n)

https://visualgo.net/zh/bst

注：删除根结点时，需要把别的结点的数拿来充当该结点，一般取右子树最左边的子节点或者左子树最右边的子节点

当二叉搜索树退化成一根棍子时，实际成为了链表，所有的操作复杂度成了O(n)

![image-20200530164707640](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200530164707640.png)

## 思考：为什么树的面试题解法一般是递归？

因为要访问树的结点，经常比较好的一种方式就是对它的左/右结点再调相同的遍历函数





# 堆和二叉堆、图

## 1.堆和二叉树的实现和特性

### 1.1.堆 Heap

Heap：可以迅速找到一堆数中的最大或者最小值的数据结构

将根节点最大的堆叫作大顶堆或大根堆，根节点最小的堆叫作小顶堆或小根堆。

常见的堆有二叉堆(二项堆)、斐波那契堆(基于多叉树)等

假设是大顶堆，则常见操作(API):

find-max:             O(1)

delete-max:         O(logN)

insert(create):     O(logN) or O(1)(利用严格的斐波那契堆) Strict Fibonacci

![image-20200530202908427](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200530202908427.png)

维基百科：https://en.wikipedia.org/wiki/Heap_(data_structure)



### 1.2.二叉堆性质

注：二叉堆实现相对容易，但是它的时间复杂度勉强及格，如上图显示为黄色

通过**完全二叉树**来实现（注意：不是二叉搜索树）；

二叉堆（大顶）它满足下列性质：

- 是一棵完全树
- 树中任意节点的值总是>=其子节点的值；(根节点是最大节点)

### 1.3.二叉堆实现细节

#### 1.3.1.二叉堆一般都通过“数组”来实现

#### 1.3.2.假设“第一个元素”在数组中的索引为0的话，则父节点和子节点的位置关系如下：

- 根节点(顶堆元素)是：a[0]; 

- 索引为i的左孩子的索引是 (2*i + 1);
- 索引为i的右孩子的索引是 (2*i + 2);
- 索引为i的父结点的索引是 floor((i - 1) / 2);

![image-20200530204016677](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200530204016677.png)

### 1.4.Insert 插入操作

复杂度O(logN)

#### 1.4.1.新元素一律先插入到堆的尾部

#### 1.4.2.依次向上调整整个堆的结构(一直到根即可)

HeapifyUp

![image-20200531162619759](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531162619759.png)



![image-20200531162641450](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531162641450.png)

![image-20200531162706107](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531162706107.png)



### 1.5.Delete Max 删除堆顶操作

复杂度 O(logN)

#### 1.5.1.将堆尾元素替换到顶部（即对顶呗替代删除掉）

#### 1.5.2.依次从根部乡下调整整个堆的结构（一直到队尾即可）

HeapifyDown

![image-20200531170557161](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531170557161.png)



### 1.6.注意：二叉堆是堆(优先队列priority_queue)的一种常见且简单的实现；但是并不是最优的实现。



## 2.图

### 2.1.图的属性和分类

![image-20200531173333915](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531173333915.png)

#### 2.1.1.图的属性

- Graph(V，E)

- V - vertex：点

  1.度 - 入度和出度

  2.点与点之间：连通与否



- E - edge：边

  1.有向和无向（单行线）

  2.权重（边长）

#### 2.1.2.图的表示和分类

- 无向无权图

  ![image-20200531173851585](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531173851585.png)

- 有向无权图

  ![image-20200531174000199](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531174000199.png)

- 无向有权图

  ![image-20200531174035320](C:\Users\woair\AppData\Roaming\Typora\typora-user-images\image-20200531174035320.png)

- 有向有权图



### 2.2.基于图相关的算法

#### 2.2.1.DFS代码 - 递归写法

visited = set{} #和树中的DFS最大区别

def dfs(node, visited):

​	if node in visited: # terminator

​	#already visited

​	return

​	visited.add(node)

​	#process current node here.

​	...

​	for next_node in node.children();

​		if not next_node in visited:

​			dfs(next_node,visited)



#### 2.2.2.BFS代码

def BFS(graph, start, end):

​	queue = []

​	queue.append([start])

​	visited = set() #和树中的BFS的最大区别

​	while queue:

​		node = queue.pop()

​		visited.add(node)



​		process(node)

​		nodes = generate_related_nodes(node)

​		queue.push(nodes)
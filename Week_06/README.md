学习笔记

# 动态规划

## 回顾分治、递归和回溯

### 递归代码模板

```java
public void recur(int level,int param){
	//terminator
	if(level > MAX_LEVEL){
		//process result
		return;
	}
	
	//process current logic
	process(level,param);
	
	//drill down
	recur(level:level + 1,newParam);
	
	//restore current status
}
```

### 分治代码模板

```python
def divide_conquer(problem,param1,param2,...):
	#recursion terminator
	if problem is None:
		print_result
		return
		
	#prepare data
	data = prepare_data(problem)
	subproblems = split_problem(problem,data)
	
	#conquer subproblems
	subresult1 = self.divide_conquer(subproblems[0],p1,...)
	subresult2 = self.divide_conquer(subproblems[1],p1,...)
	subresult3 = self.divide_conquer(subproblems[2],p1,...)
    ...
    
    #process and generate the final result
    result = process_result(subresult1,subresult2,subresult3,...)
    
    #revert the current level status
```

### 思路：

1. 找到最近最简方法，将其拆解成可重复解决的问题
2. 数学归纳法思维（抵制人肉递归的诱惑）

### 本质：寻找重复性  ->  计算机指令集



## 动态规划Dynamic Programming

分治 + 最优子结构

### 关键点：

动态规划 和 递归或者分治没有根本上的区别（关键看有无最优的子结构）

共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解

## 实例

#### 斐波拉契数列

自顶向下

```java
int fib(int n,int [] memo){
	if(n <= 1){
		return n;
	}
	if(memo[n] == 0){
		memo[n] = fib(n - 1) + fib(n - 2);
	}
	return memo[n];
}
```

自底向上

```python
F[n] = F[n-1] + F[n-2]
a[0] = 0, a[1] = 1;
for(int i=2;i<=n;++i){
	a[i] = a[i-1] + a[i-2];
}
```

#### 路径计数

```python
if a[i,j] = '空地':
	opt[i,j] = opt[i+1,j] +opt[i,j+1]
else:
	opt[i,j] = 0
```

## 动态规划关键点

1.最优子结构

​	opt[n] = best_of(opt[n-1],opt[n-2],...)

2.存储中间状态：opt[i]

3.递推公式（美其名曰：状态转移方程或者DP方程）

Fib: opt[i] = opt[n-1] + opt[n-2]

二维路径： opt[i,j] = opt[i+1] [j] + opt[i] [j+1] (且判断a[i,j]是否空地)
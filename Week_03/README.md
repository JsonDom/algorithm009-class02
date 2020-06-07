# 泛型递归、树的递归

## 前序知识回顾：

### 树的面试题解法一般都是*递归*

1.节点的定义

2.重复性（自相似性）



## 递归 Recursion

### 递归 - 循环

通过函数体来进行的循环

例子：

1.从前有个山

2.山里有个庙

3.庙里有个和尚讲故事

4.返回1

### 盗梦空间

- 向下进入到不同的梦境中；向上又回到原来一层

- 通过声音同步到上一层（即用参数来进行函数不同层之间的传递变量）

- 每一层的环境和周围的人都是一份拷贝、

  主角等人穿越到不同层级的梦境（发生和携带变化）

  主角团类似于函数中的参数

### 递归特性

1. 递归终结条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层

### 思维要点

1. 不要人肉递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

## 实战

#### 爬楼梯 70.

找最近重复子问题

1：1

2：2

3：f(1) + f(2)，mutual exclusive, complete exhaustive    相互互斥，且包含所有可能性

f(n) = f(n-1) + f(n-2) ：Fibonacci



## 递归模块

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
	recur(level: level+1,newParam);	
	
	//restore currentn stauts
}
```


package main

import (
	"fmt"
	"time"
)

func fib(n int) int {
	if n == 0 || n == 1 {
		return n
	}

	return fib(n-1) + fib(n-2)
}

func fibOptimized(n int) int {
	return fibOptimizedInternal(n, make(map[int]int))
}

func fibOptimizedInternal(n int, m map[int]int) int {
	if n == 0 || n == 1 {
		return n
	}

	var n1, n2 int

	if m[n-1] != 0 {
		n1 = m[n-1]
	} else {
		n1 = fibOptimizedInternal(n-1, m)
	}

	if m[n-2] != 0 {
		n2 = m[n-2]
	} else {
		n2 = fibOptimizedInternal(n-2, m)
	}

	return n1 + n2
}

func main() {
	n := 30

	startOptmized := time.Now()
	fmt.Printf("fib optmized %d: %d\n", n, fibOptimized(n))
	endOptmized := time.Now()
	fmt.Printf("optimized took: %v\n", endOptmized.Sub(startOptmized).Milliseconds())

	fmt.Println("========")

	startUnoptmized := time.Now()
	fmt.Printf("fib unoptmized %d: %d\n", n, fib(n))
	endUnoptmized := time.Now()
	fmt.Printf("unoptimized took: %v\n", endUnoptmized.Sub(startUnoptmized).Milliseconds())
}

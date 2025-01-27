package fibonacci

import (
	"fmt"
	"testing"
	"time"
)

func TestFib_Gives5thFibonacci(t *testing.T) {
	n := 10
	fmt.Printf("fib of %d: %d\n", n, Fib(n))
}

func TestFibOptimized_Gives5thFibonacci(t *testing.T) {
	n := 10
	fmt.Printf("fib optmized of %d: %d\n", n, FibOptimized(n))
}

func TestComparison(t *testing.T) {
	n := 30

	startOptimized := time.Now()
	fmt.Printf("fib optmized %d: %d\n", n, FibOptimized(n))
	endOptimized := time.Now()
	fibOptimizedMilli := endOptimized.Sub(startOptimized).Milliseconds()
	fmt.Printf("optimized took: %v\n", fibOptimizedMilli)

	fmt.Println("========")

	startUnoptimized := time.Now()
	fmt.Printf("fib unoptmized %d: %d\n", n, Fib(n))
	endUnoptimized := time.Now()
	fibUnoptimizedMilli := endUnoptimized.Sub(startUnoptimized).Milliseconds()
	fmt.Printf("unoptimized took: %v\n", fibUnoptimizedMilli)

	fmt.Println("========")
	fmt.Printf("optmized is faster by %d milliseconds\n", fibUnoptimizedMilli-fibOptimizedMilli)
}

package fibonacci

import (
	"fmt"
	"testing"
	"time"

	"github.com/stretchr/testify/assert"
)

func TestFib_Gives10thFibonacci(t *testing.T) {
	n := 10
	res := Fib(n)
	fmt.Printf("fib of %d: %d\n", n, Fib(n))

	assert.Equal(t, 55, res)
}

func TestFibOptimized_Gives10thFibonacci(t *testing.T) {
	n := 10
	res := FibOptimized(n)
	fmt.Printf("fib optmized of %d: %d\n", n, res)

	assert.Equal(t, 55, res)
}

func runComparisonTest(t *testing.T, n int) {
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

	assert.Less(t, fibOptimizedMilli, fibUnoptimizedMilli)
}

func TestComparison_30thFibonacci(t *testing.T) {
	runComparisonTest(t, 30)
}

func TestComparison_40thFibonacci(t *testing.T) {
	runComparisonTest(t, 40)
}

package fibonacci

import (
	"fmt"
	"math/big"
	"testing"
	"time"

	"github.com/stretchr/testify/assert"
)

func TestFib_Gives10thFibonacci(t *testing.T) {
	n := uint64(10)
	res := Fib(n)
	fmt.Printf("fib of %d: %d\n", n, Fib(n))

	assert.Equal(t, big.NewInt(55), res)
}

func TestFibOptimized_Gives10thFibonacci(t *testing.T) {
	n := uint64(10)
	res := FibOptimized(n)
	fmt.Printf("fib optmized of %d: %d\n", n, res)

	assert.Equal(t, big.NewInt(55), res)
}

func TestFibOptimized_Gives500thFibonacci(t *testing.T) {
	n := uint64(500)
	res := FibOptimized(n)
	fmt.Printf("fib optimized of %d: %s\n", n, res.String())

	expected, _ := new(big.Int).SetString("139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125", 10)
	assert.Equal(t, expected, res)
}

func TestFibOptimized_Gives1000thFibonacci(t *testing.T) {
	n := uint64(1000)
	res := FibOptimized(n)
	fmt.Printf("fib optimized of %d: %s\n", n, res.String())

	expected, _ := new(big.Int).SetString("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875", 10)
	assert.Equal(t, expected, res)
}

func runComparisonTest(t *testing.T, n uint64) {
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

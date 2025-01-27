package fibonacci

import "math/big"

func Fib(n uint64) *big.Int {
	if n == 0 || n == 1 {
		return big.NewInt(int64(n))
	}

	return new(big.Int).Add(Fib(n-1), Fib(n-2))
}

func FibOptimized(n uint64) *big.Int {
	return fibOptimizedInternal(n, make(map[uint64]*big.Int))
}

func fibOptimizedInternal(n uint64, m map[uint64]*big.Int) *big.Int {
	if n == 0 || n == 1 {
		return big.NewInt(int64(n))
	}

	if val, exists := m[n]; exists {
		return val
	}

	m[n] = new(big.Int).Add(fibOptimizedInternal(n-1, m), fibOptimizedInternal(n-2, m))
	return m[n]
}

package fibonacci

func Fib(n int) int {
	if n == 0 || n == 1 {
		return n
	}

	return Fib(n-1) + Fib(n-2)
}

func FibOptimized(n int) int {
	return fibOptimizedInternal(n, make(map[int]int))
}

func fibOptimizedInternal(n int, m map[int]int) int {
	if n == 0 || n == 1 {
		return n
	}

	if val, exists := m[n]; exists {
		return val
	}

	m[n] = fibOptimizedInternal(n-1, m) + fibOptimizedInternal(n-2, m)
	return m[n]
}

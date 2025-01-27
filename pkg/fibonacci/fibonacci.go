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

	var n1 int
	if m[n-1] != 0 {
		n1 = m[n-1]
	} else {
		n1 = fibOptimizedInternal(n-1, m)
		m[n-1] = n1
	}

	var n2 int
	if m[n-2] != 0 {
		n2 = m[n-2]
	} else {
		n2 = fibOptimizedInternal(n-2, m)
		m[n-1] = n2
	}

	return n1 + n2
}

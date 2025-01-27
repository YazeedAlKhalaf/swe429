package gcd

func Euclid(m, n int) int {
	if n == 0 {
		return m
	}

	r := m % n
	return Euclid(n, r)
}

func ConsecutiveIntCheck(m, n int) int {
	t := m
	if n < t {
		t = n
	}

	for t > 0 {
		if m%t == 0 {
			if n%t == 0 {
				return t
			}
		}

		t--
	}

	return -1
}

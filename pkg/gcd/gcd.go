package gcd

import (
	"fmt"
)

type GCD struct {
}

func (g GCD) Euclid(m, n int) int {
	if n == 0 {
		return m
	}

	r := m % n
	return g.Euclid(n, r)
}

func (g GCD) ConsecutiveIntCheck(m, n int) int {
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

func main() {
	g := GCD{}

	fmt.Printf("Euclide: %d\n", g.Euclid(60, 24))
	fmt.Printf("ConsecutiveIntCheck: %d\n", g.ConsecutiveIntCheck(60, 24))
}

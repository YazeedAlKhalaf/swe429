package gcd

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

// g := GCD{}

// 	fmt.Printf("Euclide: %d\n", g.Euclid(60, 24))
// 	fmt.Printf("ConsecutiveIntCheck: %d\n", g.ConsecutiveIntCheck(60, 24))

func TestEuclid_60And24(t *testing.T) {
	res := Euclid(60, 24)
	assert.Equal(t, 12, res)
}

func TestConsecutiveIntCheck_60And24(t *testing.T) {
	res := ConsecutiveIntCheck(60, 24)
	assert.Equal(t, 12, res)
}

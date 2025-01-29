package sumof

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestSumOfEven_10(t *testing.T) {
	assert.Equal(t, 30, SumOfEven(10))
}

func TestSumOfEven_11(t *testing.T) {
	assert.Equal(t, 30, SumOfEven(11))
}

func TestSumOfOdd_10(t *testing.T) {
	assert.Equal(t, 25, SumOfOdd(10))
}

func TestSumOfOdd_11(t *testing.T) {
	assert.Equal(t, 36, SumOfOdd(11))
}

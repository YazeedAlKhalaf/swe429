package sumarray

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestSumArrayInt_SumIs62(t *testing.T) {
	arr := []int{5, 6, 7, 10, 34}

	assert.Equal(t, 5+6+7+10+34, SumArrayInt(arr))

}

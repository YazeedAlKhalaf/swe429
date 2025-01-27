package sumarray

func SumArrayInt(arr []int) int {
	return sumArrayIntInternal(arr, len(arr))
}

func sumArrayIntInternal(arr []int, n int) int {
	if n == 0 {
		return 0
	}

	return arr[n-1] + sumArrayIntInternal(arr, n-1)
}

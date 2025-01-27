package main

import "fmt"

func sumArrayInt(arr []int) int {
	return sumArrayIntInternal(arr, len(arr))
}

func sumArrayIntInternal(arr []int, n int) int {
	if n == 0 {
		return 0
	}

	return arr[n-1] + sumArrayIntInternal(arr, n-1)
}

func main() {
	arr := []int{5, 6, 7, 10, 34}

	fmt.Printf("array summation: %d\n", sumArrayInt(arr))
}

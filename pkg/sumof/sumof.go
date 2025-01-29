package sumof

func SumOfEven(n int) int {
	if n == 0 {
		return 0
	}

	if n%2 == 0 {
		return n + SumOfEven(n-2)
	}

	return SumOfEven(n - 1)
}

func SumOfOdd(n int) int {
	if n == 1 {
		return 1
	}

	if n%2 == 1 {
		return n + SumOfOdd(n-2)
	}

	return SumOfOdd(n - 1)

}

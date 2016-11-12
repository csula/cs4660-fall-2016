package main

import (
	"fmt"
	"os"
	"time"
)

func main() {
	board := [20][30]int{}
	for {
		mainLoop(&board)
	}
}

func mainLoop(board *[20][30]int) {
	// process and print out the time cost
	start := time.Now()
	defer debugTimeUse(start)

	var N, P int
	fmt.Scan(&N, &P)

	for i := 0; i < N; i++ {
		// X0: starting X coordinate of lightcycle (or -1)
		// Y0: starting Y coordinate of lightcycle (or -1)
		// X1: starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
		// Y1: starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
		var X0, Y0, X1, Y1 int
		fmt.Scan(&X0, &Y0, &X1, &Y1)
		board[Y1][X1] = i + 1
	}

	// 		debugBoard(board)
	time.Sleep(99 * time.Millisecond)

	fmt.Println("LEFT") // A single line with UP, DOWN, LEFT or RIGHT
}

func debugBoard(board [20][30]int) {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			fmt.Fprintf(os.Stderr, "%v", board[i][j])
		}
		fmt.Fprintln(os.Stderr)
	}
}

func debugTimeUse(t time.Time) {
	fmt.Fprintf(os.Stderr, "%v\n", time.Since(t))
}

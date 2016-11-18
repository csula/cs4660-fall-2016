package main

import (
	"fmt"
	"os"
	"time"
)

func main() {
	board := [20][30]int{}
	for {
		processTurn(&board)
	}
}

func parseInput(board *[20][30]int) (n, p, x, y int) {
	fmt.Scan(&n, &p)

	for i := 0; i < n; i++ {
		// X0: starting X coordinate of lightcycle (or -1)
		// Y0: starting Y coordinate of lightcycle (or -1)
		// X1: starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
		// Y1: starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
		var X0, Y0, X1, Y1 int
		fmt.Scan(&X0, &Y0, &X1, &Y1)
		if i == p {
			x = X1
			y = Y1
			fmt.Fprintf(os.Stderr, "%v %v\n", X1, Y1)
		}
		board[Y1][X1] = i + 1
	}

	return
}

func processTurn(board *[20][30]int) {
	// process and print out the time cost
	start := time.Now()
	defer debugTimeUse(start)

	var _, _, x, y = parseInput(board)

	var move = getPossibleMoves(*board, x, y)[0]

	fmt.Println(move) // A single line with UP, DOWN, LEFT or RIGHT
}

func getPossibleMoves(board [20][30]int, x int, y int) []string {
	var result = []string{}
	moves := [4]string{"UP", "DOWN", "LEFT", "RIGHT"}
	for i := 0; i < len(moves); i++ {
		// choose the move if the move is not a suicide move
		switch moves[i] {
		case "UP":
			if y > 0 && board[y-1][x] == 0 {
				result = append(result, "UP")
				break
			}
		case "DOWN":
			if y < len(board)-1 && board[y+1][x] == 0 {
				result = append(result, "DOWN")
				break
			}
		case "LEFT":
			if x > 0 && board[y][x-1] == 0 {
				result = append(result, "LEFT")
				break
			}
		case "RIGHT":
			if x < len(board[x])-1 && board[y][x+1] == 0 {
				result = append(result, "RIGHT")
				break
			}
		}
	}
	return result
}

func debugBoard(board [20][30]int) {
	fmt.Fprintln(os.Stderr, "Board state: ")
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			fmt.Fprintf(os.Stderr, "%v", board[i][j])
		}
		fmt.Fprintln(os.Stderr)
	}
}

func debugTimeUse(t time.Time) {
	fmt.Fprintf(os.Stderr, "Main loop time used: %v\n", computationBudget(t))
}

func computationBudget(t time.Time) int64 {
	nanoToMilli := int64(time.Millisecond) / int64(time.Nanosecond)
	now := time.Now().UnixNano() / nanoToMilli
	start := t.UnixNano() / nanoToMilli
	return now - start
}

package main

import (
    "bufio"
    "fmt"
    "os"
    "strconv"
    "strings"
)

func ReadLine(reader *bufio.Reader) string {
    line, _ := reader.ReadString('\n')
    return strings.TrimRight(line, "\n")
}

func ReadInt(reader *bufio.Reader) int {
    num, _ := strconv.Atoi(ReadLine(reader))
    return num
}

func ReadArray(reader *bufio.Reader) []int {
    line := ReadLine(reader);
    strs := strings.Split(line, " ")
    nums := make([]int, len(strs))
    for i, s := range strs {
        nums[i], _ = strconv.Atoi(s)
    }
    return nums
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    line := strings.Split(ReadLine(reader), " ")
    first := line[1]
    a := ReadArray(reader)

    cnt := make(map[int]int)
    for _, num := range a {
        cnt[num] += 1
    }
    var candy = []int{0, 0}
    for _, elem := range cnt {
        if elem <= 2 {
            candy[elem - 1] += 1
        }
    }
    ans := "Alice"
    if candy[0] == 0 {
        if candy[1] == 0 {
            ans = "Bob"
        } else if candy[1] == 1 {
            ans = first
        }
    }
    fmt.Println(ans)
}

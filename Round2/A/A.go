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
    T := ReadInt(reader)
    for casi := int(0); casi < T; casi++ {
        s := ReadLine(reader)
        a := strings.Split(s, ":")
        b := make([]string, 0, 8)
        for i, p := range a {
            if len(p) == 0 {
                if i != 0 && i != len(a) - 1 {
                    for j := len(a); j <= 8; j++ {
                        b = append(b, "0000")
                    }
                } else {
                    b = append(b, "0000")
                }
            } else {
                var num int
                fmt.Sscanf(p, "%x", &num)
                b = append(b, fmt.Sprintf("%04x", num))
            }
        }
        fmt.Println(strings.Join(b, ":"))
    }
}

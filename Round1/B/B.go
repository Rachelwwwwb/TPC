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

func Gen(a string) []int {
    n := len(a)
    var ret []int
    ret = append(ret, 1)
    for i := 1; i < n; i++ {
        if a[i] != a[i - 1] {
            ret = append(ret, 1)
        } else {
            ret[len(ret) - 1] += 1
        }
    }
    return ret
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    cas := ReadInt(reader)
    for casi := int(0); casi < cas; casi++ {
        n := ReadInt(reader)
        ra := ReadLine(reader)
        rb := ReadLine(reader)

        a := Gen(rb[: 1] + ra + rb[n - 1: ])
        b := Gen(rb[: 1] + rb + rb[n - 1: ])

        i, ans := 0, 0
        for _, t := range b {
            j := i
            for ; j < len(a) && t > 0; j++ {
                t -= a[j]
            }
            if (j - i) % 2 == 0 || t < 0 {
                ans = -1
                break
            }
            ans += (j - i) / 2
            i = j
        }
        fmt.Println(ans)
    }
}

package main

import (
    "bufio"
    "fmt"
    "os"
    "strconv"
    "strings"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)

func ReadLine() string {
    line, _ := reader.ReadString('\n')
    return strings.TrimRight(line, "\n")
}

func ReadInt() int {
    num, _ := strconv.Atoi(ReadLine())
    return num
}

var lst map[int]int

func prework() {
    lst = make(map[int]int)
    S := 0
    for i := 0; i < 9; i++ {
        S = S << 4 | i
    }

    Q, tail := make([]int, 0, 362880), 0
    lst[S] = 0
    Q = append(Q, S)
    for tail < len(Q) {
        u := Q[tail]
        tail = tail + 1
        dis := lst[u] + 1

        vs := [6]int{
            u & 0xffffff000 | (u & 0x00000000f) << 8 | (u & 0x000000ff0) >> 4,
            u & 0xfff000fff | (u & 0x00000f000) << 8 | (u & 0x000ff0000) >> 4,
            u & 0x000ffffff | (u & 0x00f000000) << 8 | (u & 0xff0000000) >> 4,
            u & 0xff0ff0ff0 | (u & 0x00000000f) << 24 | (u & 0x00f00f000) >> 12,
            u & 0xf0ff0ff0f | (u & 0x0000000f0) << 24 | (u & 0x0f00f0000) >> 12,
            u & 0x0ff0ff0ff | (u & 0x000000f00) << 24 | (u & 0xf00f00000) >> 12,
        }
        for _, v := range vs {
            _, in := lst[v]
            if !in {
                lst[v] = dis
                Q = append(Q, v)
            }
        }
    }
}

func GetPerm() []int {
    s := ""
    for i := 0; i < 3; i++ {
        s = s + ReadLine()
    }
    ret := make([]int, 9)
    for i, c := range s {
        ret[i] = int(c) - '1'
    }
    return ret
}

func main() {
    prework()

    T := ReadInt()
    for casi := int(0); casi < T; casi++ {
        a := GetPerm()
        b := GetPerm()
        c := make([]int, 9)
        for i := 0; i < 9; i++ {
            c[a[i]] = i
        }
        u := 0
        for i := 0; i < 9; i++ {
            u = u + (c[b[i]] << uint(4 * (8 - i)))
        }
        ans, in := lst[u]
        if in {
            fmt.Println(ans)
        } else {
            fmt.Println("impossible")
        }
    }
}

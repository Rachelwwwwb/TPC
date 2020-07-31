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
    cas := ReadInt(reader)

    const N int = 5000 + 10
    const M int = 1000000000 + 7
    for casi := int(0); casi < cas; casi++ {
        nm := ReadArray(reader)
        n, m := nm[0], nm[1]
        s := ReadLine(reader)

        tn := n / 3
        if tn < m {
            fmt.Println("0")
            continue
        }

        f := make([][]int, 8)
        g := make([][]int, 8)
        for i := 0; i < 8; i++ {
            f[i] = make([]int, tn + 2)
            g[i] = make([]int, tn + 2)
        }

        f[0][0] = 1
        for i := 1; i < 8; i++ {
            f[i][0] = 0
        }
        const ss string = "012"
        for si, c := range s {
            nf := si / 3 + 1

            for i := 1; i < 8; i++ {
                for j := 0; j < nf; j++ {
                    g[i][j] = 0
                }
            }
            var k uint
            for k = 0; k < 3; k++ {
                if c != rune(ss[k]) && c != '?' {
                    continue
                }
                for i := 0; i < 7; i++ {
                    ni := i | 1 << k
                    for j := 0; j < nf; j++ {
                        g[ni][j] = (g[ni][j] + f[i][j]) % M
                    }
                }
            }
            g[0][0] = 0
            for i := 0; i < nf; i++ {
                g[0][i + 1] = g[7][i]
            }
            f, g = g, f
        }
        var ans int = 0
        for i := 0; i < 7; i++ {
            for j := m; j <= tn; j++ {
                ans = (ans + f[i][j]) % M
            }
        }

        fmt.Println(ans)
    }
}

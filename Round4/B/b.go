package main

import (
    "bufio"
    "fmt"
    "os"
    "sort"
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
        n := ReadInt(reader)
        a := ReadArray(reader)
        b := make([]int64, n, n)
        for i := 0; i < n; i++ {
            b[i] = int64(a[i]) << 32 | int64(i)
        }

        mask := (int64(1) << 32) - 1
        sort.Slice(b, func(i, j int) bool {
            return b[i] < b[j]
        })

        var ans int64 = 0
        m := n >> 1
        for i := 0; i < m; i++ {
            if int(b[i] & mask) >= m {
                ans += b[i] & mask
            }
        }
        for i := m; i < n; i++ {
            if int(b[i] & mask) < m {
                ans -= b[i] & mask
            }
        }

        fmt.Println(ans)
    }
}

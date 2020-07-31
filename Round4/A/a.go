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
        n := ReadInt(reader)

        min_val := make([]int, 3)
        max_val := make([]int, 3)
        for i := 0; i < 3; i++ {
            min_val[i] = 1 << 30
            max_val[i] = 0
        }

        var ans int64 = 0
        for i := 0; i < n; i++ {
            a := ReadArray(reader)
            for j := 0; j < n; j++ {
                t := 0
                if i == j {
                    t += 1
                }
                if i + j == n - 1 {
                    t += 1
                }

                if min_val[t] > a[j] {
                    min_val[t] = a[j]
                }
                if max_val[t] < a[j] {
                    max_val[t] = a[j]
                }
                ans += int64(a[j]) * int64(t + 2)
            }
        }

        var ts int64 = 0
        for i := 0; i < 3; i++ {
            for j := 0; j < i; j++ {
                temp := int64(max_val[j] - min_val[i]) * int64(i - j)
                if ts < temp {
                    ts = temp
                }
            }
        }
        ans += ts
        fmt.Println(ans)
    }
}

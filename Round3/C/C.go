package main

import (
    "bufio"
    "fmt"
    "os"
    "strings"
)

func ReadLine(reader *bufio.Reader) string {
    line, _ := reader.ReadString('\n')
    return strings.TrimRight(line, "\n")
}

func check(num int64, k int, K int64) bool {
    if num == 1 {
        return false
    }
    for i := 0; i < k; i++ {
        var j int64 = 3
        for ; j * j <= num; j += 2 {
            if num % j == 0 {
                return false
            }
        }
        num = num % K * 10 + num / K
    }
    return true
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    s := ReadLine(reader)
    n := len(s)
    a := make([]int, n)
    for i := 0; i < n; i++ {
        a[i] = int(s[i] - '0')
    }
    var ans int64 = -1
    prime := [10]int{0, 0, 1, 1, 0, 1, 0, 1, 0, 0}
    use := [10]int{0, 1, 0, 1, 0, 0, 0, 1, 0, 1}
    for i := 0; i < n; i++ {
        if prime[a[i]] == 1 && ans < int64(a[i]){
            ans = int64(a[i])
        }
        if use[a[i]] == 0 {
            continue
        }
        var num, K int64 = 0, 1
        for j := i; j < n && use[a[j]] == 1; j++ {
            num = num * int64(10) + int64(a[j])
            if check(num, j - i + 1, K) && ans < num {
                ans = num
            }
            K *= 10
        }
    }
    fmt.Println(ans)
}

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

var lst = [4][2]string{
        {"TP", "C"},
        {"T", "CP"},
        {"T", "PC"},
        {"PT", "C"}}

func Solve(s *string) int {
    if strings.LastIndex(*s, "C") + 1 < strings.Index(*s, "P") &&
            strings.LastIndex(*s, "P") + 1 < strings.Index(*s, "T") {
        return 3
    }
    if strings.Index(*s, "TPC") != -1 {
        return 0
    }
    if strings.Index(*s, "CPT") != -1 {
        return 1
    }
    for _, a := range lst {
        lid := strings.Index(*s, a[0])
        if lid != -1 && strings.Index((*s)[lid + len(a[0]): ], a[1]) != -1 {
            return 1
        }
    }
    return 2
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    T := ReadInt(reader)
    for casi := int(0); casi < T; casi++ {
        ReadInt(reader)
        s := ReadLine(reader)

        flag := true
        for _, c := range "TPC" {
            flag = flag && strings.Index(s, string(c)) != -1
        }
        if flag {
            fmt.Println(Solve(&s))
        } else {
            fmt.Println("Impossible")
        }
    }
}

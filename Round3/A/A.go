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

var suffixes = []string{"ee", "r", "ve", "le"}
var isprime = []int{0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1}

func main() {
    reader := bufio.NewReader(os.Stdin)
    T := ReadInt(reader)
    for casi := int(0); casi < T; casi++ {
        arr := strings.Split(ReadLine(reader), " ")
        num, _ := strconv.Atoi(arr[0])
        com := 0
        for i := 0; i < 4; i++ {
            if strings.HasSuffix(arr[1], suffixes[i]) {
                com = i
                break
            }
        }
        for i := 0; i < 5; i++ {
            if com < 3 && (num + i) % (com + 3) == 0 ||
                    com == 3 && isprime[num + i] == 1 {
                fmt.Println(i)
                break
            }
        }
    }
}
